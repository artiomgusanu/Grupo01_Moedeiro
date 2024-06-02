package moedeiro.exception;


/**
 * Exceção lançada quando não há moedas suficientes em um tubo de moedas.
 */
public class MoedasInsuficientesException extends MoedeiroException{

    /**
     * Construtor que recebe uma mensagem de erro personalizada.
     *
     * @param mensagem a mensagem de erro
     */
    public MoedasInsuficientesException(String mensagem) {
        super(mensagem);
    }
}
