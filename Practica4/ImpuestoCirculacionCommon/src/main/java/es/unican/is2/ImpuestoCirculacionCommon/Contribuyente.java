package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class Contribuyente implements Serializable {
	
    private List<Vehiculo> vehiculos;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    
    public Contribuyente() {
    	
    }
    
    public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Contribuyente(String nombre, String apellido1, String apellido2, String dni) {
    	this.nombre = nombre;
    	this.apellido1 = apellido1;
    	this.apellido2 = apellido2;
    	this.dni = dni;
    	vehiculos = new LinkedList<Vehiculo>();
    }
    
    /**
     * Retorna el total a pagar por el impuesto 
     * de circulacion de todos sus vehiculos
     * @return Valor del impuesto a pagar
     */
    public double totalAPagar() {
    	double acum = 0;
    	
    	for (Vehiculo v : vehiculos) {
    		acum += v.precioImpuesto();
    	}
    	System.out.println("Precio contrib: " + acum);
    	return acum;
    }
    
    /**
     * Retorna la lista de vehiculos del contribuyente
     * @return lista de vehiculos del contribuyente
     */
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	/**
	 * Retorna el valor del atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Retorna el valor del atributo apellido1
	 * @return primer apellido
	 */
	public String getApellido1() {
		return apellido1;
	}
	
	/**
	 * Retorna el valor del atributo apellido2
	 * @return segundo apellido
	 */
	public String getApellido2() {
		return apellido2;
	}
	
	/**
	 * Retorna el valor del dni del contribuyente
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
    
	/**
	 * Anhade un vehiculo al contribuyente
	 * @param v vehiculo que se añade
	 */
	public void anhadeVehiculo(Vehiculo v) {
		vehiculos.add(v);
	}
	
}
