package moedeiro;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Cofre {
	
	// Atributos
	private Map <Double, Integer> moedasArmazenadas;
	private DecimalFormat df = new DecimalFormat("0.00");

	// Gets e Sets
	

	// Construtor
	public Cofre() {
		super();
		moedasArmazenadas = new HashMap<>();
	}
	// Comportamentos
	public void adicionarMoeda(double valorMoeda, int quantidade) {
        if (moedasArmazenadas.containsKey(valorMoeda)) {
            int quantidadeAtual = moedasArmazenadas.get(valorMoeda);
            moedasArmazenadas.put(valorMoeda, quantidadeAtual + quantidade);
        } else {
            moedasArmazenadas.put(valorMoeda, quantidade);
        }
    }

    public String calcularValorTotal() {
        double valorTotal = 0;
        for (Map.Entry<Double, Integer> entry : moedasArmazenadas.entrySet()) {
            valorTotal += entry.getKey() * entry.getValue();
        }
        return df.format(valorTotal);
    }
    
	// Outras

}
