package maquinaVenda;

import moedeiro.*;
import moedeiro.exception.MoedeiroException;
import moedeiro.exception.ProdutoInvalidoException;
import moedeiro.exception.TransacaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A classe maquinaVenda representa uma máquina de venda que trabalha com os produtos e com o dinheiro correspondente.
 */
class maquinaVenda {
	
	// Atributos
	private List<Produto> produtos;
	private Moedeiro moedeiro;
	
	// Gets e Sets

	// Construtor
	/**
	 * Construtor da classe maquinaVenda.
	 */
	public maquinaVenda() {
		super();
		this.produtos = new ArrayList<>();
		this.moedeiro = new Moedeiro();
	}

	// Comportamentos
	/**
	 * Adiciona um produto à lista de produtos disponíveis na máquina.
	 *
	 * @param produto o produto a ser adicionado
	 */
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	/**
	 * Realiza a venda de um produto com base na escolha do usuário e nas moedas inseridas.
	 *
	 * @param tecla a tecla correspondente ao produto escolhido
	 * @param moedasInseridas as moedas inseridas pelo cliente
	 * @return o produto vendido
	 * @throws MoedeiroException exceção lançada em caso de problemas com o moedeiro
	 * @throws ProdutoInvalidoException exceção lançada se o produto escolhido for inválido
	 */
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

	/**
	 * Lista os produtos disponíveis na máquina.
	 */
	public void listarProdutos() {
		System.out.println("Lista de Produtos: ");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i).getNome() + " - " + produtos.get(i).getPreco());
        }
	}
	
	
	// Outras

	
}
