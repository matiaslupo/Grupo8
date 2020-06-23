package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ColeccionGenerica<T> {

	private ArrayList<T> coleccion;
	
	public ColeccionGenerica() {
		this.coleccion= new ArrayList<T>();
	}
	
	public void agregaElemento(T elemento) {
		this.coleccion.add(elemento);
	}
	
	public void eliminarElemento(T elemento) {
		this.coleccion.remove(elemento);
	}
	
	public Iterator<T> getIterator(){
		return this.coleccion.iterator();
	}
}
