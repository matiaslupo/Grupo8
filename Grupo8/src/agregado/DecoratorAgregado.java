package agregado;

import java.io.Serializable;

import interfaces.I_Contratable;
import servicios.Domicilio;

/**
 * @author Grupo8
 * <br>
 * Clase para aniadir nuevos agregados al Servicio, utilizando el patron Decorator
 */
public abstract class DecoratorAgregado implements I_Contratable,Serializable{
	
	private I_Contratable contratable;
	private int cantLineas;

	/**
	 * Constructor general para un nuevo Agregado
	 * @param cantLineas: parametro de tipo int que representa la cantidad de lineas del nuevo agregado
	 * @param contratable: parametro de tipo I_Contratable que representa el servicio al que se le aniade el Agregado
	 */
	public DecoratorAgregado(int cantLineas, I_Contratable contratable) {
		this.cantLineas = cantLineas;
		this.contratable= contratable;
	}

	/**
	 * @return Devuelve la cantidad de lineas contratadas de este Agregado
	 */
	public int getCantLineas() {
		return cantLineas;
	}

	/**
	 * Modifica la cantidad de lineas para este agregado
	 * @param cantLineas: Nuevo numero de lineas de este agregado, tiene que ser un numero positivo
	 */
	public void setCantLineas(int cantLineas) {
		this.cantLineas = cantLineas;
	}

	/**
	 * @return Devuelve el Servicio de Internet, o en caso de haber mas de un agregado devuelve el siguiente Agregado
	 */
	public I_Contratable getContratable() {
		return contratable;
	}

	public double getPrecio() {
		return 0;
	}

	public int getID() {
		return 0;
	}

	public Domicilio getDomicilio() {
		return null;
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
		return false;
	}

	
	/**
	 * @return Devuelve un clon del Agregado. Estos siempre son clonables
	 */
	@Override
	public Object clone()  {
		DecoratorAgregado agregadoClonado=null;
		try {
			agregadoClonado=(DecoratorAgregado) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agregadoClonado;
	}
}
