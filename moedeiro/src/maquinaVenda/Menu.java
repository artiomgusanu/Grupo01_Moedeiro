package maquinaVenda;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	// Atributos
	private String nome;
	private List<Produto> produtos;
	
	// Gets e Sets
	public String getNome() {
		return nome;
	}

	// Construtor
	public Menu(String nome) {
		super();
		this.nome = nome;
		this.produtos = new ArrayList<>();
	}

	// Comportamentos
	public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }
	
	public void mostrarProdutos() {
		System.out.println("Menu: " + nome);
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println((i + 1) + ". " + produtos.get(i));
		}
	}
	
	public Produto selecionarProduto(int indice) {
		if(indice < 1 || indice > produtos.size()) {
			return null;
		}
		return produtos.get(indice - 1);
	}
	
	// Outras

	
}
