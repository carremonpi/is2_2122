package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
@SuppressWarnings("serial")
public class Furgoneta
    extends Vehiculo implements Serializable
{
    
    private double potencia;
    private boolean comercial;
    private final int porcentajeDescuento = 20;
    
	public Furgoneta(String matricula, LocalDate fechaMatriculacion, double potencia) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		if(potencia <= 0) {
			throw new OperacionNoValida("La potencia de una furgoneta no puede ser 0 ni negativa");
		}
		this.potencia=potencia;
		comercial=true; //REVISAR
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
    
  
	@Override
    public double precioImpuesto() {
		double resultado;
    	if(super.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)) || super.getFechaMatriculacion().isEqual(LocalDate.now().minusYears(25)) ) {
    		resultado = 0;
    	} else if(comercial==false) {
	    	if(potencia < 8) {
	    		resultado = 25.24;
	    	} else if(potencia < 12) {
	    		resultado = 68.16;
	    	} else if(potencia < 16) {
	    		resultado = 143.88;
	    	} else if(potencia < 20) {
	    		resultado = 179.22;
	    	} else {
	    		resultado = 224;
	    	}
    	} else {
    		double descuentoSobre1 = 1-(porcentajeDescuento/100);
    		if(potencia < 8) {
    			resultado = 25.24*0.8;
	    	} else if(potencia < 12) {
	    		resultado = 68.16*0.8;
	    	} else if(potencia < 16) {
	    		resultado = 143.88*0.8;
	    	} else if(potencia < 20) {
	    		resultado = 179.22*0.8;
	    	} else {
	    		resultado = 224*0.8;
	    	}
    	}
    	
    	return resultado;
    	
    }
}
