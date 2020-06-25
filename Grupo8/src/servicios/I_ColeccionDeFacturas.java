
package servicios;

import java.util.Iterator;
/**
 *@author Grupo8
 *<br>
 *Interfaz para la coleccion de Facturas
 */
public interface I_ColeccionDeFacturas {

	/**
	 * Agrega una factura a la ColeccionDeFacturas
	 * <b>Pre: </b> factura debe ser distinto de null, mes debe ser un entero positivo
	 * <b>Post: </b> Agrega la factura a la coleccion
	 * @param factura: Parametro de tipo I_Factura que se agregara a la coleccion, asociado a 'mes' 
	 * @param mes: Entero que indica el mes al que corresponde la factura
	 */
	void agregarFactura(I_Factura factura, int mes);
	
	//void pagarFactura(I_Factura factura);
	
	/**
	 * Busca una factura. Puede devolver null en caso de no encontrartla
	 * @param mes: Entero positivo que indica el mes al que corresponde la factura
	 * @return Objeto de tipo I_Factura asociado a 'mes'
	 */
	I_Factura buscarFactura(int mes);
	
	/**
	 * Devuelve un iterator con todas las facturas en la lista
	 * @return Objeto tipo Iterator con todas las facturas tipo I_Factura
	 */
	Iterator<I_Factura> getFacturaIterator();
	
	/**
	 * Devuelve la cantidad de facturas sin pagar en la coleccion
	 * @return Entero que indica la cantidad de facturas sin pagar en la coleccion
	 */
	int facturasSinPagar();
	
	/**
	 * Clona todas las facturas en la coleccion
	 * @return Devuelve un Object del tipo que implemente esta interface con todas las facturas en la coleccion clonadas 
	 * @throws CloneNotSupportedException En caso de alguna ocurrencia donde alguna factura no pueda ser clonada
	 */
	Object clone() throws CloneNotSupportedException;
	
}
