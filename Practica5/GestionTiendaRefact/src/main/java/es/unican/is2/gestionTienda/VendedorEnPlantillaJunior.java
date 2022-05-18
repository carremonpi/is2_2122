package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaJunior extends VendedorEnPlantilla {
	
	private static final double MULTIPLICADOR = 0.005;
	
	public VendedorEnPlantillaJunior(String nombre, String id, String dni) { //WMC + 1
		super(nombre, id, dni, MULTIPLICADOR);
	} //WMC = 1 CCog = 0
	
	
	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof VendedorEnPlantillaJunior)) //WMC + 1 	CCog + 1
			return false;
		VendedorEnPlantillaJunior v = (VendedorEnPlantillaJunior) obj;
		return (v.getId().equals(this.getId()) && v.getDni().equals(this.getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3		CCog = 2
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getDni() == null) ? 0 : this.getDni().hashCode());
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}
	 
	
	
} //WMC = 4 	WMCn = 2 	CCog = 2
