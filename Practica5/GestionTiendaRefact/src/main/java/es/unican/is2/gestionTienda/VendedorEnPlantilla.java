package es.unican.is2.gestionTienda;


public abstract class VendedorEnPlantilla extends Vendedor {
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni, double multiplicador) { //WMC + 1
		super(nombre, id, dni, multiplicador);
	} //WMC = 1		CCog=0
	
}
