package maquinaVenda;

import moedeiro.Cofre;
import moedeiro.TuboMoeda;
import moedeiro.exception.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws ExcessoMoedasException, QuantidadeInvalidaException {

		//Criar máquina
		Cofre cofre = new Cofre();
		maquinaVenda maquina = new maquinaVenda();

		// Adicionando produtos
		maquina.adicionarProduto(new Produto("Coca-Cola", 1.60));
		maquina.adicionarProduto(new Produto("Batata Frita", 1.35));
		maquina.adicionarProduto(new Produto("Twix", 1.00));
		maquina.adicionarProduto(new Produto("Sandes", 2.60));

		// Listando produtos
		maquina.listarProdutos();

		// Moedas inseridas pelo cliente
		Map<Double, TuboMoeda> moedasInseridas = new HashMap<>();
		moedasInseridas.put(1.00, new TuboMoeda(1.00, cofre));
		moedasInseridas.put(0.50, new TuboMoeda(0.50, cofre));

		// Adicionando moedas
		moedasInseridas.get(1.00).adicionarMoeda(2);
		moedasInseridas.get(0.50).adicionarMoeda(1);

		// Tentativa de compra do produto 1 (Coca-Cola)
		try {
			Produto produtoVendido = maquina.venderProduto(1, moedasInseridas);
			System.out.println("Compra realizada com sucesso: " + produtoVendido.getNome());
		} catch (ProdutoInvalidoException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (TransacaoException e) {
			System.out.println("Transação falhou: " + e.getMessage());
			System.out.println("Moedas devolvidas:");
			for (Map.Entry<Double, Integer> entry : e.getMoedasDevolvidas().entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		} catch (MoedeiroException e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		}


	}
	

}
