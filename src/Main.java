import Controller.BibliotecaController;
import Controller.LivroController;
import Controller.MenuController;
import Model.Biblioteca;
import Model.GrafoSimilaridade;
import Model.Livro;


public class Main {
    public static void main(String[] args) {
        GrafoSimilaridade grafoSimilaridade = new GrafoSimilaridade();
        LivroController livroController = new LivroController();
        MenuController menuController = new MenuController();
        BibliotecaController bibliotecaController = new BibliotecaController();

        Biblioteca biblioteca = new Biblioteca("bibliotecaPuc", "av Getulio Vargas");


        Livro livro2 =  livroController.criarLivro("Bruno5","Livro2",2001, biblioteca);

        Livro livro3 =  livroController.criarLivro("Bruno4","Livro3",2002, biblioteca);

        Livro livro4 =  livroController.criarLivro("Bruno1","Livro4",2003, biblioteca);

        Livro livro5 =  livroController.criarLivro("Bruno2","Livro5",2004, biblioteca);

        Livro livro6 =  livroController.criarLivro("Bruno3","Livro6",2005, biblioteca);

        Livro livro1 = livroController.criarLivro("Bruno8","Livro7",2006, biblioteca);

        Livro livroBruno = livroController.criarLivro("Bruno7","LivroBruno",2007, biblioteca);

        Livro livroKatia = livroController.criarLivro("Bruno0","LivroKatia",2008, biblioteca);

        grafoSimilaridade.criarAresta(livroKatia, livroBruno);
        grafoSimilaridade.criarAresta(livroKatia, livro3);
        grafoSimilaridade.criarAresta(livro2, livro3);
        grafoSimilaridade.criarAresta(livro2, livro4);
        grafoSimilaridade.criarAresta(livro3, livro4);
        grafoSimilaridade.criarAresta(livro4, livro5);
        grafoSimilaridade.criarAresta(livro5, livro6);
        grafoSimilaridade.criarAresta(livro5, livro4);
        menuController.viewMenuTerminal(biblioteca, grafoSimilaridade);

    }
}
