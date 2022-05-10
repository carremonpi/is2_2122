package es.unican.is2.gestionTienda;

public class VendedorEnPlantillaSenior extends VendedorEnPlantilla {
	
	private static final double MULTIPLICADOR = 0.01;
	
	public VendedorEnPlantillaSenior(String nombre, String id, String dni) { //WMC + 1
		super(nombre, id, dni, MULTIPLICADOR);
	} //WMC = 1 CCog = 0
	
	@Override
	public boolean equals(Object obj) { //WMC + 1
		if (!(obj instanceof VendedorEnPlantillaSenior)) //WMC + 1 	CCog + 1
			return false;
		
		VendedorEnPlantillaSenior v = (VendedorEnPlantillaSenior) obj;
		return (v.getId().equals(this.getId()) && v.getDni().equals(this.getDni())); //WMC + 1 	CCog + 1
	} //WMC = 3		CCog = 2
	
} //WMC = 4 	WMCn = 2 	CCog = 2
