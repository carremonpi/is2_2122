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
		return contribuyentes.creaContribuyente(c); //OK
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida { //OK
		Contribuyente c = contribuyentes.contribuyente(dni);
		if(c.getVehiculos().size()<=0) {
			return contribuyentes.eliminaContribuyente(dni);
		} 
		throw new OperacionNoValida("El contribuyente tiene vehiculos a su nombre");	
	 }
	
	public Contribuyente contribuyente(String dni) { //OK
		return contribuyentes.contribuyente(dni);
	}
	
	//SIN TERMINAR
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		Contribuyente c = contribuyentes.contribuyente(dni);
		if(c==null) { //Con equals o ==
			return null;
		}
		//c.getVehiculos() y ver si el vehiculo ya esta en la lista
		Vehiculo v2 = vehiculos.vehiculo(v.getMatricula());
		if(v2!=null) {
			throw new OperacionNoValida("El vehiculo ya existe");
			//Comunicar que ya existe vehiculo
			
		}
		vehiculos.creaVehiculo(v); //No se si hay que crearlo o solo asignarselo a la persona
		c.anhadeVehiculo(v);
		return v;
		
	}


	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		// TODO
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
		//SE ELIMINA DE LA BASE DE DATOS O SE DA DE BAJA A ESE VEHICULO DEL USUARIO?
		return vehiculos.eliminaVehiculo(matricula);
		//return null;
	}

	
	public Vehiculo vehiculo(String matricula) {
		return vehiculos.vehiculo(matricula);
		//return null;
	}	
}

