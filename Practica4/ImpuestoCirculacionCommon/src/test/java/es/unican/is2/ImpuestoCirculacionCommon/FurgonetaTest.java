package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionCommon.Furgoneta;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;

import java.time.LocalDate;
public class FurgonetaTest {

	@Test
	public void testPrecioImpuesto() throws OperacionNoValida {
		//("AAA1", hoy-50años, 0.99, True):0
		Furgoneta f = new Furgoneta("AAA1", LocalDate.now().minusYears(50), 0.99, true);
		assertTrue(f.precioImpuesto()==0);
		
		//("BBB1", hoy-24años y 10 meses, 4, False):25,24
		f = new Furgoneta("BBB1", LocalDate.now().minusYears(24).minusMonths(10), 4, false);
		assertTrue(f.precioImpuesto()==25.24);
		
		//("BBB1", hoy, 7.99, True):20,192
		f = new Furgoneta("BBB1", LocalDate.now(), 7.99, true);
		//assertTrue(f.precioImpuesto()==20.192); 
		assertEquals(f.precioImpuesto(), 20.19, 0.01);
		//-------------
		
		//("BBB1", hoy+10dias, 8, False):68,16
		f = new Furgoneta("BBB1", LocalDate.now().plusDays(10), 8, false);
		assertTrue(f.precioImpuesto()==68.16);
		
		//("AAA1", hoy-25años, 10, False):0
		f = new Furgoneta("AAA1", LocalDate.now().minusYears(25), 10, false);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 11.99, True):54,528
		f = new Furgoneta("AAA1", LocalDate.now(), 11.99, true);
		//assertTrue(f.precioImpuesto()==54.528);
		assertEquals(f.precioImpuesto(), 54.53, 0.01);
		
		//------------
		
		//("BBB1", hoy+10dias, 12, False):143.88
		f = new Furgoneta("BBB1", LocalDate.now().plusDays(10), 12, false);
		assertTrue(f.precioImpuesto()==143.88);
		
		//("AAA1", hoy-50años, 14, False):0
		f = new Furgoneta("AAA1", LocalDate.now().minusYears(50), 14, false);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 15.99, True):115.104
		f = new Furgoneta("AAA1", LocalDate.now(), 15.99, true);
		//assertTrue(f.precioImpuesto()==115.104);
		assertEquals(f.precioImpuesto(), 115.10, 0.01);
		
		//------------
		
		//("BBB1", hoy+10dias, 16, False):179.22
		f = new Furgoneta("BBB1", LocalDate.now().plusDays(10), 16, false);
		assertTrue(f.precioImpuesto()==179.22);
		
		//("AAA1", hoy-25años, 18, False):0
		f = new Furgoneta("AAA1", LocalDate.now().minusYears(25), 18, false);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 19.99, True):143.376
		f = new Furgoneta("AAA1", LocalDate.now(), 19.99, true);
		//assertTrue(f.precioImpuesto()==143.376);
		assertEquals(f.precioImpuesto(), 143.37, 0.01);
		
		//------------
		
		//("BBB1", hoy+10dias, 20, False):224
		f = new Furgoneta("BBB1", LocalDate.now(), 20, false);
		assertTrue(f.precioImpuesto()==224);
		
		//("AAA1", hoy-25años, 50, False):0
		f = new Furgoneta("AAA1", LocalDate.now().minusYears(25), 50, false);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 20, True):179.2 - NO NECESARIO
		f = new Furgoneta("AAA1", LocalDate.now(), 20, true);
		//assertTrue(f.precioImpuesto()==179.2);
		assertEquals(f.precioImpuesto(), 179.2, 0.01);
		
		
	}

	@Test
	public void testFurgoneta() throws OperacionNoValida {
		LocalDate fecha = LocalDate.now().minusYears(50);
		Furgoneta f = new Furgoneta("AAA1", fecha, 0.99, true);
		assertTrue(f.getComercial()==true);
		assertTrue(f.getMatricula().equals("AAA1"));
		assertTrue(f.getFechaMatriculacion().equals(fecha));
		assertTrue(f.getPotencia()==0.99);
		
		try {
			f = new Furgoneta("AAA1", LocalDate.now(), 0, true);
			fail("Fallo con potencia 0");
		} catch (OperacionNoValida e) {
			
		}
		
		try {
			f = new Furgoneta("AAA1", LocalDate.now().minusYears(25), -10, true);
			fail("Fallo con potencia negativa");
		} catch (OperacionNoValida e) {
			
		}
		
		try {
			f = new Furgoneta(null, LocalDate.now().plusDays(10), 7.99, false);
			fail("Fallo con matricula nula");
		} catch (OperacionNoValida e) {

		}
		
		try {
			f = new Furgoneta("AAA1", null, 20, true);
			fail("Fallo con fecha nula");
		} catch (OperacionNoValida e) {

		}
		
		f = new Furgoneta("AAA1", fecha, 0.99);
		assertTrue(f.getComercial()==true); //Compruebo que por defecto es true
		assertTrue(f.getMatricula().equals("AAA1"));
		assertTrue(f.getFechaMatriculacion().equals(fecha));
		assertTrue(f.getPotencia()==0.99);
		
		try {
			f = new Furgoneta("AAA1", LocalDate.now().minusYears(25), -10);
			fail("Fallo con potencia negativa");
		} catch (OperacionNoValida e) {
			
		}
		
	}
	/*
	@Test
	public void testGetComercial() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPotencia() {
		fail("Not yet implemented");
	}

	@Test
	public void testVehiculo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatricula() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFechaMatriculacion() {
		fail("Not yet implemented");
	}
	*/

}
