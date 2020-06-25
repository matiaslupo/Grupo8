package estados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import modelo.EmuladorPasoTiempo;
import personas.Fisica;
import personas.Persona;

public class ActualizadorDeEstado implements Observer {

	private EmuladorPasoTiempo ept;
	
	public ActualizadorDeEstado() {
	}
	
	public void agregarObservable(EmuladorPasoTiempo ept) {
		ept.addObserver(this);
		this.ept= ept;
	}

	public void update(Observable arg0, Object arg1) {
		if (arg0 == ept) {
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
