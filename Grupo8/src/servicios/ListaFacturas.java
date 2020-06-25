
package servicios;

import java.util.Iterator;

import modelo.ColeccionGenerica;

/**
 * @author Grupo8
 * Clase que hereda la coleccion generica para una lista de I_Factura, e implementa la interfaz I_ColeccionDeFacturas
 * Esta clase permite mantener un HashMap de facturas con un mes asignado, su recuperacion y evaluacion de cantidad de facturas sin pagar
 */
public class ListaFacturas extends ColeccionGenerica<I_Factura> implements I_ColeccionDeFacturas {

	public ListaFacturas() {
		super();
	}

	/**
	 * Agrega una Factura a la Lista de Facturas y le asigna el mes ingresado
	 * <b>Pre: </b> El parametro Factura debe ser distinto de null, el parametro mes debe ser un entero positivo
	 * <b>Post: </b> Agrega 'factura' a la 'ListaFacturas', asignada a 'mes'
	 * @param factura: Parametro de tipo I_Factura que se asignara a la ListaFacturas
	 * @param mes: Entero que representa el mes al que pertenece la factura
	 */
	public void agregarFactura(I_Factura factura, int mes) {
		super.agregaElemento(mes, factura);
		
	}
	
	/**
	 * Devuelve una referencia a la factura correspondiente al mes indicado
	 * <b>Pre: </b> El parametro mes debe ser un entero positivo
	 * <b>Post: </b> Devuelve la factura correspondiente
	 * @param mes: Entero que representa el mes al que corresponde la factura que se desea recuperar
	 * @return Devuelve una referencia a una I_Factura correspondiente al parametro mes 
	 */
	public I_Factura buscarFactura(int mes) {
		return super.getElemento(mes);
	}
	
	/**
	 * Devuelve un iterator con todas las facturas en la lista
	 * @return Iterator con todas las facturas en la lista
	 */
	public Iterator<I_Factura> getFacturaIterator() {
		return super.getValuesIterator();
	}

	/**
	 * Devuelve la cantidad de facturas sin pagar
	 *  @return Entero positivo con la cantidad de facturas sin pagar
	 */
	public int facturasSinPagar() {
		int cant= 0;
		Iterator<I_Factura> facturas= super.getValuesIterator();
		while (facturas.hasNext()) {
			if (!facturas.next().isPagado())
				cant++;
		}
		return cant;
	}

	/**
	 * Devuelve una copia de la lista de facturas
	 *  @return Copia de todas las facturas
	 */
	public Object clone() {
		ListaFacturas clonado= null;
		try {
			clonado = (ListaFacturas) super.clone();
		} catch (CloneNotSupportedException e) {
			// Siempre clonable
		}
		return clonado;		
	}
	
}
