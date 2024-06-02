package moedeiro.exception;

/**
 * Exceção lançada quando não há moedas suficientes para completar uma operação no moedeiro.
 * Esta exceção estende MoedeiroException.
 */
public class MoedasInsuficientesException extends MoedeiroException {

    /**
     * Construtor para criar uma exceção de moedas insuficientes com uma mensagem detalhando o motivo.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     */
    public MoedasInsuficientesException(String mensagem) {
        super(mensagem);
    }
}
