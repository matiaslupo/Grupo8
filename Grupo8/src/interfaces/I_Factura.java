
package interfaces;
/**
 *@author Grupo8
 *<br>
 *Interfaz para la factura
 */
public interface I_Factura extends Cloneable  {
	
	void setTotalSinP(double totalSinP);
	
	double getTotalSinP();
	
	void setTotalConP(double totalConP);
	
	double getTotalConP();
	
	boolean isPagado();
	
	void setPagado(boolean valor);
	
	void pagar();
	
	void setDetalles(String detalles);
	
	String getDetalles();
	
	Object clone() throws CloneNotSupportedException;
}
