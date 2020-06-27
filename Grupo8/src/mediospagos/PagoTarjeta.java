package mediospagos;

import java.io.Serializable;

import interfaces.I_Pago;

/**
 * @author Grupo8
 *<br>
 *Clase para el tipo de pago tarjeta
 */
@SuppressWarnings("serial")
public class PagoTarjeta implements I_Pago,Serializable {
	/**
	 * Metodo que devuelve un porcentaje correspondiente por el pago usando la tarjeta siendo una persona fisica
	 *@return devuelve un valor de tipo double 
	 */
	public double porcentajeFisica() { //Abona con tarjeta, el valor no se altera
		return 1;
	}
	/**
	 * Metodo que devuelve un porcentaje correspondiente por el pago usando la tarjeta siendo una persona juridica
	 *@return devuelve un valor de tipo double 
	 */
	public double porcentajeJuridica() { //Abona con tarjeta, recibe un incremento de 20%
		return 1.20;
	}
}
