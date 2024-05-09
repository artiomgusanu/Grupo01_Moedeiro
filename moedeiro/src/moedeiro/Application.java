package moedeiro;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TuboMoeda centimento1 = new TuboMoeda(0.01);
		TuboMoeda centimento2 = new TuboMoeda(0.02);
		TuboMoeda centimento5 = new TuboMoeda(0.05);
		TuboMoeda centimento10 = new TuboMoeda(0.10);
		TuboMoeda centimento20 = new TuboMoeda(0.20);
		TuboMoeda centimento50 = new TuboMoeda(0.50);
		TuboMoeda euro1 = new TuboMoeda(1);
		TuboMoeda euro2 = new TuboMoeda(2);
		
		centimento1.adicionarMoeda(3);
		centimento1.adicionarMoeda(6);
		centimento1.removerMoeda();
		System.out.println(centimento1.getQuantidade());
		centimento1.CalcularValorTotal();
		System.out.println(centimento1.CalcularValorTotal());
		
		System.out.println("- - - - ");
		
		centimento50.adicionarMoeda(1);
		centimento50.adicionarMoeda(5);
//		moeda2.removerMoeda();
		System.out.println(centimento50.getQuantidade());
		centimento50.CalcularValorTotal();
		System.out.println(centimento50.CalcularValorTotal());
		
		System.out.println("- - - - -");
		
		
	}

}
