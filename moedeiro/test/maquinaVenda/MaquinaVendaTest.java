package maquinaVenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de teste para verificar o funcionamento da adição de produtos na Máquina de Venda.
 */
public class MaquinaVendaTest {

    private MaquinaVenda maquina;

    /**
     * Configuração inicial para cada teste, criando uma nova instância da Máquina de Venda.
     */
    @BeforeEach
    public void setUp() {
        maquina = new MaquinaVenda();
    }

    /**
     * Testa o método de adicionar produto na Máquina de Venda.
     * Verifica se um produto é corretamente adicionado à lista de produtos.
     */
    @Test
    public void testAdicionarProduto() {
        // Verifica se a máquina inicialmente não contém produtos
        assertEquals(0, maquina.getProdutos().size());

        // Adiciona um produto
        maquina.adicionarProduto(new Produto("Coca-Cola", 1.60));

        // Verifica se o produto foi adicionado corretamente
        assertEquals(1, maquina.getProdutos().size());
        assertEquals("Coca-Cola", maquina.getProdutos().get(0).getNome());
    }
}
