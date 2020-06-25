package estados;

import java.util.Observable;

import interfaces.I_Contratable;
import interfaces.I_Pago;

import interfaces.I_State;
import personas.Fisica;
import servicios.I_Factura;

public class ConContratacion implements I_State  {

	private Fisica abonado;
	
	public ConContratacion(Fisica abonado) {
		this.abonado = abonado;
	}

	public void pagarFactura(I_Pago tipo,int mes) {
		I_Factura factura=abonado.getColeccionDeFacturas().buscarFactura(mes);
		factura.setPagado(true);
		factura.setTotalConP(factura.getTotalConP()*abonado.aplicarPorcentaje(tipo, factura.getTotalConP()));
	}

	public void contratarNuevoServicio(I_Contratable contratacion) {
		abonado.nuevaContratacion(contratacion);
	}

	public void darDeBajaServicio(String domicilio) {
		abonado.eliminaContratacion(abonado.buscaContratacion(domicilio));
		if(abonado.getListaContrataciones().size()==0) //no hay mas contrataciones, paso al estado Sin contratacion
			abonado.setEstado(new SinContratacion(abonado));
	}


}
