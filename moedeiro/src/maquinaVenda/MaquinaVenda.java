package maquinaVenda;

import moedeiro.*;
import moedeiro.exception.MoedeiroException;
import moedeiro.exception.ProdutoInvalidoException;
import moedeiro.exception.TransacaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class maquinaVenda {
	
	// Atributos
	private List<Produto> produtos;
	private Moedeiro moedeiro;
	
	// Gets e Sets

	// Construtor
	public maquinaVenda() {
		super();
		this.produtos = new ArrayList<>();
		this.moedeiro = new Moedeiro();
	}

	// Comportamentos
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public Produto venderProduto(int tecla, Map<Double, TuboMoeda> moedasInseridas) throws MoedeiroException {
		if (tecla < 1 || tecla > produtos.size()) {
			throw new ProdutoInvalidoException("Produto inválido.");
		}

		Produto produto = produtos.get(tecla - 1);

		try {
			ResultadoTransacao resultado = moedeiro.efetuarTansacao(produto.getPreco(), moedasInseridas);
			if (resultado.isSucesso()) {
				return produto;
			} else {
				throw new TransacaoException("Transação falhou.", resultado.getTrocoDevolvido());
			}
		} catch (TransacaoException e) {
			throw new TransacaoException("Transação falhou: " + e.getMessage(), e.getMoedasDevolvidas());
		}
	}
	
	public void listarProdutos() {
		System.out.println("Lista de Produtos: ");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i).getNome() + " - " + produtos.get(i).getPreco());
        }
	}
	
	
	// Outras

	
}
