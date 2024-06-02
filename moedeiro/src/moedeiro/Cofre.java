package moedeiro;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * A classe Cofre representa o cofre onde as moedas são armazenadas em uma máquina de vendas.
 */
public class Cofre {
	
	// Atributos
	private Map <Double, Integer> moedasArmazenadas;

	// Gets e Sets
	

	// Construtor
    /**
     * Construtor da classe Cofre.
     */
	public Cofre() {
		super();
		moedasArmazenadas = new HashMap<>();
	}

	// Comportamentos
    /**
     * Adiciona moedas ao cofre.
     *
     * @param valorMoeda o valor da moeda a ser adicionada
     * @param quantidade a quantidade de moedas a ser adicionada
     * @throws IllegalArgumentException se a quantidade de moedas for negativa
     */
	public void adicionarMoeda(double valorMoeda, int quantidade) {
        // e se quantidade for < 0 ?
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade de moedas não pode ser negativo");
        }
        final int quantidadeAtual =  moedasArmazenadas.getOrDefault(valorMoeda, 0);
        moedasArmazenadas.put(valorMoeda, quantidadeAtual + quantidade);
    }


    /**
     * Calcula o valor total de todas as moedas no cofre.
     *
     * @return o valor total de todas as moedas no cofre
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
     * Retorna um mapa contendo a quantidade de moedas de cada tipo armazenadas no cofre.
     *
     * @return um mapa contendo a quantidade de moedas de cada tipo
     */
    public Map<Double, Integer> getMoedasPorTipo() {
        return new HashMap<>(moedasArmazenadas);
    }
    
    // Método para contar o número total de moedas no cofre						(REVER)
    /**
     * Conta o número total de moedas armazenadas no cofre.
     *
     * @return o número total de moedas armazenadas no cofre
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
