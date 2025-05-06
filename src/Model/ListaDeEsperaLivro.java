package Model;

import java.util.LinkedList;
import java.util.Queue;

public class ListaDeEsperaLivro {
    private Queue<String> lista_de_espera;

    public ListaDeEsperaLivro() {
    }

    public Queue ListaDeEsperaLivro() {
        this.lista_de_espera = new LinkedList();
        return this.lista_de_espera;
    }
}
