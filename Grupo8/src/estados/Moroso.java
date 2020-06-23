package estados;

import javax.swing.JOptionPane;

import interfaces.I_State;
import personas.Fisica;

public class Moroso implements I_State {

	private Fisica abonado;
	
	
	public Moroso(Fisica abonado) {
		this.abonado = abonado;
	}

	public void pagarFactura() {
		Fisica.recargo=1.3;
		//pagar normal
		
	}

	public void contratarNuevoServicio() {
		JOptionPane.showMessageDialog(null, "Tiene deudas,no puede contratar algun servicio!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		
	}

	public void darDeBajaServicio() {
		JOptionPane.showMessageDialog(null, "Tiene deudas,no puede dar de baja algun servicio!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		
	}

	public void pagarFactura(Fisica abonado) {
		// TODO Auto-generated method stub
		
	}

	public void contratarNuevoServicio(Fisica abonado) {
		// TODO Auto-generated method stub
		
	}

	public void darDeBajaServicio(Fisica abonado) {
		// TODO Auto-generated method stub
		
	}


}
