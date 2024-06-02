package moedeiro.validator;

/**
 * Classe para validação de moedas.
 */
public class ValidarMoedasValidator {

    /**
     * Valida se a quantidade de moedas for positiva.
     *
     * @param quantidade A quantidade de moedas a ser validada.
     * @return {@code true} se a quantidade for maior ou igual a zero; {@code false} caso contrário.
     */
    public static boolean validarQuantidade(int quantidade) {
        return quantidade >= 0;
    }
}
