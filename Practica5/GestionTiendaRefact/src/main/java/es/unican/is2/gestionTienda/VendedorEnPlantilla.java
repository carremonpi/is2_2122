package es.unican.is2.gestionTienda;


public abstract class VendedorEnPlantilla extends Vendedor {
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre el nombre del vendedor
	 * @param id el id del vendedor
	 * @param dni el dni del vendedor
	 * @param multiplicador la bonificacion a las ventas del vendedor
	 */
	protected VendedorEnPlantilla(String nombre, String id, String dni, double multiplicador) { //WMC + 1
		super(nombre, id, dni, multiplicador);
	} //WMC = 1		CCog=0
	
} //WMC = 1 	WMCn = 1 	CCog = 0
