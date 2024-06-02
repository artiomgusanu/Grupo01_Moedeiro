package moedeiro;

import java.util.Map;

/**
 * Representa o resultado de uma transação, incluindo o troco devolvido e o estado de sucesso da transação.
 */
public class ResultadoTransacao {

    // Atributos

    /** Mapa que armazena o troco devolvido, onde as chaves são os valores das moedas e os valores são as quantidades de cada moeda. */
    private Map<Double, Integer> trocoDevolvido;

    /** Indica se a transação foi bem-sucedida. */
    private boolean sucesso;

    // Construtor

    /**
     * Construtor para criar um resultado de transação.
     *
     * @param trocoDevolvido O mapa contendo o troco devolvido, onde as chaves são os valores das moedas e os valores são as quantidades de cada moeda.
     * @param sucesso Indica se a transação foi bem-sucedida.
     */
    public ResultadoTransacao(Map<Double, Integer> trocoDevolvido, boolean sucesso) {
        this.trocoDevolvido = trocoDevolvido;
        this.sucesso = sucesso;
    }

    // Gets e Sets

    /**
     * Retorna o troco devolvido pela transação.
     *
     * @return Um mapa onde as chaves são os valores das moedas e os valores são as quantidades de cada moeda.
     */
    public Map<Double, Integer> getTrocoDevolvido() {
        return trocoDevolvido;
    }

    // Comportamentos

    /**
     * Indica se a transação foi bem-sucedida.
     *
     * @return {@code true} se a transação foi bem-sucedida; {@code false} caso contrário.
     */
    public boolean isSucesso() {
        return sucesso;
    }

    // Outras

}
