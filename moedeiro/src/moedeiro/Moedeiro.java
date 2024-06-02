package moedeiro;

import moedeiro.exception.MoedasInsuficientesException;
import moedeiro.exception.QuantidadeNegativaException;
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
     * Construtor padrão que inicializa um novo Moedeiro com um cofre vazio.
     */

    public Moedeiro() {
        this.cofre = new Cofre();
    }

    // Comportamentos

    /**
     * Realiza uma transação de compra, aceitando moedas e calculando o troco, se necessário.
     *
     * @param valorReceber O valor a ser pago pela compra.
     * @param tubosMoedas  Um conjunto de tubos de moedas disponíveis para pagamento.
     * @return ResultadoTransacao indica se a transação foi bem-sucedida e o troco.
     * @throws TransacaoException           Se ocorrer um erro durante a transação.
     * @throws MoedasInsuficientesException Se as moedas introduzidas forem insuficientes para completar o pagamento.
     */


    public ResultadoTransacao efetuarTansacao(double valorReceber, Map<Double, TuboMoeda> tubosMoedas) throws TransacaoException, MoedasInsuficientesException, QuantidadeNegativaException {
        double valorTotalMoedasIntroduzidas = calcularValorTotalMoedasIntroduzidas(tubosMoedas);

        if (valorTotalMoedasIntroduzidas >= valorReceber) {
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

                for (Map.Entry<Double, Integer> entry : trocoDevolvido.entrySet()) {
                    double valorMoeda = entry.getKey();
                    int quantidade = entry.getValue();
                    TuboMoeda tubo = tubosMoedas.get(valorMoeda);
                    if (tubo != null) {
                        tubo.removerMoeda(quantidade);
                    }
                }
                return new ResultadoTransacao(trocoDevolvido, true);      // Devolver as moedas caso sejam insuficientes
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
     * Calcula o valor total das moedas introduzidas nos tubos de moedas.
     *
     * @param tubosMoedas Os tubos de moedas disponíveis para a transação.
     * @return O valor total das moedas introduzidas.
     */

    public double calcularValorTotalMoedasIntroduzidas(Map<Double, TuboMoeda> tubosMoedas) {
        double valorTotal = 0;
        for (TuboMoeda tubo : tubosMoedas.values()) {
            valorTotal += tubo.calcularValorTotal();
        }
        return valorTotal;
    }

    /**
     * Calcula o troco a ser devolvido ao cliente.
     *
     * @param troco O valor do troco a ser devolvido.
     * @param tubosMoedas Os tubos de moedas disponíveis para o pagamento.
     * @return Um conjunto de moedas e as suas respetivas quantidades a serem devolvidas como troco.
     */

    private Map<Double, Integer> calcularTroco(double troco, Map<Double, TuboMoeda> tubosMoedas) {
        Map<Double, Integer> trocoDevolvido = new TreeMap<>((a, b) -> b.compareTo(a));
        for (Map.Entry<Double, TuboMoeda> entry : tubosMoedas.entrySet()) {
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
