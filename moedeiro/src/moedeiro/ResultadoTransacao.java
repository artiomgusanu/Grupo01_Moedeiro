package moedeiro;

import java.util.Map;

/**
 * A classe ResultadoTransacao representa o resultado de uma transação monetária.
 */
public class ResultadoTransacao {

    // Atributos
    private Map<Double, Integer> trocoDevolvido;
    private boolean sucesso;

    // Gets e Sets
    /**
     * Retorna o mapa de troco devolvido na transação.
     *
     * @return o mapa de troco devolvido
     */
    public Map<Double, Integer> getTrocoDevolvido() {
        return trocoDevolvido;
    }

    // Construtor
    /**
     * Construtor da classe ResultadoTransacao.
     *
     * @param trocoDevolvido o mapa de troco devolvido na transação
     * @param sucesso indica se a transação foi bem-sucedida ou não
     */
    public ResultadoTransacao(Map<Double, Integer> trocoDevolvido, boolean sucesso) {
        this.trocoDevolvido = trocoDevolvido;
        this.sucesso = sucesso;
    }

    // Comportamentos
    /**
     * Verifica se a transação foi bem-sucedida.
     *
     * @return true se a transação foi bem-sucedida, false caso contrário
     */
    public boolean isSucesso() {
        return sucesso;
    }

    // Outras
}
