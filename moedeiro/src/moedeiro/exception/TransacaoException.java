package moedeiro.exception;

import java.util.Map;

/**
 * Exceção lançada quando ocorre um erro durante uma transação no moedeiro.
 */
public class TransacaoException extends MoedeiroException {

    /** Mapa contendo as moedas devolvidas em caso de falha na transação, onde as chaves são os valores das moedas e os valores são as quantidades de cada moeda. */
    private Map<Double, Integer> moedasDevolvidas;

    /**
     * Construtor para criar uma exceção de transação com uma mensagem e moedas devolvidas.
     *
     * @param mensagem A mensagem de erro detalhando a causa da exceção.
     * @param moedasDevolvidas Um mapa contendo as moedas devolvidas, onde as chaves são os valores das moedas e os valores são as quantidades de cada moeda.
     */
    public TransacaoException(String mensagem, Map<Double, Integer> moedasDevolvidas) {
        super(mensagem);
        this.moedasDevolvidas = moedasDevolvidas;
    }

    /**
     * Retorna as moedas devolvidas em caso de falha na transação.
     *
     * @return Um mapa onde as chaves são os valores das moedas e os valores são as quantidades de cada moeda.
     */
    public Map<Double, Integer> getMoedasDevolvidas() {
        return moedasDevolvidas;
    }
}
