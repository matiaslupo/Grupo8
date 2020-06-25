package estados;


import excepciones.NoPuedeDarDeBajaException;
import excepciones.NoPuedePagarException;
import interfaces.I_Contratable;
import interfaces.I_Pago;
import interfaces.I_State;
import personas.Fisica;

public class SinContratacion implements I_State {

	private Fisica abonado;
	
	public SinContratacion(Fisica abonado) {
		this.abonado = abonado;
	}
	public void pagarFactura(I_Pago tipo, int mes) throws NoPuedePagarException  {
		throw new NoPuedePagarException(abonado, "El abonado no tiene contrataciones que pagar");		
	}

	public void contratarNuevoServicio(I_Contratable contratacion) {
		abonado.nuevaContratacion(contratacion);
		abonado.setEstado(new ConContratacion(abonado));
	}
	public void darDeBajaServicio(String domicilio) throws NoPuedeDarDeBajaException {
		throw new NoPuedeDarDeBajaException(abonado,"No puede dar de baja algun servicio aun");
	}


}
