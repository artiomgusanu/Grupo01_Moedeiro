package moedeiro;

import moedeiro.exception.QuantidadeNegativaException;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um cofre que armazena moedas.
 */

public class Cofre {
	
	// Atributos
    /** Mapa que armazena as moedas e suas quantidades no cofre. */
	private Map <Double, Integer> moedasArmazenadas;

	// Gets e Sets
	

	// Construtor

    /**
     * Construtor padrão que inicializa o cofre sem moedas.
     */

	public Cofre() {
		super();
		moedasArmazenadas = new HashMap<>();
	}

	// Comportamentos

    /**
     * Adiciona moedas ao cofre.
     *
     * @param valorMoeda O valor da moeda a ser adicionada.
     * @param quantidade A quantidade de moedas a ser adicionada.
     * @throws IllegalArgumentException Se a quantidade de moedas for negativa.
     */


	public void adicionarMoeda(double valorMoeda, int quantidade) throws QuantidadeNegativaException {
        // e se quantidade for < 0 ?
        if (quantidade < 0) {
            throw new QuantidadeNegativaException("A quantidade de moedas não pode ser negativa");
        }
        final int quantidadeAtual =  moedasArmazenadas.getOrDefault(valorMoeda, 0);
        moedasArmazenadas.put(valorMoeda, quantidadeAtual + quantidade);
    }

    /**
     * Calcula o valor total de todas as moedas armazenadas no cofre.
     *
     * @return o valor total das moedas no cofre
     */

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Map.Entry<Double, Integer> entry : moedasArmazenadas.entrySet()) {
            valorTotal += entry.getKey() * entry.getValue();
        }
        return valorTotal;
    }


    
    // Método para contar o número de moedas de cada tipo  /  (REVER) Explicar melhor o porquê de termos usado o clone

    /**
     * Retorna um mapa contendo o número de moedas de cada tipo armazenadas no cofre.
     *
     * Este método cria e retorna uma cópia do mapa que representa a quantidade de cada tipo de moeda
     * armazenada no cofre. Retornar uma cópia do mapa garante que o estado interno do cofre não
     * possa ser modificado diretamente por código externo, preservando a integridade dos dados.
     *
     *
     * @return Um mapa contendo a quantidade de moedas de cada tipo.
     */

    public Map<Double, Integer> getMoedasPorTipo() {
        return new HashMap<>(moedasArmazenadas);
    }
    
    // Método para contar o número total de moedas no cofre						(REVER)

    /**
     * Conta o número total de moedas armazenadas no cofre.
     *
     * @return o número total de moedas no cofre
     */

    public int contarTotalMoedas() {
        int totalMoedas = 0;
        for (int quantidade : moedasArmazenadas.values()) {
            totalMoedas += quantidade;
        }
        return totalMoedas;
    }

    // Outras

}
