package moedeiro.validator;

/**
 * Classe utilitária para validar a quantidade de moedas.
 */
public class ValidarMoedasValidator {

    /**
     * Valida se a quantidade de moedas é um valor não negativo.
     *
     * @param quantidade a quantidade de moedas a ser validada
     * @return true se a quantidade de moedas for não negativa, false caso contrário
     */
	public static boolean validarQuantidade(int quantidade) {
        return quantidade >= 0;
    }
}
