package modeloMVC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import agregado.ContratableFactory;
import excepciones.DomicilioInvalidoException;
import excepciones.NoPuedeContratarException;
import excepciones.NoPuedeDarDeBajaException;
import excepciones.NoPuedePagarException;
import excepciones.PersonaExistenteException;
import excepciones.ServicioInternetInvalidoException;
import interfaces.I_Sistema;
import modelo.EmuladorPasoTiempo;
import modelo.GestorDeFacturacion;
import interfaces.I_Pago;
import personas.Persona;
import servicios.Domicilio;
import servicios.Factura;

/**
 * @author Grupo8
 * <br>
 *Clase que representa al modelo MVC, es la clase que recibe los datos y efectua las operaciones correspondientes
 */
@SuppressWarnings("serial")
public class SistemaContrataciones implements I_Sistema,Serializable {
	
	private static SistemaContrataciones  instancia= null; //APLICO EL PATRON SINGLETON PUES SE INSTANCIA POR UNICA VEZ
	private HashMap <String,Persona> listaAbonados=new HashMap<String,Persona>();
	private EmuladorPasoTiempo emPasoTiempo;
	private GestorDeFacturacion gestFact;
	private ArrayList<Factura> listaFacturasClonadas;

    /**
     * Constructor privado de SistemaContrataciones  pues aplicamos el patron Singleton
     */
	private SistemaContrataciones () {
		this.emPasoTiempo= new EmuladorPasoTiempo();
		this.gestFact= new GestorDeFacturacion();
		this.gestFact.agregarObservable(this.emPasoTiempo);
		
	}
	
	/**
	 * Metodo estatico para instanciar por unica vez SistemaContrataciones 
	 * @return devuelve la instancia de tipo SistemaContrataciones 
	 */
	public static SistemaContrataciones  getInstancia() { 
		if(instancia==null)
			instancia= new SistemaContrataciones();
		return instancia;
	}
	
	/**
	 * Agrega un abonado nuevo a la lista de abonados del sistema<br>
	 * <b>Pre: </b>La persona debe ser distinto de cadena vacia y debe existir<br>
	 * <b>Post: </b>Se agrega un abonado mas a la lista de abonados<br>
	 * @param persona: Parametro de tipo String que representa al abonado que pertence al sistema
	 * @throws PersonaExistenteException : Se lanza en el caso de que la persona ya exista
	 */
	public void agregarAbonado(Persona persona) throws PersonaExistenteException {
		if(!this.listaAbonados.containsKey(persona.getNombre()))
			this.listaAbonados.put(persona.getNombre(),persona);
		else
			throw new PersonaExistenteException("Persona ya existente");
	}
	/**
	 * Agrega un servicio nuevo a la lista de contrataciones de factura<br>
	 * <b>Pre: </b>La persona debe ser distinto de cadena vacia y debe existir;Las cantidades como cantCel,cantTel,cantTv deben ser mayor o igual que cero; El domicilio no debe ser repetido<br>
	 * <b>Post: </b>Se agrega un servicio mas a la lista de contrataciones<br>
	 * @param persona: Parametro de tipo String que representa al titular de la factura
	 * @param internet: Parametro de tipo String que representa al servicio de internet que desea contratar
	 * @param cantCel: Parametro de tipo int que representa a la cantidad de celulares que desea agregar
	 * @param cantTel: Parametro de tipo int que representa a la cantidad de telefonos que desea agregar
	 * @param cantTV: Parametro de tipo int que representa a la cantidad de cables TV que desea agregar
	 * @param domicilio: Parametro de tipo Domicilio que representa al domicilio del serivicio asociado
	 * @throws NoPuedeContratarException: Se lanza en el caso de que no se pueda contratar algun servicio 
	 * @throws ServicioInternetInvalidoException: Se lanza en el caso de que el servicio sea invalido
	 * @throws DomicilioInvalidoException: Se lanza en el caso de que el domicilio sea invalido
	 */
	public void agregarServicio(String persona,String internet, int cantCel, int cantTel, int cantTV, Domicilio domicilio) throws NoPuedeContratarException, ServicioInternetInvalidoException, DomicilioInvalidoException { 
			this.listaAbonados.get(persona).agregarContratacion(ContratableFactory.nuevoServicio(internet, cantCel, cantTel, cantTV, domicilio));
	}
	
	/**
	 * Realiza el cambio de agregado del servicio
	 * <b>Pre: </b> El parametro Direccion debe ser valido y que exista en la factura;El parametro Accion no debe ser una cadena vacia y debe existir; El parametro Servicio no debe ser una cadena vacia y debe existir<br>
	 * <b>Post: </b> Se realiza el cambio de agregado del servicio<br>
	 * @param direccion: Parametro de tipo String que representa a la direccion del servicio que desea cambiar
	 * @param accion: Parametro de tipo String que representa a la accion que quiera realizar
	 * @param servicio: Parametro de tipo String que representa al servicio que desea modificar
	 */
	public void modificarAgregado(String persona,String direccion,String accion,String servicio) { //PRECONDICON DIRECCION VALIDA Y QUE EXISTA EN LA FACTURA 
		int pos=this.listaAbonados.get(persona).buscaContratacion(direccion);
		this.listaAbonados.get(persona).modificaContratacion(pos, accion, servicio);
	}
			
	/**
	 * Se elimina una contratacion de una lista de contrataciones de una factura que pertenece a un abonado.<br>
	 * <b>Pre: </b> Los parametros nombrePersona y domicilio debe ser distinto de null<br>
	 * <b>Post: </b> Se elimino una contratacion ; si la lista de contrataciones queda vacia, se elimina la factura  <br>
	 * @param nombrePersona : Parametro de tipo String que representa el nombre de una persona.
	 * @param domicilio : Parametro de tipo String que representa el domicilio de una persona.
	 * @throws NoPuedeDarDeBajaException : Se lanza en el caso de que no se pueda dar de baja algun servicio
	 */
	public void eliminarContratacion(String nombrePersona,String domicilio) throws NoPuedeDarDeBajaException {
		if(this.listaAbonados.containsKey(nombrePersona)) { 
			this.listaAbonados.get(nombrePersona).eliminarContratacion(domicilio);
		}
	}
	public Iterator<Persona> getPersonas(){
		return this.listaAbonados.values().iterator();
	}
	/**
	 * Se clonan todas las facturas que tiene el Sistema.<br>
	 */
	@SuppressWarnings("rawtypes")
	public void duplicarFacturas() {
		this.listaFacturasClonadas=new ArrayList<Factura>();
		Factura actual;
		for(HashMap.Entry<String,Persona> pair: listaAbonados.entrySet()) {
			Iterator iterator=pair.getValue().getColeccionDeFacturas().getFacturaIterator();
			while(iterator.hasNext()) {
				actual=(Factura) iterator.next();
				listaFacturasClonadas.add((Factura) actual.clone());
			}
		}
	}
	
	
	/**
	 * @return Devuelve String de toda la informacion detallada de los abonados y sus facturas
	 */
	public String listarAbonados() {
		StringBuilder sb= new StringBuilder();
		for(HashMap.Entry<String,Persona> pair: listaAbonados.entrySet()) {
			sb.append(pair.getValue().listarFacturas());
		}
		return sb.toString();
	}

	/**
	 * Se realiza el pago de la factura determinada.<br>
	 * @throws NoPuedePagarException: Se lanza en el caso de que no se pueda pagar alguna factura
	 * 
	 */
	public void pagarFactura(String nombrePersona, I_Pago tipo,int mes) throws NoPuedePagarException {
		this.listaAbonados.get(nombrePersona).pagar(tipo, mes);
		
	}

	public EmuladorPasoTiempo getEmPasoTiempo() {
		return emPasoTiempo;
	}

	public void setEmPasoTiempo(EmuladorPasoTiempo emPasoTiempo) {
		this.emPasoTiempo = emPasoTiempo;
	}

	public HashMap<String, Persona> getListaAbonados() {
		return listaAbonados;
	}

	public void setListaAbonados(HashMap<String, Persona> listaAbonados) {
		this.listaAbonados = listaAbonados;
	}

	public GestorDeFacturacion getGestFact() {
		return gestFact;
	}

	public void setGestFact(GestorDeFacturacion gestFact) {
		this.gestFact = gestFact;
	}

	public ArrayList<Factura> getListaFacturasClonadas() {
		return listaFacturasClonadas;
	}

	public void setListaFacturasClonadas(ArrayList<Factura> listaFacturasClonadas) {
		this.listaFacturasClonadas = listaFacturasClonadas;
	}

}
