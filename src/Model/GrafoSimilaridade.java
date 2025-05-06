package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GrafoSimilaridade {
    public HashMap<Livro, Set<Livro>> grafoRecomendacoes;
    Set<Livro> similares;

    public GrafoSimilaridade(){
        grafoRecomendacoes = new HashMap<>();
    }

    public void adicionarLivro (Livro livro){
        grafoRecomendacoes.putIfAbsent(livro, new HashSet<>());
    }

    public void criarAresta(Livro livroOrigem, Livro livroDestino){
        grafoRecomendacoes.putIfAbsent(livroOrigem, new HashSet<>());
        grafoRecomendacoes.putIfAbsent(livroDestino, new HashSet<>());

        grafoRecomendacoes.get(livroOrigem).add(livroDestino);
        grafoRecomendacoes.get(livroDestino).add(livroOrigem);

    }

    public Set getSimilares(Livro livro){
        return grafoRecomendacoes.get(livro);
    }
}
