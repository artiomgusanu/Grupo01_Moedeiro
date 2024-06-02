package moedeiro.exception;

import java.util.Map;

public class TransacaoException extends MoedeiroException {
    private Map<Double, Integer> moedasDevolvidas;

    public TransacaoException(String mensagem, Map<Double, Integer> moedasDevolvidas) {
        super(mensagem);
        this.moedasDevolvidas = moedasDevolvidas;
    }

    public Map<Double, Integer> getMoedasDevolvidas() {
        return moedasDevolvidas;
    }
}
