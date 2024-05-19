package maquinaVenda;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Criar máquina
		maquinaVenda maquina = new maquinaVenda();
		
		// Adicionar produtos à máquina
		maquina.adicionarProduto(new Produto("Coca-Cola", 1.60));
		maquina.adicionarProduto(new Produto("Batata Frita", 1.35));
		maquina.adicionarProduto(new Produto("Twix", 1.00));
		maquina.adicionarProduto(new Produto("Sandes", 2.60));
		
		
		// Iniciar máquina
		Scanner leitor = new Scanner(System.in);
		while(true) {																// Criar metodo de ligar e desligar maquina
			System.out.println("Selecione um produto pressionado a tecla correspondente:");
			maquina.listarProdutos();
			int teclaEscolhida = leitor.nextInt();
			leitor.nextLine();
			
			Produto produto = maquina.venderProduto(teclaEscolhida);
			if (produto == null) {
				System.out.println("Opção Inválida.");
			} else {
				System.out.println("Compraste: " + produto);
			}
			leitor.nextLine();
		}

	}
	

}
