package agregado;

import interfaces.I_Contratable;
import servicios.Domicilio;

/**
 *@author Grupo8
 * <br>
 * Clase para un Agregado tipo Celular
 */
public class Celular extends DecoratorAgregado {

	/**
	 * Constructor para un Agregado tipo Celular<br>
	 * @param cantLineas: Cantidad de lineas contratadas
	 * @param contratable: Servicio o Agregado adjunto
	 */
	public Celular(int cantLineas, I_Contratable contratable) {
		super(cantLineas, contratable);
	}

	/**
	 * @return Devuelve el precio total del Servicio mas sus Agregados
	 */
	public double getPrecio() {
		return this.getContratable().getPrecio() + this.getCantLineas() * 300;
	}

	/**
	 * @return Devuelve la ID unica del serivico
	 */
	public int getID() {
		return this.getContratable().getID();
	}

	/**
	 * @return Devuelve el domicilio adjunto al Servicio
	 */
	public Domicilio getDomicilio() {
		return this.getContratable().getDomicilio();
	}

	/**
	 *@return Devuelve un String con los detalles del Servicio
	 */
	@Override
	public String toString() {
		return this.getContratable().toString() + " + CELULAR: $300 x " +this.getCantLineas();
	}

	public boolean isInternet100() {
		return false;
	}

	public boolean isInternet500() {
		return false;
	}

	public boolean isCelular() {
		return true;
	}

	public boolean isTelefono() {
		return false;
	}

	public boolean isTV_Cable() {
		return false;
	}

	@Override
	public Object clone() {
		Celular celularClonado;
		celularClonado=(Celular) super.clone();
		return celularClonado;
	}
	

}
