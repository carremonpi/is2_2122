package es.unican.is2.ImpuestoCirculacionBusiness;
import java.util.LinkedList;

import es.unican.is2.ImpuestoCirculacionCommon.Contribuyente;
import es.unican.is2.ImpuestoCirculacionCommon.IContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionContribuyentes;
import es.unican.is2.ImpuestoCirculacionCommon.IGestionVehiculos;
import es.unican.is2.ImpuestoCirculacionCommon.IInfoImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacionCommon.IVehiculosDAO;
import es.unican.is2.ImpuestoCirculacionCommon.OperacionNoValida;
import es.unican.is2.ImpuestoCirculacionCommon.Vehiculo;

/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	
	public Contribuyente altaContribuyente(Contribuyente c) {
		return contribuyentes.creaContribuyente(c); 
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida { 
		Contribuyente c = contribuyentes.contribuyente(dni);
		if(c.getVehiculos().size()<=0) {
			return contribuyentes.eliminaContribuyente(dni);
		} 
		throw new OperacionNoValida("El contribuyente tiene vehiculos a su nombre");	
	 }
	
	
	public Contribuyente contribuyente(String dni) { 
		return contribuyentes.contribuyente(dni);
	}
	
	
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if(c==null) { 
			return null;
		}
		
		Vehiculo v2 = vehiculos.vehiculo(v.getMatricula());
		if(v2!=null) {
			throw new OperacionNoValida("El vehiculo ya existe");
		}
		vehiculos.creaVehiculo(v); 
		c.anhadeVehiculo(v);
		return v;
		
	}
	
	
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		Vehiculo v = vehiculos.vehiculo(matricula);
		if (v == null) {
			return null;
		}
		Contribuyente c = contribuyentes.contribuyente(dni);
		if (c == null) {
			return null;
		}
		LinkedList<Vehiculo> ll = (LinkedList<Vehiculo>) c.getVehiculos();
		if(!ll.contains(v)) {
			throw new OperacionNoValida("El vehiculo no pertenece al contribuyente");
		}
		return vehiculos.eliminaVehiculo(matricula);
	}

	
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
	}	
}

