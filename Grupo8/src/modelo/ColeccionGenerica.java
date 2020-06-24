
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ColeccionGenerica<T extends Cloneable> implements Cloneable {

	private HashMap<T, Integer> coleccion;
	
	public ColeccionGenerica() {
		this.coleccion= new HashMap<T, Integer>();
	}
	
	public void agregaElemento(T elemento, Integer valor) {
		this.coleccion.put(elemento, valor);
	}
	
	public void eliminarElemento(T elemento) {
		this.coleccion.remove(elemento);
	}
	
	public Iterator<T> getKeyIterator(){
		return this.coleccion.keySet().iterator();
	}
	
	public Object clone() throws CloneNotSupportedException {
		ColeccionGenerica clonado= null;
		clonado= (ColeccionGenerica) super.clone();
		Iterator<T> keys= clonado.coleccion.keySet().iterator();
		Iterator<Integer> values= clonado.coleccion.values().iterator();
		clonado.coleccion.clear();
		while (keys.hasNext() && values.hasNext()) {
			
		}
		return clonado;
	}
}
