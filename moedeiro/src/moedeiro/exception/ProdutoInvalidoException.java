package moedeiro.exception;

/**
 * Exceção lançada quando um produto é inválido em uma operação relacionada ao moedeiro.
 */
public class ProdutoInvalidoException extends MoedeiroException {

    /**
     * Construtor que recebe uma mensagem de erro personalizada.
     *
     * @param mensagem a mensagem de erro
     */
    public ProdutoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
