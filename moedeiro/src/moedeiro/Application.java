package moedeiro;

public class Application {

	public static void main(String[] args) {

		Cofre cofreMoedas = new Cofre();
		
//		TuboMoeda centimo1 = new TuboMoeda(0.01);
//		TuboMoeda centimo2 = new TuboMoeda(0.02);
//		TuboMoeda centimo5 = new TuboMoeda(0.05);
//		TuboMoeda centimo10 = new TuboMoeda(0.10);
//		TuboMoeda centimo20 = new TuboMoeda(0.20);
		TuboMoeda centimo50 = new TuboMoeda(0.50, cofreMoedas);
		TuboMoeda euro1 = new TuboMoeda(1, cofreMoedas);
//		TuboMoeda euro2 = new TuboMoeda(2);
		
//		centimento1.adicionarMoeda(3);
//		centimento1.adicionarMoeda(6);
//		centimento1.removerMoeda();
//		System.out.println(centimento1.getQuantidade());
//		centimento1.CalcularValorTotal();
//		System.out.println(centimento1.CalcularValorTotal());
//		
//		System.out.println("- - - - ");
//		
//		centimento50.adicionarMoeda(1);
//		centimento50.adicionarMoeda(5);
//		moeda2.removerMoeda();
//		System.out.println(centimento50.getQuantidade());
//		centimento50.CalcularValorTotal();
//		System.out.println(centimento50.CalcularValorTotal());
//		
//		System.out.println("- - - - -");
		
		// Adicionando algumas moedas nos tubos
        centimo50.adicionarMoeda(100); // Adiciona 100 moedas de 0.50
        euro1.adicionarMoeda(150); // Adiciona 150 moedas de 1.00

        // Adicionando moedas extras no tubo1 para testar o limite de capacidade
        centimo50.adicionarMoeda(150); // Adiciona 150 moedas de 0.50
        // O excedente será adicionado ao cofre

        // Removendo algumas moedas dos tubos
        centimo50.removerMoeda(); // Remove uma moeda de 0.50 do centimo50
        euro1.removerMoeda(); // Remove uma moeda de 1.00 do euro1

        // Calculando o valor total de moedas em cada tubo e no cofre
        System.out.println("Valor total no tubo de moedas de 0.50: " + centimo50.CalcularValorTotal() + "€");
        System.out.println("Valor total no tubo de moedas de 1.00: " + euro1.CalcularValorTotal() + "€");
        System.out.println("Valor total no cofre: " + cofreMoedas.calcularValorTotal() + "€");
		
		
	}

}
