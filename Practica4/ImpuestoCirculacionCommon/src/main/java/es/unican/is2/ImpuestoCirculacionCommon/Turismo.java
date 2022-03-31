package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;


	public Turismo(String matricula, LocalDate fechaMatriculacion, double potencia) throws OperacionNoValida {
		super(matricula, fechaMatriculacion);
		if(potencia <= 0) {
			throw new OperacionNoValida("La potencia de un turismo no puede ser negativa");
		}
		this.potencia=potencia;
	}


	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
       
    
    /**
     * Retorna el precio del impuesto a pagar
     *  @return precio
     */
	@Override
    public double precioImpuesto() {
		if(super.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)) || super.getFechaMatriculacion().isEqual(LocalDate.now().minusYears(25)) ) {
    		return 0;
    	} 
    	if(potencia < 8) {
    		return 25.24;
    	} else if(potencia < 12) {
    		return 68.16;
    	} else if(potencia < 16) {
    		return 143.88;
    	} else if(potencia < 20) {
    		return 179.22;
    	} else {
    		return 224;
    	}
    }
    
}
