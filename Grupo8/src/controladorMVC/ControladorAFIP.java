package controladorMVC;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import servicios.Factura;
import vistaMVC.ventanaAFIP;

/**
 * @author Grupo8
 * Hilo de ejecucion para una ventana de la AFIP
 *
 */
public class ControladorAFIP extends Thread {

	private Controlador cont;
	private Random r=new Random();
	private RecursoCompartido recurso;
	private ArrayList<Factura> facturasClonadas;
	
	


	public ControladorAFIP(RecursoCompartido recurso,ArrayList<Factura> facturasClonadas,Controlador cont) {
		super();
		this.recurso = recurso;
		this.cont= cont;
		this.facturasClonadas= facturasClonadas;
	}

	




	/**
	 * Sobreescribe el metodo de Thread para crear la ventana de AFIP y utilizar el recurso compartido.
	 * Muestra en la ventana todas las Facturas.
	 */
	@Override
	public void run() {
		ventanaAFIP vista= new ventanaAFIP();
		vista.setActionListener(cont);
		recurso.usar_RecursoAFIP(vista);
		String texto="";
		Iterator<Factura> iterador= this.facturasClonadas.iterator();
		while(iterador.hasNext()) {
			long tiempo= r.nextInt(10000)+5000;
			try {
				sleep(tiempo);
			} catch (InterruptedException e) {}
			texto= texto+iterador.next().toString()+"\n";
			vista.seteaText(texto);
		}
		try {
			sleep(20000);
		} catch (InterruptedException e) {}
		this.recurso.liberaRecursoAFIP(vista);
	}
	
	
}
