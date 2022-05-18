package es.unican.is2.gestionTienda;


public class VendedorEnPracticas extends Vendedor {
	
	private static final double MULTIPLICADOR = 0;
	
	/**
	 * Retorna un nuevo vendedor en pr�cticas
	 * @param nombre
	 * @param dni
	 */
	public VendedorEnPracticas(String nombre, String id, String dni) { //WMC + 1
		super(nombre, id, dni, MULTIPLICADOR);
	} //WMC = 1 	CCog = 0

	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof VendedorEnPracticas))  //WMC + 1 	CCog + 1
			return false;
		VendedorEnPracticas v = (VendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3 	CCog = 2
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getDni() == null) ? 0 : this.getDni().hashCode());
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}
	
} //WMC = 4 	WMCn = 2 	CCog = 2
