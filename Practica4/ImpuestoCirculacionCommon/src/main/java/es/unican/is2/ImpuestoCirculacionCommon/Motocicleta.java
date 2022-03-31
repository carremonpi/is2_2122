package es.unican.is2.ImpuestoCirculacionCommon;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
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
    
  
	@Override
    public double precioImpuesto() {
		if(super.getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25)) || super.getFechaMatriculacion().isEqual(LocalDate.now().minusYears(25)) ) {
    		return 0;
    	} 
    	if(cilindrada <= 125) {
    		return 8.84;
    	} else if(cilindrada <= 250) {
    		return 15.14;
    	} else if(cilindrada <= 500) {
    		return 30.30;
    	} else if(cilindrada <= 1000) {
    		return 60.58;
    	} else {
    		return 121.16;
    	}
		
    }
}
