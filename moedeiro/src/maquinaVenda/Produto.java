package maquinaVenda;

/**
 * A classe Produto representa um produto disponível para venda na máquina de vendas.
 */
public class Produto {

	// Atributos
	private String nome;
	private double preco;
	
	// Gets e Sets
	/**
	 * Retorna o nome do produto.
	 *
	 * @return o nome do produto
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Retorna o preço do produto.
	 *
	 * @return o preço do produto
	 */
	public double getPreco() {
		return preco;
	}
	
	// Construtor

	/**
	 * Construtor da classe Produto.
	 *
	 * @param nome  o nome do produto
	 * @param preco o preço do produto
	 */
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	// Comportamentos

	// Outras
	/**
	 * Retorna uma representação em string do produto, no formato "nome - preço€".
	 *
	 * @return uma representação em string do produto
	 */
	@Override
	public String toString() {
		return nome + " - " + preco + "€";
	}

}
