package es.unican.is2.gestionTienda;


public class VendedorEnPlantilla extends Vendedor { //WMC = 6 
	
	private TipoVendedor tipo;
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String id, String dni, TipoVendedor tipo) { //WMC + 1
		super(nombre, id);
		this.tipo = tipo;
		this.dni=dni;
	} //WMC = 1		CCog=0
	
	public TipoVendedor tipo() { //WMC + 1
		return tipo;
	} //WMC = 1		CCog=0
	
	public String getDni() { //WMC + 1
		return dni;
	} //WMC = 1		CCog=0
	
	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof VendedorEnPlantilla)) //WMC + 1 	CCog + 1
			return false;
		VendedorEnPlantilla v = (VendedorEnPlantilla) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3		CCog = 2
}
