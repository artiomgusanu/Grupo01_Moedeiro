package maquinaVenda;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Menu representa o menu de produtos da máquina de vendas.
 */
public class Menu {

	// Atributos
	private String nome;
	private List<Produto> produtos;
	
	// Gets e Sets
	/**
	 * Retorna o nome do menu.
	 *
	 * @return o nome do menu
	 */
	public String getNome() {
		return nome;
	}

	// Construtor
	/**
	 * Construtor da classe Menu.
	 *
	 * @param nome o nome do menu
	 */
	public Menu(String nome) {
		super();
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}

	// Comportamentos
	/**
	 * Adiciona um produto ao menu.
	 *
	 * @param produto o produto a ser adicionado ao menu
	 */
	public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

	/**
	 * Mostra os produtos disponíveis no menu.
	 */
	public void mostrarProdutos() {
		System.out.println("Menu: " + nome);
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println((i + 1) + ". " + produtos.get(i));
		}
	}

	/**
	 * Seleciona um produto do menu com base no índice.
	 *
	 * @param indice o índice do produto a ser selecionado
	 * @return o produto selecionado, ou null se o índice for inválido
	 */
	public Produto selecionarProduto(int indice) {
		if(indice < 1 || indice > produtos.size()) {
			return null;
		}
		return produtos.get(indice - 1);
	}
	
	// Outras

	
}
