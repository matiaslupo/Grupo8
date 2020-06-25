package estados;

import java.util.Observable;

import excepciones.NoPuedeContratarException;
import excepciones.NoPuedeDarDeBajaException;
import interfaces.I_Contratable;
import interfaces.I_Pago;
import interfaces.I_State;
import personas.Fisica;
import servicios.I_Factura;

public class Moroso implements I_State {

	private Fisica abonado;
	
	public Moroso(Fisica abonado) {
		this.abonado = abonado;
	}

	public void pagarFactura(I_Pago tipo,int mes) { //SE SUPONE QUE ES FALSE PAGADO
		I_Factura factura=abonado.getColeccionDeFacturas().buscarFactura(mes);
		factura.setPagado(true);
		factura.setTotalConP(factura.getTotalConP()*abonado.aplicarPorcentaje(tipo, factura.getTotalConP()));
		factura.setTotalConP(factura.getTotalConP()*1.3); //le aplico el recargo
		factura.setTotalSinP(factura.getTotalSinP()*1.3);
		if(abonado.getColeccionDeFacturas().facturasSinPagar()<2) { //si tiene menos de dos facturas sin pagar, voy al otro estado
			abonado.setEstado(new ConContratacion(abonado));
		}
	}

	public void contratarNuevoServicio(I_Contratable contratacion) throws NoPuedeContratarException { 
		throw new NoPuedeContratarException(abonado,"Tiene deudas,no puede contratar algun servicio!");
	}

	public void darDeBajaServicio(String domicilio) throws NoPuedeDarDeBajaException {
		throw new NoPuedeDarDeBajaException(abonado,"Tiene deudas,no puede dar de baja algun servicio!");
	}

}
