package moedeiro;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Cofre {
	
	// Atributos
	private Map <Double, Integer> moedasArmazenadas;

	// Gets e Sets
	

	// Construtor
	public Cofre() {
		super();
		moedasArmazenadas = new HashMap<>();
	}

	// Comportamentos
	public void adicionarMoeda(double valorMoeda, int quantidade) {
        // e se quantidade for < 0 ?
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade de moedas não pode ser negativo");
        }
        final int quantidadeAtual =  moedasArmazenadas.getOrDefault(valorMoeda, 0);
        moedasArmazenadas.put(valorMoeda, quantidadeAtual + quantidade);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Map.Entry<Double, Integer> entry : moedasArmazenadas.entrySet()) {
            valorTotal += entry.getKey() * entry.getValue();
        }
        return valorTotal;
    }
    
    // Método para contar o número de moedas de cada tipo  /  (REVER) Explicar melhor o porquê de termos usado o clone
    public Map<Double, Integer> getMoedasPorTipo() {
        return new HashMap<>(moedasArmazenadas);
    }
    
    // Método para contar o número total de moedas no cofre						(REVER)
    public int contarTotalMoedas() {
        int totalMoedas = 0;
        for (int quantidade : moedasArmazenadas.values()) {
            totalMoedas += quantidade;
        }
        return totalMoedas;
    }

    // Outras

}
