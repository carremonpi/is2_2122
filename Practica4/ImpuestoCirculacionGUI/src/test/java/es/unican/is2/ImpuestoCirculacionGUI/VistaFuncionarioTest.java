package es.unican.is2.ImpuestoCirculacionGUI;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionCommon.IGestionContribuyentes;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionVehiculos;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;

public class VistaFuncionarioTest {
	
	private FrameFixture demo;
	private IGestionContribuyentes contribuyentes;
	private IGestionVehiculos vehiculos;
	private IInfoImpuestoCirculacion info;

	@Before
	public void setUp() {
		
		VistaFuncionario gui = new VistaFuncionario(contribuyentes, vehiculos, info);
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		/*
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.label("lblPrecio").requireText("Total A Pagar");
		demo.label("lblVehiculos").requireText("Vehiculos");
		//demo.label("lblNombreCobtribuyente").requireText("Nombre");
		demo.label("lblDatosContribuyente").requireText("Datos Contribuyente");
		demo.label("lblDniContribuyente").requireText("DNI Contribuyente");
		
		demo.button("btnBuscar").requireText("Buscar");
		//demo.button().requireVisible();
		
		//  Prueba de saludo con nombre
		// Escribimos un nombre
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		// Pulsamos el botón
		demo.button("btnBuscar").click();		
		// Comprobamos la salida
		demo.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		//demo.list()
		demo.textBox("txtTotalContribuyente").requireText("249.24");
		// Prueba de saludo sin nombre
		//demo.textBox("txtNombre").setText("");
		//demo.button("btnPulsar").click();
		//demo.textBox("txtSaludo").requireText("¡Hola!");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	

}
