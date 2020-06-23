package servicios;

import java.util.Iterator;

import modelo.ColeccionGenerica;

public class ListaFacturas extends ColeccionGenerica<I_Factura> implements I_ColeccionDeFacturas {

	public ListaFacturas() {
		// TODO Auto-generated constructor stub
	}

	public void agregarFactura(I_Factura factura) {
		super.agregaElemento(factura);		
	}

	public void eliminarFactura(I_Factura factura) {
		super.eliminarElemento(factura);		
	}

	public void pagarFactura(I_Factura factura) {
		// TODO Auto-generated method stub
		
	}

	public Iterator<I_Factura> getFacturaIterator() {
		return super.getIterator();
	}

	public int facturasSinPagar() {
		return 0;
	}


}
