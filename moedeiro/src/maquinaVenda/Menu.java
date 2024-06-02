package maquinaVenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um menu de produtos em uma máquina de venda automática.
 */
public class Menu {

	// Atributos

	/** Nome do menu. */
	private String nome;

	/** Lista de produtos disponíveis no menu. */
	private List<Produto> produtos;

	// Construtor

	/**
	 * Construtor para criar um menu com um nome especificado.
	 *
	 * @param nome O nome do menu.
	 */
	public Menu(String nome) {
		super();
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}

	// Gets e Sets

	/**
	 * Retorna o nome do menu.
	 *
	 * @return O nome do menu.
	 */
	public String getNome() {
		return nome;
	}

	// Comportamentos

	/**
	 * Adiciona um produto à lista de produtos disponíveis no menu.
	 *
	 * @param produto O produto a ser adicionado.
	 */
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	/**
	 * Exibe os produtos disponíveis no menu, incluindo seus nomes e índices.
	 */
	public void mostrarProdutos() {
		System.out.println("Menu: " + nome);
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println((i + 1) + ". " + produtos.get(i));
		}
	}

	/**
	 * Seleciona um produto do menu baseado no índice fornecido.
	 *
	 * @param indice O índice do produto desejado (baseado em 1).
	 * @return O produto selecionado, ou {@code null} se o índice for inválido.
	 */
	public Produto selecionarProduto(int indice) {
		if (indice < 1 || indice > produtos.size()) {
			return null;
		}
		return produtos.get(indice - 1);
	}

	// Outras funcionalidades podem ser adicionadas aqui, se necessário

}
