package Controller;

import Model.Biblioteca;
import Model.Livro;

import java.io.InputStream;
import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;

public class MenuController {
    BibliotecaController bibliotecaController = new BibliotecaController();
    LivroController livroController = new LivroController();
    public void viewMenuTerminal(Biblioteca biblioteca){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Digite a opcção desejada:\n" +
                    "0: Sair\n" +
                    "1: Mostrar a Biblioteca Livro a Livro\n" +
                    "2: Criar Livro\n"
                    );
            int opcaoMenu = scanner.nextInt();
            scanner.nextLine();

                if(opcaoMenu == 0) {
                    System.out.println("saindo..");
                    return;
                }
                if (opcaoMenu == 1){

                    Livro livro = bibliotecaController.verLivros(biblioteca);

                    if (livro == null){
                        System.out.println("A biblioteca está vazia!");
                    }

                    System.out.println(
                        livro.getAutor()+
                        "\n"+
                        livro.getAnoPublicacao()+
                        "\n"+
                        livro.getTitulo()+
                        "\n");


                    while (true) {

                        System.out.println("Digite '0' para voltar ao menu principal, '1' para ir ao proximo livro e '2' para ir ao anterior");
                        int acao = scanner.nextInt();

                            if(acao == 0){
                                break;
                            }

                            if(acao == 1){
                                Livro proximo_livro = bibliotecaController.proximoLivro(biblioteca, livro);

                                System.out.println(
                                    proximo_livro.getAutor() +
                                    "\n" +
                                    proximo_livro.getAnoPublicacao() +
                                    "\n" +
                                    proximo_livro.getTitulo() +
                                    "\n"
                                );
                                livro = proximo_livro;

                                continue;
                            }
                            if (acao == 2) {
                                Livro livro_anterior = bibliotecaController.anteriorLivro(biblioteca, livro);
                                System.out.println(
                                    livro_anterior.getAutor() +
                                    "\n" +
                                    livro_anterior.getAnoPublicacao() +
                                    "\n" +
                                    livro_anterior.getTitulo() +
                                    "\n");
                                livro = livro_anterior;
                                continue;
                            }
                        }
                    }

                if (opcaoMenu == 2) {

                    System.out.println("Digite o Autor do Livro:");
                    scanner.nextLine();
                    String autor = scanner.nextLine();
                    System.out.println("Digite o titulo do Livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o ano de publicação do Livro:");
                    Integer anoPublicacao = scanner.nextInt();
                    scanner.nextLine();
                    String novoLivro = livroController.criarLivro(autor, titulo, anoPublicacao, biblioteca);
                    System.out.println(novoLivro);
                }
        }
    }
}


