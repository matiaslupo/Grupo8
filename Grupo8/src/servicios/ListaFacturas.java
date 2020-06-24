package servicios;

import java.util.Iterator;

import modelo.ColeccionGenerica;

public class ListaFacturas extends ColeccionGenerica<I_Factura> implements I_ColeccionDeFacturas {

	public ListaFacturas() {
		
	}

	public void agregarFactura(I_Factura factura, int mes) {
		super.agregaElemento(factura, mes);		
	}

	public void eliminarFactura(I_Factura factura) {
		super.eliminarElemento(factura);		
	}

	public void pagarFactura(I_Factura factura) {
				
	}

	/*
	
	public Iterator<I_Factura> getFacturaIterator() {
		return super.getIterator();
	} */

	public int facturasSinPagar() {
		int cant= 0;
		Iterator<I_Factura> facturas= super.getKeyIterator();
		while (facturas.hasNext()) {
			if (!facturas.next().isPagado())
				cant++;
		}
		return cant;
	}

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
