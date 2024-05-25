package moedeiro;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Moedeiro {

    // Atributos
    private Cofre cofre;

    // Gets e Sets

    // Construtor
    public Moedeiro(){
        this.cofre = new Cofre();
    }

    // Comportamentos
    public Map<Double, Integer> efetuarTansacao(double valorReceber, Map<Double, TuboMoeda> tubosMoedas){
        double valorTotalMoedasIntroduzidas = calcularValorTotalMoedasIntroduzidas(tubosMoedas);

        if (valorTotalMoedasIntroduzidas >= valorReceber){
            double troco = valorTotalMoedasIntroduzidas - valorReceber;
            Map<Double, Integer> trocoDevolvido = calcularTroco(troco, tubosMoedas);

            if (trocoDevolvido != null) {
                for (Map.Entry<Double, TuboMoeda> entry : tubosMoedas.entrySet()) {
                    double valorMoeda = entry.getKey();
                    TuboMoeda tubo = entry.getValue();
                    int quantidadeIntroduzida = tubo.getQuantidade();

                    cofre.adicionarMoeda(valorMoeda, quantidadeIntroduzida);

                    tubo.removerMoeda(quantidadeIntroduzida);
                }

                for (Map.Entry<Double, Integer> entry : trocoDevolvido.entrySet()){
                    double valorMoeda = entry.getKey();
                    int quantidade = entry.getValue();
                    TuboMoeda tubo = tubosMoedas.get(valorMoeda);
                    if (tubo != null) {
                        tubo.removerMoeda(quantidade);
                    }
                }
                return trocoDevolvido;      // Devolver as moedas caso sejam insuficientes
            }
        }
        return null;
    }

    public double calcularValorTotalMoedasIntroduzidas(Map<Double, TuboMoeda> tubosMoedas){
        double valorTotal = 0;
        for (TuboMoeda tubo : tubosMoedas.values()){
            valorTotal += tubo.calcularValorTotal();
        }
        return valorTotal;
    }

    private Map<Double, Integer> calcularTroco(double troco, Map<Double, TuboMoeda> tubosMoedas){
        Map<Double, Integer> trocoDevolvido = new TreeMap<>((a, b) -> b.compareTo(a));
        for (Map.Entry<Double, TuboMoeda> entry : tubosMoedas.entrySet()){
            double valorMoeda = entry.getKey();
            TuboMoeda tubo = entry.getValue();
            int quantidadeNoTubo = tubo.getQuantidade();

            int quantidadeDevolver = (int) (troco / valorMoeda);
            if (quantidadeDevolver > 0) {
                int quantidadeUsada = Math.min(quantidadeDevolver, quantidadeNoTubo);
                if (quantidadeUsada > 0) {
                    trocoDevolvido.put(valorMoeda, quantidadeUsada);
                    troco -= quantidadeUsada * valorMoeda;
                }
            }

            if (troco == 0) {
                break;
            }
        }

        if (troco == 0) {
            return trocoDevolvido;
        } else {
            return null;                // Não foi possível devolver o troco exato
        }
    }

    // Outras

}
