package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(12, 6);		
		Assertions.assertEquals(18, soma);		
	}
	
	@DisplayName("Ssubtracao de dois numeros")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(12, 6);		
		Assertions.assertEquals(6, subtracao);		
	}

	@DisplayName("Multiplicacao de dois numeros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(6, -2);		
		Assertions.assertEquals(-12, multiplicacao);		
	}

	@DisplayName("Divisao de dois numeros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(12, 6);
		assertTrue(divisao == 2);
	}
	
  @DisplayName("Divisão por Zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(98, 0);
			fail("Excecao!");
		} catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
  @DisplayName("Divisão por Zero com AssertThrows")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
    () -> calc.divisao(12, 0));
	}

	@DisplayName("Somatorio de um numero")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);
		Assertions.assertEquals(15, somatoria);		
	}

	@DisplayName("Numero eh positivo?")
	@Test
	public void testehPositivo() {
		boolean ehPositivo = calc.ehPositivo(22);
		assertTrue(ehPositivo);	
	}

	@DisplayName("Comparacao entre dois numeros iguais")
	@Test
	public void testecomparaiguais() {
		int compara = calc.compara(10, 10);
		Assertions.assertEquals(0, compara);		
	}

	@DisplayName("Comparacao entre dois numeros, o primeiro maior que o segundo")
	@Test
	public void testecomparamaior() {
		int compara = calc.compara(69, 12);
		Assertions.assertEquals(1, compara);		
	}

	@DisplayName("Comparacao entre dois numeros, o primeiro menor que o segundo")
	@Test
	public void testecomparamenor() {
		int compara = calc.compara(2, 6);
		Assertions.assertEquals(-1, compara);		
	}
}
