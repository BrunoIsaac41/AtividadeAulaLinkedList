//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Controller;

import Model.Historico;
import java.util.Stack;

public class HistoricoController {
    Stack<Historico.Registro> pilhaHistorico;
    Historico historico = new Historico();

    public HistoricoController() {
        adicionarHistorico("Isaac");
        adicionarHistorico("Isaac2");
        pilhaHistorico = historico.getHistorico();

    }

    public void adicionarHistorico(String tituloLivro) {
        try {
            if (tituloLivro != null && !tituloLivro.isEmpty()) {
                Historico.Registro registro = new Historico.Registro(tituloLivro);
                this.pilhaHistorico.push(registro);
                this.historico.setHistorico(this.pilhaHistorico);
            }else {
                throw new Exception("Registro vazio.");
            }
        } catch (Exception e) {
            return;
        }
    }

    public Stack<Historico.Registro> getHistorico() {
        return this.pilhaHistorico;
    }

    public void limparHistorico() {
        this.pilhaHistorico.clear();
        this.historico.setHistorico(this.pilhaHistorico);
    }
}
