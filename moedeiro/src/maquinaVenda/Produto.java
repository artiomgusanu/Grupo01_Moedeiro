package maquinaVenda;

/**
 * Representa um produto disponível em uma máquina de venda automática.
 */
public class Produto {

	// Atributos

	/** Nome do produto. */
	private String nome;

	/** Preço do produto. */
	private double preco;

	// Construtor

	/**
	 * Construtor para criar um produto com nome e preço especificados.
	 *
	 * @param nome O nome do produto.
	 * @param preco O preço do produto.
	 */
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	// Gets e Sets

	/**
	 * Retorna o nome do produto.
	 *
	 * @return O nome do produto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o preço do produto.
	 *
	 * @return O preço do produto.
	 */
	public double getPreco() {
		return preco;
	}

	// Comportamentos

	/**
	 * Retorna uma representação em string do produto.
	 *
	 * @return Uma string contendo o nome e o preço do produto.
	 */
	@Override
	public String toString() {
		return nome + " - " + preco + "€";
	}

	// Outras funcionalidades podem ser adicionadas aqui, se necessário

}
