package es.unican.is2.ImpuestoCirculacionCommon;
import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{
	
	private static final double precioBaseTramo5 = 224;
	private static final double precioBaseTramo4 = 179.22;
	private static final double precioBaseTramo3 = 143.88;
	private static final double precioBaseTramo2 = 68.16;
	private static final double precioBaseTramo1 = 25.24;
	private static final int limiteTramo4 = 20;
	private static final int limiteTramo3 = 16;
	private static final int limiteTramo2 = 12;
	private static final int limiteTramo1 = 8;

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
		double resultado;
		if(super.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)) || super.getFechaMatriculacion().isEqual(LocalDate.now().minusYears(25)) ) {
    		resultado = 0;
    	} else {
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
		}
		
		return resultado;
    }
    
}
