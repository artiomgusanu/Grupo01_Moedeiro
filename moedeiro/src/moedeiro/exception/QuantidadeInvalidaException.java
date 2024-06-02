package moedeiro.exception;

/**
 * Exceção lançada quando uma quantidade é considerada inválida em uma operação relacionada ao moedeiro.
 */
public class QuantidadeInvalidaException extends MoedeiroException{


    /**
     * Construtor que recebe uma mensagem de erro personalizada.
     *
     * @param mensagem a mensagem de erro
     */
    public QuantidadeInvalidaException(String mensagem){
        super(mensagem);
    }
}
