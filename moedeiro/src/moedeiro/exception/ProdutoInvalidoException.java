package moedeiro.exception;

/**
 * Exceção lançada quando um produto é considerado inválido em operações relacionadas ao moedeiro.
 * Esta exceção estende MoedeiroException.
 */
public class ProdutoInvalidoException extends MoedeiroException {

    /**
     * Construtor para criar uma exceção de produto inválido com uma mensagem detalhando o motivo.
     *
     * @param mensagem A mensagem detalhando o motivo da exceção.
     */
    public ProdutoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
