package controladorMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import modelo.EmuladorPasoTiempo;
import vistaMVC.ventanaAgregarServicio;
import vistaMVC.ventanaAltaSocio;
import vistaMVC.ventanaModificarServicio;
import vistaMVC.ventanaPagar;
import vistaMVC.ventanaPrincipal;

public class Controlador implements ActionListener, Observer {
	private ventanaPrincipal vistaPrincipal;
	private ventanaAltaSocio vistaAltaSocio;
	private ventanaAgregarServicio vistaAgregarServicio;
	private ventanaModificarServicio vistaModificarServicio;
	private ventanaPagar vistaPagar;
	private EmuladorPasoTiempo ept;
	
	public Controlador() {
		vistaPrincipal= new ventanaPrincipal();
		vistaPrincipal.setActionlistener(this);
		this.ept= new EmuladorPasoTiempo();
		this.vistaPrincipal.setMesActual(1);
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent arg0) {
		String comando= arg0.getActionCommand();
		if (comando.equalsIgnoreCase("AGREGAR SERVICIO")) {
			
		}
		else if (comando.equalsIgnoreCase("AGREGAR SOCIO")) {
			
		}
		else if (comando.equalsIgnoreCase("ABRIR AGREGAR SOCIO")) { // Ventana Principal
			this.vistaAltaSocio =new ventanaAltaSocio();
			this.vistaAltaSocio.setActionlistener(this);
		}
		else if (comando.equalsIgnoreCase("ABRIR BUSCAR SOCIO")) { // Ventana Principal
			
		}
		else if (comando.equalsIgnoreCase("ABRIR QUITAR SOCIO")) { // Ventana Principal
			
		}
		else if (comando.equalsIgnoreCase("ABRIR AGREGAR SERVICIO")) { // Ventana Principal
			this.vistaAgregarServicio= new ventanaAgregarServicio();
			this.vistaAgregarServicio.setActionListener(this);
		}
		else if (comando.equalsIgnoreCase("ABRIR MODIFICAR SERVICIO")){ // Ventana Principal
			this.vistaModificarServicio=new ventanaModificarServicio();
			this.vistaModificarServicio.setActionlistener(this);
		}
		else if (comando.equalsIgnoreCase("ABRIR QUITAR SERVICIO")) { // Ventana Principal
			
		}
		else if (comando.equalsIgnoreCase("EPT")) { // Ventana Principal
			
		}
		else if (comando.contentEquals("ABRIR PAGAR")) { // Ventana Principal
			this.vistaPagar= new ventanaPagar();
			this.vistaPagar.setActionlistener(this);
		}
		else if (comando.contentEquals("MODIFICAR SERVICIO")) {
			
		}
		else if (comando.contentEquals("PAGAR")) {
			
		}
	}

}
