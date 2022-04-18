package es.unican.is2.listaOrdenadaAcotada;

import static org.junit.Assert.*;

import org.junit.Test;

public class listaOrdenadaAcotadaTest {
	
	@Test
	public void testConstructor() {
		ListaOrdenadaAcotada<String> sut = new ListaOrdenadaAcotada<String>(5);
		assertTrue(sut.size() == 0);
		sut = new ListaOrdenadaAcotada<String>();
	}
	
	@Test
	public void testGetYAdd() {
		//Lista vacia
		ListaOrdenadaAcotada<String> sut = new ListaOrdenadaAcotada<String>(5);
		
		try {
			sut.get(0); //El 0 porque es el mas probable que si esta mal hecho funcione
			fail("No se puede hacer get en una lista vacia");
		} catch (IndexOutOfBoundsException e) {}
		
		//Lista con elementos
		sut.add("Zoo");
		sut.add("Avion");
		sut.add("Balon");
		assertTrue(sut.size()==3);
		
		//Se prueba que elementos no introducidos no sean validos
		try {
			sut.get(3); 
			fail("No se puede acceder a un elemento que no esta en la lista (3) ");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.get(4); 
			fail("No se puede acceder a un elemento que no esta en la lista (4)");
		} catch (IndexOutOfBoundsException e) {}
		
		//Lista con elementos indices ilegales
		try {
			sut.get(-1);
			fail("La lista no tiene elemento -1");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.get(-20);
			fail("La lista no tiene elemento -20");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.get(5);
			fail("La lista no tiene elemento 5");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.get(20);
			fail("La lista no tiene elemento 20");
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			sut.add("Casa");
			sut.add("Xilofono");
			assertTrue(sut.get(0).equals("Avion"));
			assertTrue(sut.get(1).equals("Balon"));
			assertTrue(sut.get(2).equals("Casa"));
			assertTrue(sut.get(3).equals("Xilofono"));
			assertTrue(sut.get(4).equals("Zoo")); //Comprobamos que ha ordenado bien los numeros
			assertTrue(sut.size()==5);
			
			sut.add("Moto"); //Compruebo que no se pueden añadir mas elementos que la capacidad de la lista
			fail("La lista no puede tener mas de 5 elementos"); 
		} catch (IllegalStateException e) {}
		
	}
	
	@Test
	public void testRemove() {
		ListaOrdenadaAcotada<String> sut = new ListaOrdenadaAcotada<String>(5);
		
		try {
			sut.remove(0); //El 0 porque es el mas probable que si esta mal hecho funcione
			fail("No se puede hacer remove en una lista vacia");
		} catch (IndexOutOfBoundsException e) {} 
		
		//Lista con elementos
		sut.add("Casa");
		sut.add("Avion");
		sut.add("Xilofono");
		sut.add("Zoo");
		sut.add("Balon"); //["Avion", "Balon", "Casa", "Xilofono", "Zoo"]
		
		assertTrue(sut.remove(2).equals("Casa"));
		
		assertTrue(sut.get(0).equals("Avion"));
		assertTrue(sut.get(1).equals("Balon"));
		assertTrue(sut.get(2).equals("Xilofono"));
		assertTrue(sut.get(3).equals("Zoo")); //Compruebo que se mantiene el orden correcto
		
		assertTrue(sut.size()==4); //Comprobamos que el numero de elmentos es el correcto
		
		//Compruebo que se ha eliminado bien el elemento arriba
		try {
			sut.remove(4); 
			fail("No se puede hacer remove en una lista vacia");
		} catch (IndexOutOfBoundsException e) {} 
			
		
		try {
			sut.remove(-1);
			fail("No se puede eliminar una posicion negativa (-1)");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			sut.remove(-20);
			fail("No se puede eliminar una posicion negativa (-20)");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			sut.remove(5);
			fail("No se puede eliminar una mayor que el tamaño maximo de la lista (5)");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			sut.remove(20);
			fail("No se puede eliminar una mayor que el tamaño maximo de la lista (20)");
		} catch(IndexOutOfBoundsException e) {}
		
		
	}

	@Test
	public void testClear() {
		ListaOrdenadaAcotada<String> sut = new ListaOrdenadaAcotada<String>(5);
		sut.add("Casa");
		sut.add("Avion");
		sut.add("Xilofono");
		sut.add("Zoo");
		sut.add("Balon"); //["Avion", "Balon", "Casa", "Xilofono", "Zoo"]
		sut.clear();
		assertTrue(sut.size()==0);
		
		try {
			sut.get(0); //El 0 porque es el mas probable que si esta mal hecho funcione
			fail("No se puede hacer get en una lista vacia");
		} catch (IndexOutOfBoundsException e) {}
			
	}

}
