package mediospagos;

import java.io.Serializable;

import interfaces.I_Pago;

/**
 * @author Grupo8
 * <br>
 * Clase para el tipo de pago Cheque
 */
@SuppressWarnings("serial")
public class PagoCheque implements I_Pago,Serializable {
	
	/**
	 * Metodo que devuelve un porcentaje correspondiente por el pago usando el cheque siendo una persona fisica
	 *@return devuelve un valor de tipo double 
	 */
	public double porcentajeFisica() { //Abona con cheque, recibe un incremento de 10%
		return 1.10;
	}

	/**
	 *Metodo que devuelve un porcentaje correspondiente por el pago usando el cheque siendo una persona juridica
	 *@return devuelve un valor de tipo double
	 */
	public double porcentajeJuridica() { //Abona con cheque, recibe un incremento de 15%
		return 1.15;
	}
}
