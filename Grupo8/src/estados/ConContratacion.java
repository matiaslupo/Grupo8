package estados;

import interfaces.I_State;
import personas.Fisica;

public class ConContratacion implements I_State {

	private Fisica abonado;
	
	public ConContratacion(Fisica abonado) {
		
		this.abonado = abonado;
	}

	public void pagarFactura() {
		if(abonado.getContadorFvencidas()>=2) 
			abonado.setEstado(new Moroso(abonado));
		else {
			//pagar normal
		}
		
	}

	public void contratarNuevoServicio() {
		//contratar normal
		
	}

	public void darDeBajaServicio() {
		//dar de baja normal
		
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
