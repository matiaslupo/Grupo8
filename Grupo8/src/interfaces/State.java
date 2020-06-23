package interfaces;

import personas.Fisica;

public interface State {
	
    public void pagarFactura(Fisica abonado);
    
	public void contratarNuevoServicio(Fisica abonado);
	
	public void darDeBajaServicio(Fisica abonado);

}
