package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaJunior extends VendedorEnPlantilla {
	
	private static final double MULTIPLICADOR = 0.005;
	
	public VendedorEnPlantillaJunior(String nombre, String id, String dni) {
		super(nombre, id, dni, MULTIPLICADOR);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof VendedorEnPlantillaJunior)) //WMC + 1 	CCog + 1
			return false;
		VendedorEnPlantillaJunior v = (VendedorEnPlantillaJunior) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3		CCog = 2
}
