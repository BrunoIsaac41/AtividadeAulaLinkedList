package Controller;

import Model.Biblioteca;
import Model.Livro;


public class LivroController {

    public String criarLivro(String autor, String titulo, int anoPublicacao, Biblioteca biblioteca){
        try {
            Livro livro = new Livro(autor, titulo, anoPublicacao);
            BibliotecaController bibliotecaController = new BibliotecaController();
            bibliotecaController.adicionarLivroNaBiblioteca(biblioteca, livro);
            String message = "Livro criado e adicionado na biblioteca: "+biblioteca.getNome();
            return message;
        }
        catch (Exception e){
            String message = e.getMessage();
            return message;
        }
    }


}
