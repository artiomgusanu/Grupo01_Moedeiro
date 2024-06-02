package moedeiro.exception;

/**
 * Exceção lançada quando uma quantidade é considerada inválida em contexto de operações no moedeiro.
 * Esta exceção estende MoedeiroException.
 */
public class QuantidadeInvalidaException extends MoedeiroException {

    /**
     * Construtor para criar uma exceção de quantidade inválida com uma mensagem detalhando o motivo.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     */
    public QuantidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}
