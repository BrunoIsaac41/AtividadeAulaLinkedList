package Model;

import java.util.*;

public class Dijkstra {
    Map<Livro, Integer> livroMaisProximo ;

    public static Map<Livro, Integer> dijkstraSimples (HashMap<Livro, Set<Livro>> grafo, Livro origem) {

        Map<Livro, Integer> distancias = new HashMap<>();

        Queue<Livro> fila = new LinkedList<>();


        distancias.put(origem, 0); // como não temos pesos entre os nós, o peso padrão é 0

        fila.add(origem);


        while (!fila.isEmpty()) {

            Livro atual = fila.poll();

            int distanciaAtual = distancias.get(atual);


            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {

                if (!distancias.containsKey(vizinho)) {

                    distancias.put(vizinho, distanciaAtual + 1);

                    fila.add(vizinho);

                }

            }

        }

        return distancias;
    }
}
