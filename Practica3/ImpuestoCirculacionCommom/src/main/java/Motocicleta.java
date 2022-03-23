import java.time.LocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    public Motocicleta(String matricula, LocalDate fechaMatriculacion, int cilindrada) {
    	super(matricula, fechaMatriculacion);
		this.cilindrada=cilindrada;
		// TODO Auto-generated constructor stub
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
		//TODO
		return 0;
    }
}
