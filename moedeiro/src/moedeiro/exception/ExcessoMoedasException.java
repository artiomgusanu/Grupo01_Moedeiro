package moedeiro.exception;

/**
 * Exceção lançada quando uma quantidade de moedas excede a capacidade máxima permitida em um tubo de moedas.
 */
public class ExcessoMoedasException extends MoedeiroException {

    /**
     * Construtor que recebe uma mensagem de erro personalizada e a quantidade de moedas que excede a capacidade máxima.
     *
     * @param message a mensagem de erro
     * @param excesso a quantidade de moedas que excede a capacidade máxima
     */
    public ExcessoMoedasException(String message, int excesso) {
        super(message + " Excesso: " + excesso);
    }
}
