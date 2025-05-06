package Controller;

import Model.Livro;
import java.util.Queue;
import java.util.Scanner;

public class ListaDeEsperaLivroController {
    public ListaDeEsperaLivroController() {
        new Scanner(System.in);
    }

    public void inscreverParaAlugar(Livro livro, String nomeUsuario) {
        Queue fila = livro.getListaDeEsperaLivros();
        fila.add(nomeUsuario);
        livro.setListaDeEsperaLivros(fila);
    }
}
