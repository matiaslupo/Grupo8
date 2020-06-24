package modelo;

import java.util.HashMap;
import java.util.Iterator;

public class ColeccionGenerica<K,T> {

	private HashMap<K,T> coleccion;
	
	public ColeccionGenerica() {
		this.coleccion= new HashMap<K,T>();
	}
	
	public void agregaElemento(K dato,T elemento) {
		this.coleccion.put(dato, elemento);
	}
	
	public Iterator<EntrySet<K,T>> getIterator(){
		return this.coleccion.entrySet().iterator();
	}
}
