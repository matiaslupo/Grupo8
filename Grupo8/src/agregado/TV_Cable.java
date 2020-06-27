package agregado;

import interfaces.I_Contratable;
import servicios.Domicilio;

/**
 * @author Grupo8
 * <br>
 * Clase para un Agregado de tipo TV_Cable
 */
@SuppressWarnings("serial")
public class TV_Cable extends DecoratorAgregado {

	/**
	 * Constructor para un Agregado de tipo TV_cable<br>
	 * @param cantLineas: Cantidad de lineas contratadas para este Agregado
	 * @param contratable: Servicio o Agregado adjunto
	 */
	public TV_Cable(int cantLineas, I_Contratable contratable) {
		super(cantLineas, contratable);
	}

	/**
	 * @return Devuelve el precio total del Servicio mas sus Adjuntos
	 */
	public double getPrecio() {
		return this.getContratable().getPrecio() + this.getCantLineas() * 250;
	}
	
	/**
	 * @return Devuelve la ID unica del Servicio
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
	 * @return Devuelve un String con los detalles del Servicio
	 */
	@Override
	public String toString() {
		return this.getContratable().toString() + " + CELULAR: $250 x " +this.getCantLineas();
	}

	public boolean isInternet100() {
		return false;
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
		return true;
	}
	
	@Override
	public Object clone() {
		TV_Cable tvcableClonado;
		tvcableClonado=(TV_Cable) super.clone();
		return tvcableClonado;
	}
	
}
