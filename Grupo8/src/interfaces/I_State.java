package interfaces;

import personas.Fisica;
import servicios.Domicilio;

public interface I_State {
	
    public void pagarFactura(I_Pago tipo);
    
	public void contratarNuevoServicio(I_Contratable contratacion);
	
	public void darDeBajaServicio(String domicilio);

}
