package servicios;

import interfaces.I_Contratable;

public interface I_Factura {

	void agregarServicio (I_Contratable contratable);
	
	
	
	Object clone() throws CloneNotSupportedException;
}
