package moedeiro;

import java.util.Map;

import moedeiro.exception.ExcessoMoedasException;
import moedeiro.exception.MoedasInsuficientesException;
import moedeiro.exception.MoedeiroException;
import moedeiro.exception.QuantidadeInvalidaException;
import moedeiro.validator.ValidarMoedasValidator;

/**
 * Classe que representa um tubo de moedas em um Moedeiro.
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
     * Construtor que inicializa um novo tubo de moedas com um valor específico e um cofre de moedas associado.
     *
     * @param valorMoeda   O valor da moeda associada ao tubo.
     * @param cofreMoedas  O cofre armazena as moedas.
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
     * @param adicionar A quantidade de moedas a ser adicionada.
     * @return A quantidade atual de moedas no tubo após a adição.
     * @throws QuantidadeInvalidaException Se a quantidade de moedas a ser adicionada for inválida (negativa ou zero)
     * @throws ExcessoMoedasException se a quantidade exceder a capacidade máxima do tubo.
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
     * @param quantidade A quantidade de moedas a ser removida.
     * @throws MoedasInsuficientesException Se a quantidade for maior do que a quantidade atual no tubo.
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
     * @return O valor total das moedas no tubo.
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
    }

    // Outras

}
