
package Controller;

import Model.*;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Model.Historico.Registro;

import static java.util.Optional.empty;

public class MenuController {
    private final BibliotecaController bibliotecaController = new BibliotecaController();
    private final LivroController livroController = new LivroController();
    private final ListaDeEsperaLivroController listaDeEsperaLivroController = new ListaDeEsperaLivroController();
    private final HistoricoController historicoController = new HistoricoController();

    public MenuController() {}

    public void mostrarLivro(Livro livro) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                        livro.getAutor() +
                "\n" + livro.getAnoPublicacao() +
                "\n" + livro.getTitulo() +
                "\n"
        );

        Object[] listaDeEsperaLivro = livro.getListaDeEsperaLivros().toArray();
        String titulo = livro.getTitulo();

        // System.out.println("Fila para alugar " + titulo +":");
        //for(int i = 0; i < listaDeEsperaLivro.length; ++i) {
           //System.out.println((i + 1)+" - " + String.valueOf(listaDeEsperaLivro[i]));
        //}


        if (listaDeEsperaLivro.length == 0)
        {
            String nome;
            int resposta;
            System.out.println("Este livro está disponível para alugar!");
            System.out.println("Deseja alugar este livro? (1 para Sim/ 2 para Não)");
            resposta = scanner.nextInt();
            scanner.nextLine();

            if (resposta == 1)
            {
                try {
                    System.out.println("Digite seu nome:\n");
                    nome = scanner.nextLine();
                    this.listaDeEsperaLivroController.inscreverParaAlugar(livro, nome);
                    System.out.println("Você alugou "+titulo);

                }catch (Exception e) {

                    e.printStackTrace();
                }

            }else if (resposta == 2) {
                return;
            }
        } else
            {
                System.out.println("Fila para alugar:");
                for(int i = 0; i < listaDeEsperaLivro.length; ++i) {
                    System.out.println((i + 1)+" - " + String.valueOf(listaDeEsperaLivro[i]));
                }

                System.out.println("Deseja entrar na fila para alugar este livro? (1 para Sim/ 2 para Não)");
                int resposta = scanner.nextInt();
                String nome;

                if (resposta == 1)
                {
                    scanner.nextLine();
                    System.out.println("Digite seu nome:");
                    nome = scanner.nextLine();
                    this.listaDeEsperaLivroController.inscreverParaAlugar(livro, nome);
                    Queue<String> fila = livro.getListaDeEsperaLivros();
                    int posicao = ((LinkedList)fila).indexOf(nome) + 1;
                    System.out.println("Sua posição é: "+ posicao);

                }
                else if (resposta == 2)
                {
                    return;
                }
            }

    }

    public void viewMenuTerminal(Biblioteca biblioteca,GrafoSimilaridade grafoSimilaridade) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(
                    "\n"+"Digite a opcção desejada:" +
                    "\n0: Sair" +
                    "\n1: Mostrar a Biblioteca Livro a Livro" +
                    "\n2: Criar Livro" +
                    "\n3: Mostrar Histórico"
            );
            int opcaoMenu = scanner.nextInt();
            scanner.nextLine();

            if (opcaoMenu == 0)
            {
                System.out.println("saindo..");
                return;
            }
            else if (opcaoMenu == 1)
            {
                Livro livro = this.bibliotecaController.verLivros(biblioteca);

                if (livro == null)
                {
                    System.out.println("A biblioteca está vazia!");
                }
                else
                {
                    this.mostrarLivro(livro);
                    historicoController.adicionarHistorico(livro.getTitulo());
                }

                while(true) {
                    System.out.println(
                            "\n"+"Digite '0' para voltar ao menu principal," +
                            "\n'1' para ir ao proximo livro" +
                            "\n'2' para ir ao anterior" +
                            "\n'3' para mostrar as recomendações de acordo com este livro"
                    );
                    int acao = scanner.nextInt();

                    if (acao == 0)
                    {
                        break;
                    }

                    Livro livro_anterior;
                    if (acao == 1)
                    {
                        livro_anterior = this.bibliotecaController.proximoLivro(biblioteca, livro);
                        this.mostrarLivro(livro_anterior);
                        livro = livro_anterior;
                        historicoController.adicionarHistorico(livro.getTitulo());
                    }
                    else if (acao == 2)
                    {
                        livro_anterior = this.bibliotecaController.anteriorLivro(biblioteca, livro);
                        this.mostrarLivro(livro_anterior);
                        livro = livro_anterior;
                        historicoController.adicionarHistorico(livro.getTitulo());
                    }
                    else if (acao ==3)
                    {
                        Map <Livro, Integer> similares = Dijkstra.dijkstraSimples(grafoSimilaridade.grafoRecomendacoes, livro);

                        System.out.println("Similares à " + livro.getTitulo() + ": ");

                        similares.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue())
                                .forEach(entry ->
                                        System.out.println(entry.getKey().getTitulo() + " Distancia: " + entry.getValue())
                                );

                    }
                }
            }
            else if (opcaoMenu == 2)
            {
                scanner.nextLine();
                System.out.println("Digite o Autor do Livro:");
                String autor = scanner.nextLine();
                System.out.println("Digite o titulo do Livro:");
                String titulo = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Digite o ano de publicação do Livro:");
                Integer anoPublicacao = scanner.nextInt();
                scanner.nextLine();
                //String novoLivro = this.livroController.criarLivro(autor, titulo, anoPublicacao, biblioteca);
                //System.out.println(novoLivro);
            }

            if (opcaoMenu == 3)
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                Stack <Registro> registros = historicoController.getHistorico();

                if (!registros.isEmpty())
                {
                    System.out.println("Histórico: ");
                    for (int i = 0; i < registros.size(); i++) {
                        System.out.println( registros.get(i).getTituloLivro() +" "+ registros.get(i).getTimestamp().format(formatter));
                    }
                }
                else
                {
                    String message =  "Histórico vazio.";
                    System.out.println(message+"\n");
                    continue;
                }
            }
        }
    }

    //public Livro getLivroAtual(LinkedList<Livro> livros, Livro livro){

}
