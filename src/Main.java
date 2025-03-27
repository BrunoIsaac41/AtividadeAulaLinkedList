import Controller.LivroController;
import Controller.MenuController;
import Model.Biblioteca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LivroController livroController = new LivroController();
        Biblioteca biblioteca = new Biblioteca("bibliotecaPuc", "av Getulio Vargas");
        livroController.criarLivro("Bruno","Isaac",2000, biblioteca);
        livroController.criarLivro("Bruno2","Isaac2",2001, biblioteca);
        livroController.criarLivro("Bruno3","Isaac3",2002, biblioteca);
        livroController.criarLivro("Bruno4","Isaac4",2003, biblioteca);
        MenuController menuController = new MenuController();
        menuController.viewMenuTerminal(biblioteca);

    }
}
