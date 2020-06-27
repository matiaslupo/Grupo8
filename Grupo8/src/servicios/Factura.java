package servicios;

import java.io.Serializable;

import interfaces.I_Factura;

/**
 * @author Grupo8
 * <br>
 *Clase que representa una Factura
 */
@SuppressWarnings("serial")
public class Factura implements Cloneable, I_Factura,Serializable {

    private double totalSinP; //porcentaje ya que, dependiendo del tipo de pago se hace un incremento o descuento
    private double totalConP;
    private boolean pagado;
    private String detalles; //detalles de las contrataciones
    
	/**
	 * Constructor Factura para setear el total con porcentaje,el total sin porcentaje y el pagado
	 * <br>
	 */
	public Factura() {
		this.totalConP=0;
		this.totalSinP=0;
		this.pagado= false;
	}
	

	public void setDetalles(String detalles) {
		this.detalles= detalles;
		
	}
	public String getDetalles() {
		return this.detalles;
	}
	
	public double getTotalSinP() {
		return totalSinP;
	}
	public double getTotalConP() {
		return totalConP;
	}

	public void setTotalSinP(double totalSinP) {
		this.totalSinP = totalSinP;
	}
	public void setTotalConP(double totalConP) {
		this.totalConP = totalConP;
	}
	public boolean isPagado() {
		return pagado;
	}
	
	public void setPagado(boolean valor) {
		this.pagado = valor;
	}
	/**
	 * Cuando se procede a pagar la factura, su estado de Pagado pasa a ser TRUE
	 */
	public void pagar() {
		this.pagado= true;
	}	
	
	/**
	 * @return devuelve toda la informacion detallada de la factura clonada.<br>
	 */
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(this.getDetalles());
			if(this.isPagado()==true) {
				sb.append("PAGADA\n");
				sb.append("PRECIO ORIGINAL: $"+ this.getTotalSinP()+"\n");
				sb.append("PRECIO PAGADO APLICANDO DESCUENTO/RECARGO: $" + this.getTotalConP()+"\n");
			}
			else {
				sb.append("NO PAGADA\n");
				sb.append("PRECIO ORIGINAL: $"+ this.getTotalSinP()+"\n");
			}
			sb.append("---------------------------------------------------------------------------\n");
		return sb.toString();
	}
	
	/**
	 * Metodo de clonacion de factura
	 *@return Devuelve un clon de factura
	 *@throws CloneNotSupportedException : se lanza cuando no es posible clonar la factura
	 */
	@Override
    public Object clone() 
    {
        Factura facturaClonada=null;
        try {
			facturaClonada=(Factura) super.clone();
		} catch (CloneNotSupportedException e) {
			// Facturas ahora son siempre clonables
		}
        return facturaClonada;
                
    }	
}
