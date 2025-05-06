package Controller;

import Model.Biblioteca;
import Model.Livro;

public class LivroController {
    ListaDeEsperaLivroController listaDeEsperaLivroController = new ListaDeEsperaLivroController();

    public LivroController() {
    }

    public Livro criarLivro(String autor, String titulo, int anoPublicacao, Biblioteca biblioteca) {
        try {
            Livro livro = new Livro(autor, titulo, anoPublicacao);
            BibliotecaController bibliotecaController = new BibliotecaController();
            bibliotecaController.adicionarLivroNaBiblioteca(biblioteca, livro);
            String message = "Livro criado e adicionado na biblioteca: " + biblioteca.getNome();
            this.listaDeEsperaLivroController.inscreverParaAlugar(livro, "Bruno");
            this.listaDeEsperaLivroController.inscreverParaAlugar(livro, "Bruno2");
            this.listaDeEsperaLivroController.inscreverParaAlugar(livro, "Bruno3");
            return livro;

        } catch (Exception e) {
            String message = e.getMessage();
            return new Livro("Brunss", "ssss",2000);
        }
    }
}
