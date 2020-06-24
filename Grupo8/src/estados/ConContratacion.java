package estados;

import interfaces.I_Contratable;
import interfaces.I_Pago;
import interfaces.I_State;
import personas.Fisica;

public class ConContratacion implements I_State {

	private Fisica abonado;
	
	public ConContratacion(Fisica abonado) {
		
		this.abonado = abonado;
	}

	public void pagarFactura(I_Pago tipo) {
		if(abonado.getContadorFvencidas()>=2) 
			abonado.setEstado(new Moroso(abonado));
		else {
			abonado.precioFinal(tipo);
			//falta setear el estado de pagado de la factura
		}
		
	}

	public void contratarNuevoServicio(I_Contratable contratacion) {
		abonado.nuevaContratacion(contratacion);
	}

	public void darDeBajaServicio(String domicilio) {
		abonado.eliminaContratacion(abonado.buscaContratacion(domicilio));
	}


}
