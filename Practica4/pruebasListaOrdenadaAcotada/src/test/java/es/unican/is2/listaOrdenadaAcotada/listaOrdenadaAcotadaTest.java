package es.unican.is2.listaOrdenadaAcotada;

import static org.junit.Assert.*;

import org.junit.Test;

public class listaOrdenadaAcotadaTest {
	
	@Test
	public void testConstructor() {
		ListaOrdenadaAcotada<String> lista = new ListaOrdenadaAcotada<String>(5);
		assertTrue(lista.size() == 0);
		lista = new ListaOrdenadaAcotada<String>();
	}
	
	@Test
	public void testGetYAdd() {
		//Lista vacia
		ListaOrdenadaAcotada<String> lista = new ListaOrdenadaAcotada<String>(5);
		
		try {
			lista.get(0); //El 0 porque es el mas probable que si esta mal hecho funcione
			fail("No se puede hacer get en una lista vacia");
		} catch (IndexOutOfBoundsException e) {}
		
		//Lista con elementos
		lista.add("Zoo");
		lista.add("Avion");
		lista.add("Balon");
		assertTrue(lista.size()==3);
		
		//Se prueba que elementos no introducidos no sean validos
		try {
			lista.get(3); 
			fail("No se puede acceder a un elemento que no esta en la lista (3) ");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			lista.get(4); 
			fail("No se puede acceder a un elemento que no esta en la lista (4)");
		} catch (IndexOutOfBoundsException e) {}
		
		//Lista con elementos indices ilegales
		try {
			lista.get(-1);
			fail("La lista no tiene elemento -1");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			lista.get(-20);
			fail("La lista no tiene elemento -20");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			lista.get(5);
			fail("La lista no tiene elemento 5");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			lista.get(20);
			fail("La lista no tiene elemento 20");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			lista.add("Casa");
			lista.add("Xilofono");
			assertTrue(lista.get(0).equals("Avion"));
			assertTrue(lista.get(1).equals("Balon"));
			assertTrue(lista.get(2).equals("Casa"));
			assertTrue(lista.get(3).equals("Xilofono"));
			assertTrue(lista.get(4).equals("Zoo")); //Comprobamos que ha ordenado bien los numeros
			assertTrue(lista.size()==5);
			
			lista.add("Moto"); //Compruebo que no se pueden añadir mas elementos que la capacidad de la lista
			fail("La lista no puede tener mas de 5 elementos"); 
		} catch (IllegalStateException e) {}
		
	}
	
	@Test
	public void testRemove() {
		ListaOrdenadaAcotada<String> lista = new ListaOrdenadaAcotada<String>(5);
		
		try {
			lista.remove(0); //El 0 porque es el mas probable que si esta mal hecho funcione
			fail("No se puede hacer remove en una lista vacia");
		} catch (IndexOutOfBoundsException e) {} 
		
		//Lista con elementos
		lista.add("Casa");
		lista.add("Avion");
		lista.add("Xilofono");
		lista.add("Zoo");
		lista.add("Balon"); //["Avion", "Balon", "Casa", "Xilofono", "Zoo"]
		
		assertTrue(lista.remove(2).equals("Casa"));
		
		assertTrue(lista.get(0).equals("Avion"));
		assertTrue(lista.get(1).equals("Balon"));
		assertTrue(lista.get(2).equals("Xilofono"));
		assertTrue(lista.get(3).equals("Zoo")); //Compruebo que se mantiene el orden correcto
		
		assertTrue(lista.size()==4); //Comprobamos que el numero de elmentos es el correcto
		
		//Compruebo que se ha eliminado bien el elemento arriba
		try {
			lista.remove(4); 
			fail("No se puede hacer remove en una lista vacia");
		} catch (IndexOutOfBoundsException e) {} 
			
		
		try {
			lista.remove(-1);
			fail("No se puede eliminar una posicion negativa (-1)");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			lista.remove(-20);
			fail("No se puede eliminar una posicion negativa (-20)");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			lista.remove(5);
			fail("No se puede eliminar una mayor que el tamaño maximo de la lista (5)");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			lista.remove(20);
			fail("No se puede eliminar una mayor que el tamaño maximo de la lista (20)");
		} catch(IndexOutOfBoundsException e) {}
		
		
	}

	@Test
	public void testClear() {
		ListaOrdenadaAcotada<String> lista = new ListaOrdenadaAcotada<String>(5);
		lista.add("Casa");
		lista.add("Avion");
		lista.add("Xilofono");
		lista.add("Zoo");
		lista.add("Balon"); //["Avion", "Balon", "Casa", "Xilofono", "Zoo"]
		lista.clear();
		assertTrue(lista.size()==0);
		
		try {
			lista.get(0); //El 0 porque es el mas probable que si esta mal hecho funcione
			fail("No se puede hacer get en una lista vacia");
		} catch (IndexOutOfBoundsException e) {}
			
	}

}
