package estados;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import modelo.EmuladorPasoTiempo;
import personas.Fisica;
import personas.Persona;
/**
 * @author Grupo8
 *<br>
 *Clase que implementa Observer para el actualizador de estado, que revisa el estado de cada abonado fisico para ver si debe cambiar de estado
 */
public class ActualizadorDeEstado implements Observer {

	private EmuladorPasoTiempo ept;
	
	public ActualizadorDeEstado() {}
	/**
	 * que hace...
	 * <b>Pre: </b>  <br>
	 * <b>Post: </b> <br>
	 * @param ept: Parametro de tipo EmuladorPasoTiempo para .......
	 */
	public void agregarObservable(EmuladorPasoTiempo ept) {
		ept.addObserver(this);
		this.ept= ept;
	}
	/**
	 * que hace.....
	 * <b>Pre: </b>  <br>
	 * <b>Post: </b> <br>
	 * @param arg0: Parametro de tipo Observable para .....
	 * @param arg1: Parametro de tipo Object para .....
	 */

	public void update(Observable arg0, Object arg1) {
		if (arg0 == ept && arg1 != null) {
			Iterator<Persona> personas= (Iterator<Persona>) arg1;
			Persona actual= null;
			while (personas.hasNext()) {
				actual= personas.next();
				if (actual instanceof Fisica && actual.getColeccionDeFacturas().facturasSinPagar() > 1) {
					Fisica fisica= (Fisica) actual;
					fisica.setMoroso();
				}
			}
		}	
		else {
				throw new IllegalArgumentException();
		}
	}

}
