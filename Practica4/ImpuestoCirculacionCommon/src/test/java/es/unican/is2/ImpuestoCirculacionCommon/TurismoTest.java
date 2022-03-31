package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionCommon.Turismo;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;

public class TurismoTest {

	@Test
	public void testPrecioImpuesto() throws OperacionNoValida {
		
		//("AAA1", hoy-50años, 0.99, True):0
		Turismo f = new Turismo("AAA1", LocalDate.now().minusYears(50), 0.99);
		assertTrue(f.precioImpuesto()==0);
		
		//("BBB1", hoy-24años y 10 meses, 4, False):25,24
		f = new Turismo("BBB1", LocalDate.now().minusYears(24).minusMonths(10), 4);
		assertTrue(f.precioImpuesto()==25.24);
		
		//("BBB1", hoy, 7.99, True):20,192
		f = new Turismo("BBB1", LocalDate.now(), 7.99);
		assertTrue(f.precioImpuesto()==25.24); 
		
		//-------------
		
		//("BBB1", hoy+10dias, 8, False):68,16
		f = new Turismo("BBB1", LocalDate.now().plusDays(10), 8);
		assertTrue(f.precioImpuesto()==68.16);
		
		//("AAA1", hoy-25años, 10, False):0
		f = new Turismo("AAA1", LocalDate.now().minusYears(25), 10);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 11.99, True):54,528
		f = new Turismo("AAA1", LocalDate.now(), 11.99);
		assertTrue(f.precioImpuesto()==68.16);
		
		//------------
		
		//("BBB1", hoy+10dias, 12, False):143.88
		f = new Turismo("BBB1", LocalDate.now().plusDays(10), 12);
		assertTrue(f.precioImpuesto()==143.88);
		
		//("AAA1", hoy-50años, 14, False):0
		f = new Turismo("AAA1", LocalDate.now().minusYears(50), 14);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 15.99, True):115.104
		f = new Turismo("AAA1", LocalDate.now(), 15.99);
		assertTrue(f.precioImpuesto()==143.88);
		
		//------------
		
		//("BBB1", hoy+10dias, 16, False):179.22
		f = new Turismo("BBB1", LocalDate.now().plusDays(10), 16);
		assertTrue(f.precioImpuesto()==179.22);
		
		//("AAA1", hoy-25años, 18, False):0
		f = new Turismo("AAA1", LocalDate.now().minusYears(25), 18);
		assertTrue(f.precioImpuesto()==0);
		
		//("AAA1", hoy, 19.99, True):143.376
		f = new Turismo("AAA1", LocalDate.now(), 19.99);
		assertTrue(f.precioImpuesto()==179.22);
		
		//------------
		
		//("BBB1", hoy+10dias, 20, False):224
		f = new Turismo("BBB1", LocalDate.now(), 20);
		assertTrue(f.precioImpuesto()==224);
		
		//("AAA1", hoy-25años, 50, False):0
		f = new Turismo("AAA1", LocalDate.now().minusYears(25), 50);
		assertTrue(f.precioImpuesto()==0);
		
		
	}

	@Test
	public void testTurismo() throws OperacionNoValida {
	
		LocalDate fecha = LocalDate.now().minusYears(50);
		Turismo f = new Turismo("AAA1", fecha, 0.99);
		assertTrue(f.getMatricula().equals("AAA1"));
		assertTrue(f.getFechaMatriculacion().equals(fecha));
		assertTrue(f.getPotencia()==0.99);
		
		try {
			f = new Turismo("AAA1", LocalDate.now(), 0);
			fail("Fallo con potencia 0");
		} catch (OperacionNoValida e) {
			
		}
		
		try {
			f = new Turismo("AAA1", LocalDate.now().minusYears(25), -10);
			fail("Fallo con potencia negativa");
		} catch (OperacionNoValida e) {
			
		}
		
		try {
			f = new Turismo(null, LocalDate.now().plusDays(10), 7.99);
			fail("Fallo con matricula nula");
		} catch (OperacionNoValida e) {

		}
		
		try {
			f = new Turismo("AAA1", null, 20);
			fail("Fallo con fecha nula");
		} catch (OperacionNoValida e) {

		}
		
	}

	/*
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
