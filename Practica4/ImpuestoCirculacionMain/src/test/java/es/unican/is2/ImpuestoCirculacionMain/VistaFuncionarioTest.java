package es.unican.is2.ImpuestoCirculacionMain;

import static org.junit.Assert.assertTrue;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionBusiness.GestionImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionContribuyentes;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionVehiculos;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionDAO.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionDAO.VehiculosDAO;
import es.unican.is2.ImpuestoCirculacionGUI.VistaFuncionario;

public class VistaFuncionarioTest {
	
	private FrameFixture demo;

	@Before
	public void setUp() {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
				
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		VistaFuncionario gui = new VistaFuncionario(negocio, negocio, negocio);
		
		demo = new FrameFixture(gui);
		
		gui.setVisible(true);	
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		
		// Comprobamos que la interfaz tiene el aspecto deseado
		//demo.label("lblPrecio").requireText("Total A Pagar");
		//demo.label("lblVehiculos").requireText("Vehiculos");
		//demo.label("lblNombreCobtribuyente").requireText("Nombre");
		//demo.label("lblDatosContribuyente").requireText("Datos Contribuyente");
		//demo.label("lblDniContribuyente").requireText("DNI Contribuyente");
		
		demo.button("btnBuscar").requireText("Buscar");
		demo.button().requireVisible();
		
		//  Prueba de saludo con nombre
		
		// Escribimos un nombre
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		// Pulsamos el botón
		demo.button("btnBuscar").click();		
		// Comprobamos la salida
		demo.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		//demo.list()
		//demo.list("listVehiculos").requireItemCount(2);
		demo.list("listVehiculos").requireItemCount(2);
		demo.list("listVehiculos").clickItem("1111-AAA");
		demo.list("listVehiculos").clickItem("1111-BBB");
		String lista[] = demo.list("listVehiculos").contents();
		assertTrue(lista[0].equals("1111-AAA"));
		assertTrue(lista[1].equals("1111-BBB"));
		
		demo.textBox("txtTotalContribuyente").requireText("403.2");
		
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
		
		
	}
	

}