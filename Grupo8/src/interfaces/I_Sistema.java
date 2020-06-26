package interfaces;

import excepciones.DomicilioInvalidoException;
import excepciones.NoPuedeContratarException;
import excepciones.NoPuedeDarDeBajaException;
import excepciones.NoPuedePagarException;
import excepciones.PersonaExistenteException;
import excepciones.ServicioInternetInvalidoException;
import interfaces.I_Pago;
import personas.Persona;
import servicios.Domicilio;

/**
 * @author Grupo8
 * <br>
 * Interfaz para el sistema
 */
public interface I_Sistema {
	/**
	 * Metodo para agregar abonado.<br>	
	 * @throws PersonaExistenteException: Se lanza en el caso de que se encuentre una persona existente
	 */
	public void agregarAbonado(Persona persona) throws PersonaExistenteException;
	/**
	 * Metodo para agregar servicio.<br>	
	 * @throws NoPuedeContratarException: se lanza cuando no se puede contratar algun servicio
	 * @throws DomicilioInvalidoException: se lanza cuando se ingresa un domicilio invalido
	 * @throws ServicioInternetInvalidoException: se lanza cuando se ingresa algun servicio invalido
	 */
	public void agregarServicio(String persona,String internet, int cantCel, int cantTel, int cantTV, Domicilio domicilio) throws NoPuedeContratarException, ServicioInternetInvalidoException, DomicilioInvalidoException;
	/**
	 * Metodo para modificar agregado.<br>	
	 */
	public void modificarAgregado(String persona,String direccion,String accion,String servicio);
	/**
	 * Metodo para abonar.<br>	
	 * @throws NoPuedePagarException: se lanza cuando no se puede pagar alguna factura
	 */
	public void pagarFactura(String nombrePersona,I_Pago tipo,int mes) throws NoPuedePagarException;
	/**
	 * Metodo para duplicar facturas.<br>	
	 */
	public void duplicarFacturas();
	/**
	 * Metodo para eliminar contratacion.<br>	
	 * @throws NoPuedeDarDeBajaException: se lanza cuando no se puede dar de baja algun servicio
	 */
	public void eliminarContratacion(String nombrePersona,String domicilio) throws NoPuedeDarDeBajaException;
	/**
	 * Metodo para listar abonados.<br>	
	 */
	public String listarAbonados();
	/**
	 * Metodo para listar clonadas.<br>	
	 */
	public String listarClonadas();


}