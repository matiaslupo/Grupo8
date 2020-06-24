package estados;

import javax.swing.JOptionPane;

import interfaces.I_Contratable;
import interfaces.I_Pago;
import interfaces.I_State;
import personas.Fisica;

public class Moroso implements I_State {

	private Fisica abonado;
	private double recargo=1.3;

	
	public Moroso(Fisica abonado) {
		this.abonado = abonado;
	}

	public void pagarFactura(I_Pago tipo) {
		abonado.precioFinal(tipo);
		abonado.setTotalConP(abonado.getTotalConP()*1.3);
		abonado.setTotalSinP(abonado.getTotalSinP()*1.3);
		
	}

	public void contratarNuevoServicio(I_Contratable contratacion) {

		JOptionPane.showMessageDialog(null, "Tiene deudas,no puede contratar algun servicio!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		
	}

	public void darDeBajaServicio(String domicilio) {

		JOptionPane.showMessageDialog(null, "Tiene deudas,no puede dar de baja algun servicio!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		
	}

}
