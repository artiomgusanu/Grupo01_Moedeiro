package moedeiro;

import java.util.Map;

public class Moedeiro {

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
	
		
		
		
		// Adicionando algumas moedas nos tubos
        centimo50.adicionarMoeda(100); // Adiciona 100 moedas de 0.50
        euro1.adicionarMoeda(10); // Adiciona 150 moedas de 1.00

        // Testar o limite de capacidade
        centimo50.adicionarMoeda(150); // Adiciona 150 moedas de 0.50
        
        // Removendo algumas moedas dos tubos
        centimo50.removerMoeda(); // Remove uma moeda de 0.50
        euro1.removerMoeda(); // Remove uma moeda de 1.00

        // Calculando o valor total de moedas em cada tubo e no cofre
        System.out.println("Valor total no tubo de moedas de 0.50: " + centimo50.CalcularValorTotal() + "€");
        System.out.println("Valor total no tubo de moedas de 1.00: " + euro1.CalcularValorTotal() + "€");
        System.out.println("Valor total no cofre: " + cofreMoedas.calcularValorTotal() + "€");
		
        System.out.println("- - - - -");
        
        // Conta e imprime o número de moedas de cada tipo
        Map<Double, Integer> moedasPorTipo = cofreMoedas.contarMoedasPorTipo();
        System.out.println("Moedas por tipo: " + moedasPorTipo);
        
        // Conta e imprime o número total de moedas no cofre
        int totalMoedas = cofreMoedas.contarTotalMoedas();
        System.out.println("Número total de moedas: " + totalMoedas);
        
        System.out.println("- - - - -");
        
     // Verificar e mostrar mensagens de moedas restantes no tubo se o cofre estiver vazio
//        mostrarMoedasRestantes(centimo25);
        mostrarMoedasRestantes(centimo50);
        mostrarMoedasRestantes(euro1);
		
	}
	
	// Método auxiliar para mostrar as moedas restantes no tubo
    private static void mostrarMoedasRestantes(TuboMoeda tubo) {
        String mensagem = tubo.getMoedasRestantesSeCofreVazio();
        if (!mensagem.isEmpty()) {
            System.out.println(mensagem);
        }
    }

}
