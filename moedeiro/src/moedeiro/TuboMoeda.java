package moedeiro;

import java.text.DecimalFormat;

import moedeiro.validator.ValidarMoedasValidator;

public class TuboMoeda {
	
	// Atributos
	private double valor;
	private int quantidade;
	private int capacidadeMaxima = 200;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	// Gets e Sets
	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	
	// Construtor
	public TuboMoeda(double valor) {
		super();
		this.valor = valor;
		this.quantidade = 0;
	}
	
	// Comportamentos
	public int adicionarMoeda(int adicionar){
		if (ValidarMoedasValidator.validarQuantidade(adicionar)) {
            quantidade += adicionar;
        }
		return quantidade;
    }
	
	public void removerMoeda() {
		if (quantidade >0) {
			quantidade--;
		}
	}
	
	public String CalcularValorTotal() {
		double valorTotal = valor * quantidade;
		return df.format(valorTotal);
	}
	
//	public int validarQuantidadeInserida() {
//		if (adicionar > 0 || adicionar < capacidadeMaxima) {
//			return adicionar;
//		}
//		return adicionar;
//	}
	
	// Outras

}
