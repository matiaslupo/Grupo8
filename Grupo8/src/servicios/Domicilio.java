package servicios;

import java.io.Serializable;

/**
 * @author Grupo8
 * <br>
 * Clase que representa Domicilio
 */
@SuppressWarnings("serial")
public abstract class Domicilio implements Serializable {
	
	private String calle;
	private int altura;
	/**
	 * Constructor para setear la calle y la altura del Domicilio
	 * @param calle: Parametro de tipo String que representa la calle del Domicilio
	 * @param altura: Parametro de tipo int que representa la altura del Domicilio
	 */
	public Domicilio(String calle, int altura) {
		this.calle = calle;
		this.altura = altura;
	}
	
	public String getCalle() {
		return calle;
	}
	
	/**
	 * Setea la calle del Domicilio, no debe ser una cadena vacia
	 * @param calle: Parametro de tipo String que representa la calle del Domicilio
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getAltura() {
		return altura;
	}
	
	/**
	 * Setea la altura del Domicilio, debe ser un número positivo
	 * @param altura: Parametro de tipo int que representa la altura del Domicilio
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	/**
	 * @return devuelve un String de calle y altura, es para buscar el id para modificar algun servicio
	 */
	public String getDireccion() {  
		String dir=(this.calle + " " +this.altura);
		return dir.toUpperCase();
	}
	
	/**
	 *@return devuelve un String de toda la informacion de domicilio
	 */
	@Override
	public String toString() {
		return "Domicilio: "+this.calle + " " +this.altura;
	}
	/**
	 * @return devuelve un clon del Domicilio. Estos siempre son clonables
	 */
	@Override
	protected Object clone() {		
		Object domClonado= null;
		try {
			domClonado= super.clone();
		} catch (CloneNotSupportedException e) {
			// Nunca entra en este bloque porque Domicilio siempre es clonable
			e.printStackTrace();
		}
		return domClonado;
	}
	
	
	
}
