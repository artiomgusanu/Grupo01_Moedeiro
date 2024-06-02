package moedeiro.exception;

/**
 * Exceção lançada quando há um excesso de moedas em uma operação no moedeiro.
 * Esta exceção estende MoedeiroException.
 */
public class ExcessoMoedasException extends MoedeiroException {

    /**
     * Construtor para criar uma exceção de excesso de moedas com uma mensagem detalhando o motivo e o valor do excesso.
     *
     * @param message A mensagem detalhando o motivo da exceção.
     * @param excesso O valor do excesso de moedas.
     */
    public ExcessoMoedasException(String message, int excesso) {
        super(message + " Excesso: " + excesso);
    }
}
