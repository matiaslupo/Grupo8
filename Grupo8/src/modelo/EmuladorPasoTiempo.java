package modelo;

import java.util.Observable;

import ModeloMVC.SistemaContrataciones;

public class EmuladorPasoTiempo extends Observable {
	
	private int mesActual;

	public EmuladorPasoTiempo() {
		this.mesActual= 1;
	}
	
	public int getMesActual() {
		return mesActual;
	}

	public void setMesActual(int mesActual) {
		this.mesActual = mesActual;
	}

	public void avanzarMes() {
		this.mesActual++;
		this.setChanged();
		this.notifyObservers(SistemaContrataciones.getInstancia().getPersonas());
	}
	
}
