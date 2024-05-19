package maquinaVenda;

import java.util.ArrayList;
import java.util.List;

public class maquinaVenda {
	
	// Atributos
	private List<Produto> produtos;
	
	// Gets e Sets

	// Construtor
	public maquinaVenda() {
		super();
		this.produtos = new ArrayList<>();
	}

	// Comportamentos
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public Produto venderProduto(int tecla) {
		if(tecla < 1 || tecla > produtos.size()) {
		return null;
		}
		return produtos.get(tecla - 1);
	}
	
	public void listarProdutos() {
		System.out.println("Lista de Produtos: ");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i).getNome() + " - " + produtos.get(i).getPreco());
        }
	}
	
	
	// Outras

	
}
