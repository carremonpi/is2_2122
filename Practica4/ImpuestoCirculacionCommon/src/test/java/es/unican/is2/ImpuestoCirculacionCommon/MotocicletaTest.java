package es.unican.is2.ImpuestoCirculacionCommon;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionCommon.Motocicleta;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;

public class MotocicletaTest {

	@Test
	public void testPrecioImpuesto() throws OperacionNoValida {

		// ("AAA1", hoy-50años, 0.99, True):0
		Motocicleta sut = new Motocicleta("AAA1", LocalDate.now().minusYears(50), 1);
		assertTrue(sut.precioImpuesto() == 0);

		// ("BBB1", hoy-24años y 10 meses, 4, False):25,24
		sut = new Motocicleta("BBB1", LocalDate.now().minusYears(24).minusMonths(10), 75);
		assertTrue(sut.precioImpuesto() == 8.84);

		// ("BBB1", hoy, 7.99, True):20,192
		sut = new Motocicleta("BBB1", LocalDate.now(), 125);
		assertTrue(sut.precioImpuesto() == 8.84);

		// -------------

		// ("BBB1", hoy+10dias, 8, False):68,16
		sut = new Motocicleta("BBB1", LocalDate.now().plusDays(10), 126);
		assertTrue(sut.precioImpuesto() == 15.14);

		// ("AAA1", hoy-25años, 10, False):0
		sut = new Motocicleta("AAA1", LocalDate.now().minusYears(25), 180);
		assertTrue(sut.precioImpuesto() == 0);

		// ("AAA1", hoy, 11.99, True):54,528
		sut = new Motocicleta("AAA1", LocalDate.now(), 250);
		assertTrue(sut.precioImpuesto() == 15.14);

		// ------------

		// ("BBB1", hoy+10dias, 12, False):143.88
		sut = new Motocicleta("BBB1", LocalDate.now().plusDays(10), 251);
		assertTrue(sut.precioImpuesto() == 30.30);

		// ("AAA1", hoy-50años, 14, False):0
		sut = new Motocicleta("AAA1", LocalDate.now().minusYears(50), 375);
		assertTrue(sut.precioImpuesto() == 0);

		// ("AAA1", hoy, 15.99, True):115.104
		sut = new Motocicleta("AAA1", LocalDate.now(), 500);
		assertTrue(sut.precioImpuesto() == 30.30);

		// ------------

		// ("BBB1", hoy+10dias, 16, False):179.22
		sut = new Motocicleta("BBB1", LocalDate.now().plusDays(10), 501);
		assertTrue(sut.precioImpuesto() == 60.58);

		// ("AAA1", hoy-25años, 18, False):0
		sut = new Motocicleta("AAA1", LocalDate.now().minusYears(25), 750);
		assertTrue(sut.precioImpuesto() == 0);

		// ("AAA1", hoy, 19.99, True):143.376
		sut = new Motocicleta("AAA1", LocalDate.now(), 1000);
		assertTrue(sut.precioImpuesto() == 60.58);

		// ------------

		// ("BBB1", hoy+10dias, 20, False):224
		sut = new Motocicleta("BBB1", LocalDate.now(), 1001);
		assertTrue(sut.precioImpuesto() == 121.16);

		// ("AAA1", hoy-25años, 50, False):0
		sut = new Motocicleta("AAA1", LocalDate.now().minusYears(25), 2000);
		assertTrue(sut.precioImpuesto() == 0);
		
	}

	@Test
	public void testMotocicleta() throws OperacionNoValida {

		LocalDate fecha = LocalDate.now().minusYears(50);
		Motocicleta sut = new Motocicleta("AAA1", fecha, 125);
		assertTrue(sut.getMatricula().equals("AAA1"));
		assertTrue(sut.getFechaMatriculacion().equals(fecha));
		assertTrue(sut.getCilindrada() == 125);

		try {
			sut = new Motocicleta("AAA1", LocalDate.now(), 0);
			fail("Fallo con cilindrada 0");
		} catch (OperacionNoValida e) {

		}

		try {
			sut = new Motocicleta("AAA1", LocalDate.now().minusYears(25), -75);
			fail("Fallo con cilindrada negativa");
		} catch (OperacionNoValida e) {

		}
		
		try {
			sut = new Motocicleta(null, LocalDate.now().plusDays(10), 75);
			fail("Fallo con matricula nula");
		} catch (OperacionNoValida e) {

		}
		
		try {
			sut = new Motocicleta("AAA1", null, 75);
			fail("Fallo con fecha nula");
		} catch (OperacionNoValida e) {

		}
		

	}
	
}
