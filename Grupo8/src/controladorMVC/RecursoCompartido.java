package controladorMVC;

import vistaMVC.ventanaAFIP;
import vistaMVC.ventanaAgregarServicio;
import vistaMVC.ventanaAltaSocio;

/**
 * @author Grupo8
 * Simula el uso del recurso compartido y bloquea el uso de agregar socios o la aparicion de la ventana de la AFIP correspondientemente
 */
public class RecursoCompartido {
	private boolean ocupadoAgregaSocio=false, ocupadoAfip=false;
	
	/**
	 * Metodo que crea la ventana de Alta de Socios en caso de no estar la AFIP
	 * @param vistaAS: Ventana de alta de socios que se abrira en caso de no estar ocupado el recurso compartido
	 */
	public synchronized void usar_RecursoAS(ventanaAltaSocio vistaAS) {
		while (this.ocupadoAfip) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.ocupadoAgregaSocio= true;
		vistaAS.setVisible(true);
	}
	
	/**
	 * Metodo que crea la ventana de la AFIP en caso de no estar abierta la ventana de alta de socios
	 * @param vistaAFIP: Ventana de la AFIP que se abrira en caso de no estar abierta la ventana de Alta de socios
	 */
	public synchronized void usar_RecursoAFIP(ventanaAFIP vistaAFIP) {
		while(this.ocupadoAgregaSocio) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.ocupadoAfip=true;
		vistaAFIP.setVisible(true);
	}
	
	/**
	 * Hace que la ventana de alta de socios libere el recurso compartido
	 * @param vistaAS: Ventana de alta de socios abierta
	 */
	public synchronized void liberaRecursoAS(ventanaAltaSocio vistaAS){
		this.ocupadoAgregaSocio=false;
		notifyAll();
	}
	
	/**
	 * Hace que la ventana de la AFIP libere el recurso compartido
	 * @param vistaAFIP: Ventana de la AFIP abierta
	 */
	public synchronized void liberaRecursoAFIP(ventanaAFIP vistaAFIP) {
		this.ocupadoAfip=false;
		vistaAFIP.setVisible(false);
		notifyAll();
	}
	
}
