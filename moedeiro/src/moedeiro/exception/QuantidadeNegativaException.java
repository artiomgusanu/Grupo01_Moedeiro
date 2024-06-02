package moedeiro.exception;

/**
 * Exceção lançada quando uma quantidade negativa é fornecida onde não é permitido.
 * Esta exceção estende MoedeiroException.
 */
public class QuantidadeNegativaException extends MoedeiroException {

    /**
     * Construtor para criar uma exceção de quantidade negativa com uma mensagem detalhando o motivo.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     */
    public QuantidadeNegativaException(String mensagem) {
        super(mensagem);
    }
}
