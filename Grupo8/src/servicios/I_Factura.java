package servicios;

import interfaces.I_Contratable;

public interface I_Factura extends Cloneable{
	
	boolean isPagado();
	
	void pagar();
	
	public void nuevaContratacion(I_Contratable iContratable);
	
	public int buscaContratacion(String domicilioPersona);
	
	public String listarContrataciones();
	
	Object clone() throws CloneNotSupportedException;
}
