package moedeiro;

import java.util.Map;

public class ResultadoTransacao {

    // Atributos
    private Map<Double, Integer> trocoDevolvido;
    private boolean sucesso;

    // Gets e Sets
    public Map<Double, Integer> getTrocoDevolvido() {
        return trocoDevolvido;
    }

    // Construtor
    public ResultadoTransacao(Map<Double, Integer> trocoDevolvido, boolean sucesso) {
        this.trocoDevolvido = trocoDevolvido;
        this.sucesso = sucesso;
    }

    // Comportamentos
    public boolean isSucesso() {
        return sucesso;
    }

    // Outras
}
