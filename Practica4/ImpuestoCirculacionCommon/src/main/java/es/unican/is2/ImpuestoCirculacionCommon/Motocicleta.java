package es.unican.is2.ImpuestoCirculacionCommon;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private static final double precioBaseTramo5 = 121.16;
	private static final double precioBaseTramo4 = 60.58;
	private static final double precioBaseTramo3 = 30.30;
	private static final double precioBaseTramo2 = 15.14;
	private static final double precioBaseTramo1 = 8.84;
	private static final int limiteTramo4 = 1000;
	private static final int limiteTramo3 = 500;
	private static final int limiteTramo2 = 250;
	private static final int limiteTramo1 = 125;
	private int cilindrada;

    public Motocicleta(String matricula, LocalDate fechaMatriculacion, int cilindrada) throws OperacionNoValida {
    	super(matricula, fechaMatriculacion);
    	if(cilindrada <= 0) {
    		throw new OperacionNoValida("La cilindrada de una moto no puede ser 0 ni negativa");
    	}
		this.cilindrada=cilindrada;
	}


	/**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
  
    
    /**
     * Calcula el precio del impuesto
     */
	@Override
    public double precioImpuesto() {
		if(super.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)) || super.getFechaMatriculacion().isEqual(LocalDate.now().minusYears(25)) ) {
    		return 0;
    	} 
    	if(cilindrada <= limiteTramo1) {
    		return precioBaseTramo1;
    	} else if(cilindrada <= limiteTramo2) {
    		return precioBaseTramo2;
    	} else if(cilindrada <= limiteTramo3) {
    		return precioBaseTramo3;
    	} else if(cilindrada <= limiteTramo4) {
    		return precioBaseTramo4;
    	} else {
    		return precioBaseTramo5;
    	}
		
    }
}
