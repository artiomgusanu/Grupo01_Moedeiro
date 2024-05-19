package moedeiro;

import java.util.Map;

import moedeiro.validator.ValidarMoedasValidator;

public class TuboMoeda {
	
	// Atributos
	private double valorMoeda;
	private int quantidade;
	private int CAPACIDADE_MAXIMA = 200;
	private Cofre CofreMoedas;
	
	// Gets e Sets
	public int getQuantidade() {
		return quantidade;
	}
	
	public double getValorMoeda() {
		return valorMoeda;
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
	
	public double CalcularValorTotal() {
		double valorTotal = valorMoeda * quantidade;
		return valorTotal;
	}
	
	// Verificar se o cofre ainda tem o mesmo tipo de moeda e retornar mensagem
    public String getMoedasRestantesSeCofreVazio() {
        Map<Double, Integer> moedasNoCofre = CofreMoedas.contarMoedasPorTipo();
        
        if (moedasNoCofre.containsKey(valorMoeda)) {
            return "";
        } else {
            return "Moedas restantes no tubo: " + quantidade + ". O cofre não tem moedas de " + valorMoeda;
        }
    }
	
	// Outras

}
