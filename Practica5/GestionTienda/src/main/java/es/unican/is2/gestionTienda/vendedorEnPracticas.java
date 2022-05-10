package es.unican.is2.gestionTienda;


public class vendedorEnPracticas extends Vendedor {
	
	private String dni;
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) { //WMC + 1
		super(nombre, id);
		this.dni= dni;
	} //WMC = 1 	CCog = 0
	
	public String getDni() {  //WMC + 1
		return dni;
	} //WMC = 1 	CCog = 0

	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof vendedorEnPracticas))  //WMC + 1 	CCog + 1
			return false;
		vendedorEnPracticas v = (vendedorEnPracticas) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3 	CCog = 2
	
} //WMC = 5 	WMCn = 1,66 	CCog = 2
