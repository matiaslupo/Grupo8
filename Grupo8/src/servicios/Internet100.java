package servicios;

import java.io.Serializable;

/**
 * Clase para el tipo de servicio Internet100
 */
@SuppressWarnings("serial")
public class Internet100 extends Servicio implements Serializable{

	/**
	 * Constuctor para un Servicio de tipo Internet100 <br>
	 * <b>Pre: </b>El parametro Domicilio debe ser distinto de null.<br>
	 * <b>Post: </b>Crea un nuevo objeto Servicio.<br>
	 * @param domicilio: Objeto tipo Domicilio al que estara asociado este Servicio.
	 */
	public Internet100(Domicilio domicilio) {
		super(domicilio);
	}
	
	public Internet100(Domicilio domicilio,int id) {
		super(domicilio,id);
	}

	/**
	 * @return Devuelve el precio del Servicio Internet100
	 */
	public double getPrecio() {
		return 850;
	}

	/**
	 *@return Devuelve un String con los detalles del Servicio
	 */
	@Override
	public String toString() {
		return this.getDomicilio().toString() + " SERVICIO== INTERNET100: $850 ";
	}

	public boolean isInternet100() {
		return true;
	}

	public boolean isInternet500() {
		return false;
	}

	public boolean isCelular() {
		return false;
	}

	public boolean isTelefono() {
		return false;
	}

	public boolean isTV_Cable() {
		return false;
	}
	
	
}
