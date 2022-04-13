package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Vehiculo implements Serializable
{
    
    private static final int precioBaseTramo5 = 224;
	private static final double precioBaseTramo4 = 179.22;
	private static final double precioBaseTramo3 = 143.88;
	private static final double precioBaseTramo2 = 68.16;
	private static final double precioBaseTramo1 = 25.24;
	private static final int limiteTramo4 = 20;
	private static final int limiteTramo3 = 16;
	private static final int limiteTramo2 = 12;
	private static final int limiteTramo1 = 8;
	
	private double potencia;
    private boolean comercial;
    private final double descuentoComercial = 0.20;
    
	public Furgoneta(String matricula, LocalDate fechaMatriculacion, double potencia) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		if(potencia <= 0) {
			throw new OperacionNoValida("La potencia de una furgoneta no puede ser 0 ni negativa");
		}
		this.potencia=potencia;
		comercial=true;
	}
	
	public Furgoneta(String matricula, LocalDate fechaMatriculacion, double potencia, boolean comercial) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		if(potencia <= 0) {
			throw new OperacionNoValida("La potencia de una furgoneta no puede ser 0 ni negativa");
		}
		this.potencia=potencia;
		this.comercial=comercial; 
	}

/**
    * Retorna el valor del atributo comercial
    * @return true si la furgoneta es de uso comercial
    *         false si no es de uso comercial
    */
    public boolean getComercial() {
    	return comercial;
    }
    
    /**
	 * Retorna la potencia de la furgoneta
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
    
    
    /**
     * Calcula el precio para el vehiculo.
     */
	@Override
    public double precioImpuesto() {
		double resultado;
    	if(super.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)) || super.getFechaMatriculacion().isEqual(LocalDate.now().minusYears(25)) ) {
    		resultado = 0;
    	} else {
    		resultado = calculaDescuento();
    	}
    	
    	return Math.round(resultado*100.0)/100.0;
    }
	
	
	/**
	 * Metodo privado que calcula el precio en funcion del descuento indicado
	 * @param porcentajeDescuento descuento a aplicar en porcentaje
	 * @return el precio con el descuento aplicado
	 */
	private double calculaDescuento() {
		double resultado;
		if(potencia < limiteTramo1) {
			resultado = precioBaseTramo1;
		} else if(potencia < limiteTramo2) {
			resultado = precioBaseTramo2;
		} else if(potencia < limiteTramo3) {
			resultado = precioBaseTramo3;
		} else if(potencia < limiteTramo4) {
			resultado = precioBaseTramo4;
		} else {
			resultado = precioBaseTramo5;
		}
		
		if (comercial) {
			resultado = resultado*(1-descuentoComercial);
		}
		
		return resultado;
	}
}
