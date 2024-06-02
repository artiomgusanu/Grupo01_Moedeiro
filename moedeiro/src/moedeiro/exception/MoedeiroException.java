package moedeiro.exception;

/**
 * Exceção base para todas as exceções relacionadas ao moedeiro.
 * Esta exceção estende Exception.
 */
public class MoedeiroException extends Exception {

    /**
     * Construtor para criar uma exceção de moedeiro com uma mensagem detalhando o motivo.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     */
    public MoedeiroException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor para criar uma exceção de moedeiro com uma mensagem detalhando o motivo e uma causa raiz.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     * @param cause A causa raiz que levou à exceção.
     */
    public MoedeiroException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
