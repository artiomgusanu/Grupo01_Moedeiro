package moedeiro;

import java.text.DecimalFormat;

import moedeiro.validator.ValidarMoedasValidator;

public class TuboMoeda {
	
	// Atributos
	private double valorMoeda;
	private int quantidade;
	private int CAPACIDADE_MAXIMA = 200;
	private DecimalFormat df = new DecimalFormat("0.00");
	private Cofre CofreMoedas;
	
	// Gets e Sets
	public int getQuantidade() {
		return quantidade;
	}

	// Construtor
	public TuboMoeda(double valorMoeda, Cofre CofreMoedas) {
		this.valorMoeda = valorMoeda;
		this.quantidade = 0;
		this.CofreMoedas = CofreMoedas;
	}
	
	// Comportamentos
	public int adicionarMoeda(int adicionar){
		if (ValidarMoedasValidator.validarQuantidade(adicionar)) {
            if (quantidade + adicionar <= CAPACIDADE_MAXIMA) {
            	quantidade += adicionar;
            } else {
            	int excesso = quantidade + adicionar - CAPACIDADE_MAXIMA;
            	quantidade = CAPACIDADE_MAXIMA;
            	CofreMoedas.adicionarMoeda(valorMoeda, excesso);
            }
        } else {
        	// erro: valor inserido negativo
        }
		return quantidade;
    }
	
	public void removerMoeda() {
		if (quantidade >0) {
			quantidade--;
		}
	}
	
	public String CalcularValorTotal() {
		double valorTotal = valorMoeda * quantidade;
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
