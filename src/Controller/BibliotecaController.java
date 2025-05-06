package Controller;

import Model.Biblioteca;
import Model.Livro;
import java.io.IOException;
import java.util.LinkedList;

public class BibliotecaController {
    public BibliotecaController() {
    }

    public Biblioteca criarBiblioteca(String nome, String endereco) throws IOException {
        Biblioteca biblioteca = new Biblioteca(nome, endereco);
        return biblioteca;
    }

    public void adicionarLivroNaBiblioteca(Biblioteca biblioteca, Livro livro) {
        LinkedList<Livro> livros = biblioteca.getLivros();
        livros.add(livro);
    }

    public Livro verLivros(Biblioteca biblioteca) {
        LinkedList<Livro> livros = biblioteca.getLivros();

        try {
            return livros.get(0) != null ? (Livro)livros.get(0) : null;
        } catch (IndexOutOfBoundsException var4) {
            IndexOutOfBoundsException e = var4;
            System.err.println("A biblioteca está vazia! " + e.getMessage());
            return null;
        }
    }

    public Livro proximoLivro(Biblioteca biblioteca, Livro livroAtual) {
        LinkedList<Livro> livros = biblioteca.getLivros();

        try {
            if (livros.indexOf(livroAtual) < livros.size()) {
                Livro proximo_livro = (Livro)livros.get(livros.indexOf(livroAtual) + 1);
                return proximo_livro;
            } else {
                return null;
            }
        } catch (IndexOutOfBoundsException var6) {
            Livro proximo_livro = (Livro)livros.getFirst();
            return proximo_livro;
        }
    }

    public Livro anteriorLivro(Biblioteca biblioteca, Livro livroAtual) {
        LinkedList<Livro> livros = biblioteca.getLivros();
        Livro livro_anterior;
        if (livros.indexOf(livroAtual) > 0) {
            livro_anterior = (Livro)livros.get(livros.indexOf(livroAtual) - 1);
            return livro_anterior;
        } else {
            livro_anterior = (Livro)livros.getLast();
            return livro_anterior;
        }
    }
}
