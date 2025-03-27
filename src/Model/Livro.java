package Model;

public class Livro {
    protected String autor;
    protected String titulo;
    protected int anoPublicacao;

    public Livro(String autor, String titulo, int anoPublicacao){
        this.autor = autor;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;

    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}
