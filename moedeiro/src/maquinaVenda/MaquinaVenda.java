package maquinaVenda;

import moedeiro.*;
import moedeiro.exception.MoedeiroException;
import moedeiro.exception.ProdutoInvalidoException;
import moedeiro.exception.TransacaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa uma máquina de venda automática que gerencia produtos e transações com moedas.
 */
public class MaquinaVenda {

    // Atributos

    /** Lista de produtos disponíveis na máquina de venda. */
    private List<Produto> produtos;

    /** Moedeiro que gerencia as moedas inseridas e troco. */
    private Moedeiro moedeiro;

    // Gets e Sets
    public List<Produto> getProdutos() {
        return produtos;
    }

    // Construtor

    /**
     * Construtor padrão que inicializa a máquina de venda sem produtos e com um novo moedeiro.
     */
    public MaquinaVenda() {
        super();
        this.produtos = new ArrayList<>();
        this.moedeiro = new Moedeiro();
    }

    // Comportamentos

    /**
     * Adiciona um produto à lista de produtos disponíveis na máquina de venda.
     *
     * @param produto O produto a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    /**
     * Vende um produto baseado na tecla selecionada e nas moedas inseridas.
     *
     * @param tecla A tecla correspondente ao produto desejado.
     * @param moedasInseridas As moedas inseridas pelo cliente para efetuar a compra.
     * @return O produto vendido, se a transação for bem-sucedida.
     * @throws MoedeiroException Se ocorrer um erro relacionado ao moedeiro durante a transação.
     * @throws ProdutoInvalidoException Se a tecla selecionada não corresponder a um produto válido.
     * @throws TransacaoException Se a transação falhar por qualquer motivo.
     */
    public Produto venderProduto(int tecla, Map<Double, TuboMoeda> moedasInseridas) throws MoedeiroException {
        if (tecla < 1 || tecla > produtos.size()) {
            throw new ProdutoInvalidoException("Produto inválido.");
        }

        Produto produto = produtos.get(tecla - 1);

        try {
            ResultadoTransacao resultado = moedeiro.efetuarTansacao(produto.getPreco(), moedasInseridas);
            if (resultado.isSucesso()) {
                return produto;
            } else {
                throw new TransacaoException("Transação falhou.", resultado.getTrocoDevolvido());
            }
        } catch (TransacaoException e) {
            throw new TransacaoException("Transação falhou: " + e.getMessage(), e.getMoedasDevolvidas());
        }
    }

    /**
     * Lista todos os produtos disponíveis na máquina de venda com seus respectivos preços.
     */
    public void listarProdutos() {
        System.out.println("Lista de Produtos: ");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + ". " + produtos.get(i).getNome() + " - " + produtos.get(i).getPreco());
        }
    }

    // Outras

}
