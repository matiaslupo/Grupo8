package controladorMVC;

import java.util.ArrayList;
import java.util.Random;

import servicios.Factura;
import vistaMVC.ventanaAFIP;
import vistaMVC.ventanaAltaSocio;

/**
 * @author Grupo8
 * Hilo de ejecucion para una ventana de agregar socio.
 */
public class ControladorAgregarSocio extends Thread {


	private Controlador cont;
	private Random r=new Random();
	private RecursoCompartido recurso;
	private ventanaAltaSocio vista;
	
	




	public ControladorAgregarSocio(Controlador cont, RecursoCompartido recurso) {
		super();
		this.cont = cont;
		this.recurso = recurso;
	}
	
	



	public void liberar() {
		recurso.liberaRecursoAS(this.vista);
	}


	/**
	 * Sobreescribe el metodo de Thread para crear la ventana de Agregar Socio e intenta usar el recurso compartido.
	 */
	@Override
	public void run() {
		vista= new ventanaAltaSocio();
		vista.setActionlistener(cont);
		cont.setVistaAltaSocio(vista);
		recurso.usar_RecursoAS(vista);
	}
	
	
	
}
