package es.unican.is2.ImpuestoCirculacionMain;

import static org.junit.Assert.assertTrue;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ImpuestoCirculacionBusiness.GestionImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionDAO.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionDAO.VehiculosDAO;
import es.unican.is2.ImpuestoCirculacionGUI.VistaFuncionario;

public class VistaFuncionarioTest {
	
	private FrameFixture sut;

	@Before
	public void setUp() {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
				
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		VistaFuncionario gui = new VistaFuncionario(negocio, negocio, negocio);
		
		sut = new FrameFixture(gui);
		
		gui.setVisible(true);	
	}
	
	@After
	public void tearDown() {
		sut.cleanUp();
	}
	
	@Test
	public void test() {
		
		// Comprobamos que la interfaz tiene el aspecto deseado
		sut.button("btnBuscar").requireText("Buscar");
		sut.button().requireVisible();
		
		//  Prueba de DNI valido
		
		// Escribimos un DNI valido
		sut.textBox("txtDniContribuyente").enterText("11111111A");
		// Pulsamos el botón
		sut.button("btnBuscar").click();		
		// Comprobamos la salida
		sut.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		sut.list("listVehiculos").requireItemCount(2);
		sut.list("listVehiculos").clickItem("1111-AAA");
		sut.list("listVehiculos").clickItem("1111-BBB");
		String lista[] = sut.list("listVehiculos").contents();
		assertTrue(lista[0].equals("1111-AAA"));
		assertTrue(lista[1].equals("1111-BBB"));
		
		sut.textBox("txtTotalContribuyente").requireText("403.2");
		
		// Prueba de usuario sin DNI
		sut.textBox("txtDniContribuyente").setText("");
		sut.button("btnBuscar").click();
		sut.textBox("txtNombreContribuyente").requireText("DNI No Válido");
		sut.textBox("txtTotalContribuyente").requireText("0");
		lista = sut.list("listVehiculos").contents();
		assertTrue(lista.length == 0);
		
		// Prueba de usuario con DNI no valido
		sut.textBox("txtDniContribuyente").setText("777Z");
		sut.button("btnBuscar").click();
		sut.textBox("txtNombreContribuyente").requireText("DNI No Válido");
		sut.textBox("txtTotalContribuyente").requireText("0");
		lista = sut.list("listVehiculos").contents();
		assertTrue(lista.length == 0);
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	

}