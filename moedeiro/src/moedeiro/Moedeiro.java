package moedeiro;

import moedeiro.exception.MoedasInsuficientesException;
import moedeiro.exception.TransacaoException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * A classe Moedeiro representa o sistema de transações do dinheiro em uma máquina de vendas.
 */
public class Moedeiro {

    // Atributos
    private Cofre cofre;

    // Gets e Sets

    // Construtor
    /**
     * Construtor da classe Moedeiro.
     */
    public Moedeiro(){
        this.cofre = new Cofre();
    }

    // Comportamentos
    /**
     * Realiza uma transação monetária.
     *
     * @param valorReceber o valor a ser recebido na transação
     * @param tubosMoedas os tubos de moedas disponíveis para a transação
     * @return o resultado da transação
     * @throws TransacaoException exceção lançada em caso de falha na transação
     * @throws MoedasInsuficientesException exceção lançada se não houver moedas suficientes para o troco
     */
    public ResultadoTransacao efetuarTansacao(double valorReceber, Map<Double, TuboMoeda> tubosMoedas) throws TransacaoException, MoedasInsuficientesException {
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
                return new ResultadoTransacao(trocoDevolvido,true);      // Devolver as moedas caso sejam insuficientes
            }
        }
        Map<Double, Integer> moedasDevolvidas = new HashMap<>();
        for (Map.Entry<Double, TuboMoeda> entry : tubosMoedas.entrySet()) {
            double valorMoeda = entry.getKey();
            TuboMoeda tubo = entry.getValue();
            int quantidadeIntroduzida = tubo.getQuantidade();
            moedasDevolvidas.put(valorMoeda, quantidadeIntroduzida);
        }

        throw new TransacaoException("Não foi possível realizar a transação. Quantia insuficiente para troco.", moedasDevolvidas);
    }

    /**
     * Calcula o valor total das moedas introduzidas na transação.
     *
     * @param tubosMoedas os tubos de moedas disponíveis para a transação
     * @return o valor total das moedas introduzidas
     */
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
