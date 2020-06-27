
package servicios;

import java.io.Serializable;
import java.util.Iterator;

import interfaces.I_ColeccionDeFacturas;
import interfaces.I_Factura;
import modelo.ColeccionGenerica;

@SuppressWarnings("serial")
public class ListaFacturas extends ColeccionGenerica<I_Factura> implements I_ColeccionDeFacturas,Serializable {

	/**
	 * Constructor vacio
	 */
	public ListaFacturas() {
	}

	/**
	 *Metodo que agrega la factura a la coleccion generica
	 */
	public void agregarFactura(I_Factura factura, int mes) {
		super.agregaElemento(mes, factura);
		
	}
	
	/**
	 *Metodo que busca la factura correspondiente en la coleccion generica
	 */
	public I_Factura buscarFactura(int mes) {
		return super.getElemento(mes);
	}
	
	public Iterator<I_Factura> getFacturaIterator() {
		return super.getValuesIterator();
	}
	
	/**
	 *Metodo que busca cuantas facturas hay sin pagar
	 *@return la cantidad de facturas sin pagar
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
	 *Metodo que clona la coleccion
	 *@return devuelve la coleccion clonada
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
