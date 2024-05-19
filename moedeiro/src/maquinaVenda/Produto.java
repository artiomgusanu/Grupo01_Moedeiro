package maquinaVenda;

public class Produto {

	// Atributos
	private String nome;
	private double preco;
	
	// Gets e Sets
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	
	// Construtor
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	// Comportamentos

	// Outras
	@Override
	public String toString() {
		return nome + " - " + preco + "€";
	}

}
