package maquinaVenda;

import moedeiro.Cofre;
import moedeiro.TuboMoeda;
import moedeiro.exception.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe principal que simula uma máquina de venda automática.
 *
 * @author Artiom Gusanu, João Marques
 */
public class Main {

	/**
	 * Método principal que inicia a execução do programa.
	 *
	 * @param args Argumentos de linha de comando (não utilizados neste programa).
	 */
	public static void main(String[] args) {
		// Criar máquina
		Cofre cofre = new Cofre();
		MaquinaVenda maquina = new MaquinaVenda();

		// Adicionar produtos à máquina
		maquina.adicionarProduto(new Produto("Coca-Cola", 1.60));
		maquina.adicionarProduto(new Produto("Batata Frita", 1.35));
		maquina.adicionarProduto(new Produto("Twix", 1.00));
		maquina.adicionarProduto(new Produto("Sandes", 2.60));

		// Listar os produtos disponíveis na máquina
		maquina.listarProdutos();

		// Preparar para ler entrada do usuário
		Scanner scanner = new Scanner(System.in);

		// Pedir ao usuário para selecionar um produto
		System.out.println("\nSelecione o número do produto que deseja comprar:");
		int opcao = scanner.nextInt();

		// Moedas inseridas pelo cliente
		Map<Double, TuboMoeda> moedasInseridas = new HashMap<>();

		// Pedir ao usuário para inserir moedas
		System.out.println("Insira as moedas (valores aceitos: 1.00, 0.50, 0.20, 0.10, 0.05):");
		System.out.println("Digite 0 quando terminar de inserir moedas.");

		double valorMoeda;
		while (true) {
			System.out.print("Insira o valor da moeda: ");
			valorMoeda = scanner.nextDouble();
			if (valorMoeda == 0) {
				break;
			}
			if (valorMoeda != 1.00 && valorMoeda != 0.50 && valorMoeda != 0.20 && valorMoeda != 0.10 && valorMoeda != 0.05) {
				System.out.println("Moeda não aceita. Valores aceitos: 1.00, 0.50, 0.20, 0.10, 0.05");
				continue;
			}
			if (!moedasInseridas.containsKey(valorMoeda)) {
				moedasInseridas.put(valorMoeda, new TuboMoeda(valorMoeda, cofre));
			}

			System.out.print("Quantidade de moedas de " + valorMoeda + " inseridas: ");
			int quantidade = scanner.nextInt();

			try {
				moedasInseridas.get(valorMoeda).adicionarMoeda(quantidade);
			} catch (QuantidadeInvalidaException | ExcessoMoedasException e) {
				System.out.println("Quantidade inválida inserida: " + e.getMessage());
			}
		}

		// Tentativa de compra do produto escolhido
		try {
			Produto produtoVendido = maquina.venderProduto(opcao, moedasInseridas);
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
