package es.unican.is2.gestionTienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores.
 * Gestiona las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como parámetro al crear la tienda
 */
public class Tienda {

	private LinkedList<Vendedor> vendedores = new LinkedList<>();
	private String direccion;
	private String nombre;

	private String datos;

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { //WMC + 1
		this.datos = datos;
	} //WMC = 1 	CCog = 0

	/**
	 * Retorna la dirección de la tienda
	 * @return Dirección de la tienda
	 */
	public String direccion() { //WMC + 1
		return direccion;
	} //WMC = 1 	CCog = 0

	/**
	 * Retorna el nombre de la tienda
	 * @return Nombre de la tienda
	 */
	public String nombre() { //WMC + 1
		return nombre;
	} //WMC = 1 	CCog = 0

	/**
	 * Añade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya había un vendedor con el mismo id
	 */
	public boolean anhadeVendedor(Vendedor nuevoVendedor) throws IOException { //WMC + 1
		Vendedor vendedor = buscaVendedor(nuevoVendedor.getId()); 
		if (vendedor != null) { //WMC + 1 		CCog + 1
			return false;
		}
		vendedores.add(nuevoVendedor); 
		vuelcaDatos(); 
		return true;
	} //WMC = 2		CCog = 1

	/**
	 * Elimina el vendedor cuyo dni se pasa como parámetro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ningún vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException { //WMC + 1
		Vendedor vendedor = buscaVendedor(id);
		if (vendedor == null) { //WMC + 1 		CCog + 1
			return false;
		}
		vendedores.remove(vendedor);
		vuelcaDatos();
		return true;
	} //WMC = 2 		CCog = 1

	/**
	 * Añade una venta a un vendedor
	 * @param id Id del vendedor
	 * @param importe Importe de la venta
	 * @return true si se añade la venta 
	 *         false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException { //WMC + 1
		Vendedor vendedor = buscaVendedor(id);
		if (vendedor == null) { //WMC + 1 		CCog + 1
			return false;
		}
		double importeFinal = importe;
		
		vendedor.anhadeVenta(importeFinal);
		vuelcaDatos();
		return true;
	} //WMC = 2  	CCog = 1

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) { //WMC + 1

		leeFichero(); 

		for (Vendedor v : vendedores) { //WMC + 1 	CCog + 1
			if (v.getId().equals(id)) { //WMC + 1 		CCog + 2
				return v;
			}
		}
		return null;
	} //WMC = 3 	CCog = 3

	private void leeFichero() { //WMC + 1
		vendedores = new LinkedList<>();
		
		// abre el fichero
		try (Scanner in = new Scanner(new FileReader(datos))) {
			
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			// lee los vendedores senior
			leeVendedorSenior(in);
			
			// lee los vendedores junior
			leeVendedorJunior(in);
			
			// lee los vendedores en practicas
			leeVendedorEnPracticas(in);
			
		} catch (FileNotFoundException e) { //CCog + 1 
			
		} 
		
	} //WMC = 2 	CCog = 2
	
	/**
	 * Lee los vendedores en practicas del fichero.
	 * @param in objeto de la clase Scanner para leer el fichero
	 */
	private void leeVendedorEnPracticas(Scanner in) { //WMC + 1
		Vendedor ven;
		while (in.hasNext()) { //WMC + 1 		CCog + 1
			in.next();
			String nombreLeido = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPracticas(nombreLeido, idIn, dni);
			ven.setTotalVentas(totalVentas);
			vendedores.add(ven);
		}
	}//WMC = 2 	CCog = 1
	
	/**
	 * Lee los vendedores en plantilla junior del fichero.
	 * @param in objeto de la clase Scanner para leer el fichero
	 */
	private void leeVendedorJunior(Scanner in) { //WMC + 1
		Vendedor ven;
		while (in.hasNext() && !in.next().equals("Prácticas")) { //WMC + 2 		CCog + 2
			String nombreLeido = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantillaJunior(nombreLeido, idIn, dni);
			ven.setTotalVentas(totalVentas);
			vendedores.add(ven);
		}
	} //WMC = 3 	CCog = 2
	
	/**
	 * Lee los vendedores en plantilla senior del fichero.
	 * @param in objeto de la clase Scanner para leer el fichero
	 */
	private void leeVendedorSenior(Scanner in) { //WMC + 1
		Vendedor ven;
		while (in.hasNext() && !in.next().equals("Junior")) { //WMC + 2 	CCog + 2

			String nombreLeido = in.next();
			in.next();
			String idIn = in.next();
			in.next();
			String dni= in.next();
			in.next();
			double totalVentas = in.nextDouble();
			ven = new VendedorEnPlantillaSenior(nombreLeido, idIn, dni);
			ven.setTotalVentas(totalVentas);
			vendedores.add(ven);
		}
	} //WMC = 3 	CCog = 2

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { //WMC + 1
		
		leeFichero();

		return vendedores;

	} //WMC = 1 	CCog = 0

	/**
	 * Método que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	private void vuelcaDatos() throws IOException { //WMC + 1
		
		List<Vendedor> senior = new LinkedList<>();
		List<Vendedor> junior = new LinkedList<>();
		List<Vendedor> practicas = new LinkedList<>();

		clasificaVendedores(senior, junior, practicas);

		try (PrintWriter out = new PrintWriter(new FileWriter(datos))) {

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			escribeVendedor(out, senior);
			out.println();
			out.println("Junior");
			escribeVendedor(out, junior);
			out.println();
			out.println("Prácticas");
			escribeVendedor(out, practicas);

		} 
	} //WMC = 2	CCog = 1
	
	/**
	 * Escribe la lista de vendedores indicada en el fichero indicado.
	 * @param out fichero donde escribir los datos
	 * @param vendedores vendedores a escribir
	 */
	private void escribeVendedor(PrintWriter out, List<Vendedor> vendedores) { //WMC + 1
		for (Vendedor v : vendedores) { //WMC + 1 	CCog + 1
			VendedorEnPracticas vendedor = (VendedorEnPracticas) v;
			out.println("  Nombre: " + vendedor.getNombre() + " Id: " + vendedor.getId() + " DNI: "+ vendedor.getDni()+" TotalVentasMes: "
					+ vendedor.getTotalVentas());
		}
	} //WMC = 2	CCog = 1

	/**
	 * Metodo para clasificar los vendedores en diferentes listas
	 * @param senior lista donde se meteran los vendedores senior
	 * @param junior lista donde se meteran los vendedores junior
	 * @param practicas lista donde se meteran los vendedores en practicas
	 */
	private void clasificaVendedores(List<Vendedor> senior, List<Vendedor> junior, List<Vendedor> practicas) { //WMC + 1
		for (Vendedor v : vendedores) { //WMC + 1 	CCog + 1
			if (v instanceof VendedorEnPracticas) { //WMC + 1 	CCog + 2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) { //WMC + 1 	CCog + 1
				if (v instanceof VendedorEnPlantillaJunior) //WMC + 1 		CCog + 3 
					junior.add(v);
				else //CCog + 1
					senior.add(v);
			}
		}
	} //WMC = 5	CCog = 7

} //WMC = 32 	WMCn = 2,13 	CCog = 22
