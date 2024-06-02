package moedeiro.exception;

/**
 * Classe base para exceções relacionadas ao moedeiro de uma máquina de vendas.
 */
public class MoedeiroException extends Exception {

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param mensagem a mensagem de erro
     */
    public MoedeiroException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor que recebe uma mensagem de erro e uma causa.
     *
     * @param mensagem a mensagem de erro
     * @param cause    a causa da exceção
     */
    public MoedeiroException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
