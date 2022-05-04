package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaSenior extends VendedorEnPlantilla {
	
	private static final double MULTIPLICADOR = 0.01;
	
	public VendedorEnPlantillaSenior(String nombre, String id, String dni) {
		super(nombre, id, dni, MULTIPLICADOR);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof VendedorEnPlantillaSenior)) //WMC + 1 	CCog + 1
			return false;
		VendedorEnPlantillaSenior v = (VendedorEnPlantillaSenior) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3		CCog = 2
}
