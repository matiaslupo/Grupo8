package controladorMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import excepciones.DomicilioInvalidoException;
import excepciones.NoPuedeContratarException;
import excepciones.NoPuedeDarDeBajaException;
import excepciones.NoPuedePagarException;
import excepciones.PersonaExistenteException;
import excepciones.ServicioInternetInvalidoException;
import interfaces.I_Pago;
import mediospagos.PagoCheque;
import mediospagos.PagoEfectivo;
import mediospagos.PagoTarjeta;
import modelo.EmuladorPasoTiempo;
import modelo.GestorDeFacturacion;
import modeloMVC.SistemaContrataciones;
import persistencia.PersistenciaBIN;
import personas.Fisica;
import personas.Juridica;
import servicios.Domicilio;
import servicios.DomicilioCasa;
import servicios.DomicilioDepto;
import vistaMVC.ventanaAgregarServicio;
import vistaMVC.ventanaAltaSocio;
import vistaMVC.ventanaModificarServicio;
import vistaMVC.ventanaPagar;
import vistaMVC.ventanaPrincipal;
import vistaMVC.ventanaQuitarServicio;
/**
 * @author Grupo8
 *<br>
 *Clase que representa el controlador que cumple su funcion de controlar y gestionar datos al modelo
 */
public class Controlador implements ActionListener, Observer {
	private ventanaPrincipal vistaPrincipal;
	private ventanaAltaSocio vistaAltaSocio;
	private ventanaAgregarServicio vistaAgregarServicio;
	private ventanaModificarServicio vistaModificarServicio;
	private ventanaPagar vistaPagar;
	private ventanaQuitarServicio vistaQuitarServicio;
	private Observable ept;
	private SistemaContrataciones sistema;
	private GestorDeFacturacion gestor;
	private final String nombArch= "Sistema.bin";
	private PersistenciaBIN persistenciaBIN;
	private RecursoCompartido recurso;
	private ControladorAgregarSocio contAS;
	
	public Controlador() {
		vistaPrincipal= new ventanaPrincipal();
		vistaPrincipal.setActionlistener(this);
		this.persistenciaBIN=new PersistenciaBIN();
		this.recuperarSistema();
		this.ept= sistema.getEmPasoTiempo();
		this.vistaPrincipal.setMesActual(sistema.getEmPasoTiempo().getMesActual());
		this.ept.addObserver(this);
		this.gestor=new GestorDeFacturacion();
		this.recurso= new RecursoCompartido();
	}

	
	/**
	 * Metodo que se dispara al actualizarse el Emulador de Paso de Tiempo. Actualiza ademas el mes enumerado en la vista principal.<br>
	 * En caso de que el mes actualizado sea par, hace un llamado a la AFIP.
	 * @param arg0: Parametro tipo observable. Debe ser el Emulador de Paso de Tiempo al que este controlador observa
	 * @param arg1: Parametro tipo object que, en este caso, siempre sera null.   
	 */
	public void update(Observable arg0, Object arg1) {
		if (arg0==this.ept) {
			EmuladorPasoTiempo obj= (EmuladorPasoTiempo) arg0;
			int mes= obj.getMesActual();
			this.vistaPrincipal.setMesActual(mes);
			if ((mes % 2) == 0) {
				sistema.duplicarFacturas();
				ControladorAFIP afip= new ControladorAFIP(recurso,sistema.getListaFacturasClonadas(),this);
				afip.start();
			}
		}
	}
	

	
	public void actionPerformed(ActionEvent arg0) {
		String comando= arg0.getActionCommand();
		if (comando.equalsIgnoreCase("AGREGAR SERVICIO")) {
			this.vistaAgregarServicio.setVisible(false);
			String internet="";
			if (this.vistaAgregarServicio.cienIsSelected())
				  	internet= "Internet100";
			else if (this.vistaAgregarServicio.quinientosIsSelected())
					internet="Internet500";
			Domicilio domicilio=null;
			if (this.vistaAgregarServicio.casaIsSelected())
				domicilio= new DomicilioCasa(this.vistaAgregarServicio.getCalle(),this.vistaAgregarServicio.getAltura());
			else if (this.vistaAgregarServicio.departamentoIsSelected())
				domicilio=new DomicilioDepto(this.vistaAgregarServicio.getCalle(),this.vistaAgregarServicio.getAltura(),this.vistaAgregarServicio.getPiso(),this.vistaAgregarServicio.getDescripcion());
			try {
				try {
					sistema.agregarServicio(this.vistaAgregarServicio.getNombre(),internet,this.vistaAgregarServicio.getCantCelular(),this.vistaAgregarServicio.getCantFijo(),this.vistaAgregarServicio.getCantTV(), domicilio);
				} catch (ServicioInternetInvalidoException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				} catch (DomicilioInvalidoException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NoPuedeContratarException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			}
			this.vistaAgregarServicio.dispose();
			
		}
		else if (comando.equalsIgnoreCase("AGREGAR SOCIO")) {
			this.vistaAltaSocio.setVisible(false);
			this.contAS.liberar();
			if (this.vistaAltaSocio.getFisica())
				try {
					sistema.agregarAbonado(new Fisica(this.vistaAltaSocio.getNombre(),this.vistaAltaSocio.getDNI()));
				} catch (PersonaExistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				}
			else if (this.vistaAltaSocio.getJuridica())
				try {
					sistema.agregarAbonado(new Juridica(this.vistaAltaSocio.getNombre(),this.vistaAltaSocio.getCUIT()));
				} catch (PersonaExistenteException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				}
			this.vistaAltaSocio.dispose();
		}
		else if (comando.equalsIgnoreCase("ABRIR AGREGAR SOCIO")) { // Ventana Principal
			/*this.vistaAltaSocio =new ventanaAltaSocio();
			this.vistaAltaSocio.setActionlistener(this);*/
			
			contAS= new ControladorAgregarSocio(this,recurso);
			contAS.start();
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
			this.vistaQuitarServicio= new ventanaQuitarServicio();
			this.vistaQuitarServicio.setActionlistener(this);
		}
		else if (comando.equalsIgnoreCase("EPT")) { // Ventana Principal
			EmuladorPasoTiempo obj= (EmuladorPasoTiempo)this.ept;
			gestor.agregarObservable(obj);
			obj.avanzarMes();
		}
		else if (comando.contentEquals("ABRIR PAGAR")) { // Ventana Principal
			this.vistaPagar= new ventanaPagar();
			this.vistaPagar.setActionlistener(this);
		}
		else if (comando.contentEquals("MODIFICAR SERVICIO")) {
			this.vistaModificarServicio.setVisible(false);
			sistema.modificarAgregado(this.vistaModificarServicio.getNombre(), this.vistaModificarServicio.getCalle() + " "+this.vistaModificarServicio.getAltura()	, this.vistaModificarServicio.getAccion(), this.vistaModificarServicio.getPack());
			this.vistaModificarServicio.dispose();
		}
		else if (comando.equalsIgnoreCase("QUITAR SERVICIO")) {
			this.vistaQuitarServicio.setVisible(false);
			try {
				sistema.eliminarContratacion(this.vistaQuitarServicio.getNombre(),this.vistaQuitarServicio.getDomicilio());
			} catch (NoPuedeDarDeBajaException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			}
			this.vistaQuitarServicio.dispose();
		}
		else if (comando.contentEquals("PAGAR")) {
			this.vistaPagar.setVisible(false);
			I_Pago tipo=null;
			if(this.vistaPagar.efectivoPago())
				tipo=new PagoEfectivo();
			else if(this.vistaPagar.chequePago())
				tipo=new PagoCheque();
			else if(this.vistaPagar.tarjetaPago())
				tipo=new PagoTarjeta();
			try {
				sistema.pagarFactura(this.vistaPagar.getNombre(),tipo,this.vistaPagar.getMes());
			} catch (NoPuedePagarException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
			}
			this.vistaPagar.dispose();
		}
		else if (comando.equalsIgnoreCase("FINALIZAR JORNADA")) {
			this.guardarSistema();
			this.vistaPrincipal.dispose();
		}
	}
	
	private void recuperarSistema() {
		SistemaContrataciones sistema=null;
		try {
			this.persistenciaBIN.abrirInput(nombArch);
			this.sistema= (SistemaContrataciones) this.persistenciaBIN.leer();
			this.persistenciaBIN.cerrarInput();
		} catch (IOException e) {
			this.sistema=SistemaContrataciones.getInstancia(); 
		}
		catch (ClassNotFoundException e) {
			this.sistema=SistemaContrataciones.getInstancia(); 
		}
	}
	
	private void guardarSistema() {
		try {
			this.persistenciaBIN.abrirOutput(nombArch);
			this.persistenciaBIN.escribir(sistema);
			this.persistenciaBIN.cerrarOutput();
		} catch (IOException e) {
			 System.out.println(e.getLocalizedMessage());
		}
	}

	public void setVistaAltaSocio(ventanaAltaSocio vistaAltaSocio) {
		this.vistaAltaSocio = vistaAltaSocio;
	}
	
	
	

}
