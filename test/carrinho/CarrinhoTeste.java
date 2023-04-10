package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


@DisplayName("Teste do Carrinho")
public class CarrinhoTeste {
    
  Carrinho cart;
	Produto cafe, cerveja, vodka, cachaca;
	
	@BeforeEach
	public void inicializa() {
		cart = new Carrinho();
        cafe = new Produto("cafe", 6.50);
		cerveja = new Produto("cerveja", 8.00);
		vodka = new Produto("vodka", 5.50);
		cachaca = new Produto("cachaca", 4.50);
	}
	
  @DisplayName("Teste do getValorTotal")
	@Test
	public void testgetValorTotal() {
		cart.addItem(vodka);
		cart.addItem(cerveja);
		cart.addItem(cachaca);
		Assertions.assertEquals(18.0, cart.getValorTotal());	
	}

  @DisplayName("Adicao de itens")
	@Test
	public void testaddItem() {
		cart.addItem(cafe);
		cart.addItem(cerveja);
		cart.addItem(vodka);
		cart.addItem(vodka);
		Assertions.assertEquals(4, cart.getQtdeItems());	
	}

	@DisplayName("Remocao de items")
	@Test
	public void testremoveItem() {
		try {
      cart.addItem(cafe);
      cart.addItem(cerveja);
      cart.addItem(cachaca);
      cart.removeItem(cafe);
      cart.removeItem(cerveja);
      Assertions.assertEquals(1, cart.getQtdeItems());
    } catch (ProdutoNaoEncontradoException prod)
    {
    fail(prod);
    }
  }

	@DisplayName("Remocao de items do carrinho")
  @Test
  public void testremoveItemAssertThrows() {
    assertThrows(ProdutoNaoEncontradoException.class,
    () -> cart.removeItem(cachaca));
	}

	@DisplayName("Busca pela quantidade de produtos no carrinho")
	@Test
	public void testgetQtdeItems() {
		cart.addItem(cafe);
		cart.addItem(vodka);
		Assertions.assertEquals(2, cart.getQtdeItems());
	
  }

	@DisplayName("Remover todos itens do carrinho")
	@Test
	public void testesvazia() {
		cart.addItem(cafe);
		cart.addItem(vodka);
		cart.addItem(cachaca);
		cart.addItem(cerveja);
		cart.esvazia();
		Assertions.assertEquals(0, cart.getQtdeItems());

  }
    
}