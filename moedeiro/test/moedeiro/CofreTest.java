package moedeiro;

import moedeiro.exception.QuantidadeNegativaException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de teste para verificar o comportamento da classe Cofre.
 */
public class CofreTest {

    private Cofre cofre;

    /**
     * Configuração inicial para cada teste, criando uma nova instância de Cofre.
     */
    @Before
    public void setUp() {
        cofre = new Cofre();
    }

    /**
     * Testa o método adicionarMoeda da classe Cofre.
     * Verifica se as moedas são adicionadas corretamente ao cofre.
     */
    @Test
    public void testAdicionarMoeda() throws QuantidadeNegativaException {
        // Adiciona moedas de 1.00 ao cofre
        cofre.adicionarMoeda(1.00, 5);

        // Verifica se as moedas foram adicionadas corretamente
        assertEquals(5, cofre.getMoedasPorTipo().get(1.00), 0.001);
    }

    /**
     * Testa o cálculo do valor total das moedas armazenadas no cofre.
     */
    @Test
    public void testCalcularValorTotal() throws QuantidadeNegativaException {
        // Adiciona algumas moedas ao cofre
        cofre.adicionarMoeda(0.50, 3);
        cofre.adicionarMoeda(1.00, 2);
        cofre.adicionarMoeda(0.20, 5);

        // Verifica se o valor total das moedas é calculado corretamente
        assertEquals(3.50, cofre.calcularValorTotal(), 0.001);
    }

    /**
     * Testa a contagem total de moedas armazenadas no cofre.
     */
    @Test
    public void testContarTotalMoedas() throws QuantidadeNegativaException {
        // Adiciona algumas moedas ao cofre
        cofre.adicionarMoeda(0.50, 3);
        cofre.adicionarMoeda(1.00, 2);
        cofre.adicionarMoeda(0.20, 5);

        // Verifica se o total de moedas é contado corretamente
        assertEquals(10, cofre.contarTotalMoedas());
    }
}
