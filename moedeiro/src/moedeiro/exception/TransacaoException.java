package moedeiro.exception;

import java.util.Map;

/**
 * Exceção lançada quando ocorre um erro durante uma transação relacionada ao moedeiro.
 * Esta exceção pode conter informações sobre as moedas devolvidas.
 */
public class TransacaoException extends MoedeiroException {
    private Map<Double, Integer> moedasDevolvidas;

    /**
     * Construtor que recebe uma mensagem de erro e um mapa de moedas devolvidas.
     *
     * @param mensagem a mensagem de erro
     * @param moedasDevolvidas um mapa contendo as moedas devolvidas durante a transação
     */
    public TransacaoException(String mensagem, Map<Double, Integer> moedasDevolvidas) {
        super(mensagem);
        this.moedasDevolvidas = moedasDevolvidas;
    }

    /**
     * Obtém o mapa de moedas devolvidas durante a transação.
     *
     * @return um mapa contendo as moedas devolvidas
     */
    public Map<Double, Integer> getMoedasDevolvidas() {
        return moedasDevolvidas;
    }
}
