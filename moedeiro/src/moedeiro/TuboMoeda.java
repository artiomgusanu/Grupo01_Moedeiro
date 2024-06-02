package moedeiro;

import java.util.Map;

import moedeiro.exception.ExcessoMoedasException;
import moedeiro.exception.MoedasInsuficientesException;
import moedeiro.exception.MoedeiroException;
import moedeiro.exception.QuantidadeInvalidaException;
import moedeiro.validator.ValidarMoedasValidator;

/**
 * A classe TuboMoeda representa um tubo que armazena moedas de determinado valor em uma máquina de vendas.
 */
public class TuboMoeda {

    // Atributos
    private static final int CAPACIDADE_MAXIMA = 200;
    private final double valorMoeda;
    private int quantidade;
    private final Cofre cofreMoedas;

    // Gets e Sets
    public int getQuantidade() {
        return quantidade;
    }

    public double getValorMoeda() {
        return valorMoeda;
    }

    // Construtor
    /**
     * Construtor da classe TuboMoeda.
     *
     * @param valorMoeda o valor da moeda armazenada no tubo
     * @param cofreMoedas o cofre que armazena as moedas
     */
    public TuboMoeda(double valorMoeda, Cofre cofreMoedas) {
        this.valorMoeda = valorMoeda;
        this.quantidade = 0;
        this.cofreMoedas = cofreMoedas;
    }

    // Comportamentos
    /**
     * Adiciona moedas ao tubo.
     *
     * @param adicionar a quantidade de moedas a adicionar
     * @return a quantidade total de moedas no tubo após a adição
     * @throws QuantidadeInvalidaException se a quantidade de moedas for inválida
     * @throws ExcessoMoedasException se a quantidade exceder a capacidade máxima do tubo
     */
    public int adicionarMoeda(int adicionar) throws QuantidadeInvalidaException, ExcessoMoedasException {
        if (ValidarMoedasValidator.validarQuantidade(adicionar)) {
            if (quantidade + adicionar <= CAPACIDADE_MAXIMA) {
                quantidade += adicionar;
            } else {
                int excesso = quantidade + adicionar - CAPACIDADE_MAXIMA;
                quantidade = CAPACIDADE_MAXIMA;
                cofreMoedas.adicionarMoeda(valorMoeda, excesso);
                throw new ExcessoMoedasException("Quantidade excede a capacidade máxima do tubo.", excesso);
            }
        } else {
            throw new QuantidadeInvalidaException("A quantidade de moedas não pode ser negativa.");
        }
        return quantidade;
    }

    /**
     * Remove moedas do tubo.
     *
     * @param quantidade a quantidade de moedas a remover
     * @throws MoedasInsuficientesException se não houver moedas suficientes no tubo
     */
    public void removerMoeda(int quantidade) throws MoedasInsuficientesException{
        if (quantidade > this.quantidade) {
            throw new MoedasInsuficientesException("Não há moedas suficientes no tubo.");
        }
        this.quantidade -= quantidade;
    }

    /**
     * Calcula o valor total das moedas no tubo.
     *
     * @return o valor total das moedas no tubo
     */
    public double calcularValorTotal() {
        final double valorTotal = valorMoeda * quantidade;
        return valorTotal;
    }



    // Verificar se o cofre ainda tem o mesmo tipo de moeda e retornar mensagem
    /**
     * Obtém o número de moedas restantes no tubo se o cofre estiver vazio.
     *
     * @return o número de moedas restantes no tubo se o cofre estiver vazio
     */
    public int getMoedasRestantesSeCofreVazio() {
        Integer numMoedas = cofreMoedas.getMoedasPorTipo().getOrDefault(valorMoeda, 0);
        return numMoedas == null ? 0 : numMoedas;
//
//        Map<Double, Integer> moedasNoCofre = cofreMoedas.contarMoedasPorTipo();
//
//        if (moedasNoCofre.containsKey(valorMoeda)) {
//            return "";
//        } else {
//            return "Moedas restantes no tubo: " + quantidade + ". O cofre não tem moedas de " + valorMoeda;
//        }
    }

    // Outras

}
