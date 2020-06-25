package modelo;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import personas.Persona;
import servicios.Factura;
import servicios.I_Factura;
/**
 * @author Grupo8
 *<br>
 *Clase para el gestor de Facturacion e implementa Observer
 */
public class GestorDeFacturacion implements Observer {

	private EmuladorPasoTiempo ept;
	
	public GestorDeFacturacion() {}
	/**
	 * Agrega Observable a la lista de los Observers 
	 * <b>Pre: </b> ept debe ser distinto de null<br>
	 * <b>Post: </b> agregado el Observable<br>
	 * @param ept: Parametro de tipo EmuladorPasoTiempo para setear el mismo
	 */
	public void agregarObservable(EmuladorPasoTiempo ept) {
		ept.addObserver(this);
		this.ept= ept;
	}

	/**
	 * Metodo UpDate que permite realizar las facturas con sus correspondientes detalles
	 */
	public void update(Observable o, Object arg1) {
		EmuladorPasoTiempo ept= (EmuladorPasoTiempo) o;
		if (this.ept == ept && arg1 != null) {
			Iterator<Persona> personas= (Iterator<Persona>) arg1;
			Persona actual= null;
			int mes= ept.getMesActual() - 1; //El Gestor trabaja con el mes anterior al que actualiza el EPT
			while (personas.hasNext()) {
				actual= personas.next();
				I_Factura factura= new Factura();
				factura.setDetalles(actual.listarContrataciones());
				factura.setTotalSinP(actual.precioOriginal());
				factura.setTotalConP(factura.getTotalSinP()); //se va a actualizar en el momento de pagar
				actual.getColeccionDeFacturas().agregarFactura(factura, mes);
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}	

