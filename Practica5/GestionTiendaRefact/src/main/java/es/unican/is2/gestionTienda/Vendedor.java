package es.unican.is2.gestionTienda;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	private String dni;
	
	private final double MULTIPLICADOR;
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double totalVentasMensuales;
	
	protected Vendedor(String nombre, String id, String dni, double multiplicador) { //WMC + 1
		this.nombre = nombre;
		this.id = id;
		this.dni = dni;
		this.MULTIPLICADOR = multiplicador;
		totalVentasMensuales = 0;
	} //WMC = 1 	CCog=0
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getDni() {  //WMC + 1
		return dni;
	} //WMC = 1 	CCog = 0
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public double getMultiplicador() {  //WMC + 1
		return MULTIPLICADOR;
	} //WMC = 1 	CCog = 0
	
	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() { //WMC + 1
		return nombre;
	} //WMC = 1		CCog=0
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() { //WMC + 1
		return id;
	} //WMC = 1		CCog=0
	
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() { //WMC + 1
		return totalVentasMensuales;
	} //WMC = 1		CCog=0
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setTotalVentas(double totalVentas) { //WMC + 1
		this.totalVentasMensuales = totalVentas;
	} //WMC = 1		CCog=0
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhadeVenta(double importe){ //WMC + 1
		totalVentasMensuales += importe + importe * MULTIPLICADOR;
	} //WMC = 1		CCog=0

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (dni == null) {
			
		} else if (!dni.equals(other.dni))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
} //WMC = 7 	WMCn = 1 	CCog = 0
