import java.io.Serializable;
import java.time.LocalDate;
@SuppressWarnings("serial")
public class Furgoneta
    extends Vehiculo implements Serializable
{
    
    private double potencia;
    private boolean comercial;

    
public Furgoneta(String matricula, LocalDate minusMonths, int potencia) {
		// TODO Auto-generated constructor stub
		super(matricula, minusMonths);
		this.potencia=potencia;
		comercial=true; //REVISAR
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
    	//TODO
		return 0;
    	
    }
}
