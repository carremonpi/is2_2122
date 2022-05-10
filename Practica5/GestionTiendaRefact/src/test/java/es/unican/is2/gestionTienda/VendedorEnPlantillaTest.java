package es.unican.is2.gestionTienda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VendedorEnPlantillaTest {
	
	private static VendedorEnPlantilla sutJunior;
	private static VendedorEnPlantilla sutSenior;

	
	@Before
	public void setUp(){
		
		sutJunior = new VendedorEnPlantillaJunior("Ana", "1", "11111111A");
		sutSenior = new VendedorEnPlantillaSenior("Pepe", "2", "222222222A");
		
	}
	
	@Test
	public void testConstructor() {
		assertEquals(sutJunior.getId(), "1");
		assertEquals(sutJunior.getDni(), "11111111A");
		assertEquals(sutJunior.getNombre(), "Ana");
		
	}

	@Test
	public void testAnhadeVenta() {
		
		sutJunior.anhadeVenta(200);
		assertEquals(sutJunior.getTotalVentas(), 201, 0);
		sutJunior.anhadeVenta(300);
		assertEquals(sutJunior.getTotalVentas(), 502.5, 0);
		
		sutSenior.anhadeVenta(300);
		assertEquals(sutSenior.getTotalVentas(), 303, 0); //301,5
		sutSenior.anhadeVenta(300);
		assertEquals(sutSenior.getTotalVentas(), 606, 0); //603
		
	}
	
	@Test
	public void testSetTotalVentas() {
		
		sutJunior.setTotalVentas(2000);
		assertEquals(sutJunior.getTotalVentas(), 2000, 0);	
		sutJunior.setTotalVentas(4000);
		assertEquals(sutJunior.getTotalVentas(), 4000, 0);	
		sutJunior.setTotalVentas(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);
		
		sutSenior.setTotalVentas(4500);
		assertEquals(sutSenior.getTotalVentas(), 4500, 0);		
		sutSenior.setTotalVentas(4000);
		assertEquals(sutSenior.getTotalVentas(), 4000, 0);
		sutJunior.setTotalVentas(0);
		assertEquals(sutJunior.getTotalVentas(), 0, 0);	
		
	}

	
	@Test
	public void testEquals() {
		VendedorEnPlantilla igualJunior = new VendedorEnPlantillaJunior("Ana", "1", "11111111A");
		VendedorEnPlantilla distintoIdJunior = new VendedorEnPlantillaJunior("Ana", "2", "11111111A");
		VendedorEnPlantilla distintoDNIJunior = new VendedorEnPlantillaJunior("Ana", "1", "222222222A");
		assertTrue(sutJunior.equals(igualJunior));
		assertFalse(sutJunior.equals(distintoIdJunior));
		assertFalse(sutJunior.equals(distintoDNIJunior));
		
		VendedorEnPlantilla igualSenior = new VendedorEnPlantillaSenior("Pepe", "2", "222222222A");
		VendedorEnPlantilla distintoIdSenior = new VendedorEnPlantillaSenior("Pepe", "3", "222222222A");
		VendedorEnPlantilla distintoDNISenior = new VendedorEnPlantillaSenior("Pepe", "2", "33333333A");
		assertTrue(sutSenior.equals(igualSenior)); //FALLA
		assertFalse(sutSenior.equals(distintoIdSenior));
		assertFalse(sutSenior.equals(distintoDNISenior));
		
	}
	
	
	
}
