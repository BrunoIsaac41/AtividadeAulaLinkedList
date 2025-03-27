package Controller;

import Model.Biblioteca;
import Model.Livro;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class BibliotecaController {

    public Biblioteca criarBiblioteca(String nome, String endereco) throws IOException {
        Biblioteca biblioteca = new Biblioteca(nome, endereco);
        return biblioteca;
    }

    public void adicionarLivroNaBiblioteca(Biblioteca biblioteca, Livro livro){
        LinkedList<Livro> livros = biblioteca.getLivros();
        livros.add(livro);
    }
    public Livro verLivros(Biblioteca biblioteca) {
        LinkedList<Livro> livros = biblioteca.getLivros();

        try {
            if (livros.get(0) != null) {
                return livros.get(0);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("A biblioteca está vazia! " + e.getMessage());
            return null;
        }
        return null;
    }

    public Livro proximoLivro(Biblioteca biblioteca, Livro livroAtual){
        LinkedList<Livro> livros = biblioteca.getLivros();
        try {

            if (livros.indexOf(livroAtual) < livros.size()) {
                Livro proximo_livro = livros.get(livros.indexOf(livroAtual) + 1);
                return proximo_livro;
            }

        }catch (IndexOutOfBoundsException e) {

            Livro proximo_livro = livros.getFirst();
            return proximo_livro;

        }
        return null;
    }

    public Livro anteriorLivro(Biblioteca biblioteca, Livro livroAtual){
        LinkedList<Livro> livros = biblioteca.getLivros();

        if (livros.indexOf(livroAtual) > 0){
            Livro livro_anterior = livros.get(livros.indexOf(livroAtual) - 1);
            return livro_anterior;
        }
        else{
            Livro livro_anterior = livros.getLast();
            return livro_anterior;
        }
    }
}
