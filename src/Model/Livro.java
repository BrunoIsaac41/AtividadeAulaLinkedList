package Model;

import Controller.BibliotecaController;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Livro {
    protected String autor;
    protected String titulo;
    protected int anoPublicacao;
    protected Queue<String> listaDeEsperaLivro;

    public Livro(String autor, String titulo, int anoPublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.listaDeEsperaLivro = new LinkedList();
    }

    public String getAutor() {
        return this.autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public Queue getListaDeEsperaLivros() {
        return this.listaDeEsperaLivro;
    }

    public void setListaDeEsperaLivros(Queue listaDeEsperaLivros) {
        this.listaDeEsperaLivro = listaDeEsperaLivros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return anoPublicacao == livro.anoPublicacao &&
                Objects.equals(autor, livro.autor) &&
                Objects.equals(titulo, livro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, titulo, anoPublicacao);
    }
}
