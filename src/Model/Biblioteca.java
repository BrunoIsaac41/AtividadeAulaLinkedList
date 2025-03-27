package Model;

import javax.naming.BinaryRefAddr;
import java.util.LinkedList;

public class Biblioteca {
    protected String nome;
    protected String endereco;
    protected LinkedList<Livro> Livros;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.Livros = new LinkedList<Livro>();

    }


    public LinkedList<Livro> getLivros() {
        return Livros;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
