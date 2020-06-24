package estados;

import javax.swing.JOptionPane;

import interfaces.I_State;
import personas.Fisica;

public class SinContratacion implements I_State {

	private Fisica abonado;
	
	public SinContratacion(Fisica abonado) {
		this.abonado = abonado;
	}

	public void pagarFactura() {
		JOptionPane.showMessageDialog(null, "No puede pagar aun", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		
	}

	public void contratarNuevoServicio() {
		//contratacion normal, luego de eso, se pasa al otro estado
		abonado.setEstado(new ConContratacion(abonado));
	}

	public void darDeBajaServicio() {
		JOptionPane.showMessageDialog(null, "No puede dar de baja algun servicio aun", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
		
	}
	

}
