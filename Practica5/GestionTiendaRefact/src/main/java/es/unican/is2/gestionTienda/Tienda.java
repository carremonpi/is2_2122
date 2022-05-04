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

	private LinkedList<Vendedor> vendedores = new LinkedList<Vendedor>();
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
		/*
		if (vendedor instanceof VendedorEnPlantilla) { //WMC + 1 		CCog + 1
			switch (((VendedorEnPlantilla) vendedor).tipo()) { //CCog + 2
			case JUNIOR: //WMC + 1
				importeFinal += importeFinal * 0.005;
				break;
			case SENIOR: //WMC + 1
				importeFinal += importeFinal * 0.01;
				break;
			}
		}
		*/
		vendedor.anhade(importeFinal);
		vuelcaDatos();
		return true;
	} //WMC = 5  	CCog = 4

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
	} //WMC = 9 	CCog = 10

	private void leeFichero() {
		vendedores = new LinkedList<Vendedor>();
		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(datos));
			// configura el formato de números
			in.useLocale(Locale.ENGLISH);
			nombre = in.nextLine();
			direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) { //WMC + 2 	CCog + 2

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantillaJunior(nombre, idIn, dni);
				ven.setT(totalVentas);
				vendedores.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Prácticas")) { //WMC + 2 		CCog + 2
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantillaSenior(nombre, idIn, dni);
				ven.setT(totalVentas);
				vendedores.add(ven);
			}
			while (in.hasNext()) { //WMC + 1 		CCog + 1
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				String dni= in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPracticas(nombre, idIn, dni);
				ven.setT(totalVentas);
				vendedores.add(ven);
			}
		} catch (FileNotFoundException e) { //CCog + 1 
		} finally {
			if (in != null) {//WMC + 1 	    CCog + 1
				in.close();
			}
		}
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { //WMC + 1
		
		leeFichero();

		return vendedores;

	} //WMC = 7 	CCog = 7

	/**
	 * Método que actualiza el fichero datosTienda.txt 
	 * con los datos actualizados de los vendedores
	 */
	private void vuelcaDatos() throws IOException { //WMC + 1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		clasificaVendedores(senior, junior, practicas);

		try {

			out = new PrintWriter(new FileWriter(datos));

			out.println(nombre);
			out.println(direccion);
			out.println();
			out.println("Senior");
			for (Vendedor v : senior) { //WMC + 1 	 CCog + 1
				VendedorEnPlantilla v1 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v1.getNombre() + " Id: " + v1.getId() + " DNI: "+ v1.getDni()+" TotalVentasMes: "
						+ v1.getTotalVentas());
			}
			out.println();
			out.println("Junior");
			for (Vendedor v : junior) { //WMC + 1 	CCog + 1
				VendedorEnPlantilla v2 = (VendedorEnPlantilla) v;
				out.println("  Nombre: " + v2.getNombre() + " Id: " + v2.getId() + " DNI: "+ v2.getDni()+" TotalVentasMes: "
						+ v2.getTotalVentas());
			}
			out.println();
			out.println("Prácticas");
			for (Vendedor v : practicas) { //WMC + 1 	CCog + 1
				VendedorEnPracticas v3 = (VendedorEnPracticas) v;
				out.println("  Nombre: " + v3.getNombre() + " Id: " + v3.getId() + " DNI: "+ v3.getDni()+" TotalVentasMes: "
						+ v3.getTotalVentas());
			}

		} finally {
			if (out != null) //WMC + 1 	 CCog + 1
				out.close();
		}
	} //WMC = 9 	CCog = 12

	private void clasificaVendedores(List<Vendedor> senior, List<Vendedor> junior, List<Vendedor> practicas) {
		for (Vendedor v : vendedores) { //WMC + 1 	CCog + 1
			if (v instanceof VendedorEnPracticas) { //WMC + 1 	CCog + 2
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla) { //WMC + 1 	CCog + 1
				VendedorEnPlantilla vp = (VendedorEnPlantilla) v;
				if (vp instanceof VendedorEnPlantillaJunior) //WMC + 1 		CCog + 3 
					junior.add(vp);
				else //CCog + 1
					senior.add(vp);
			}
		}
	}

}
