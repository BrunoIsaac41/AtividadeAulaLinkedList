package Model;

import java.time.LocalDateTime;
import java.util.Stack;

public class Historico {
    protected Stack<Registro> historico = new Stack();

    public Historico() {
    }

    public Stack<Registro> getHistorico() {
        return this.historico;
    }

    public void setHistorico(Stack<Registro> historico) {
        this.historico = historico;
    }

    public static class Registro {
        protected String tituloLivro;
        protected LocalDateTime timestamp;

        public Registro(String tituloLivro) {
            this.tituloLivro = tituloLivro;
            this.timestamp = LocalDateTime.now();
        }

        public String getTituloLivro(){
            return tituloLivro;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
}



