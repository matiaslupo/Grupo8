package personas;



import interfaces.I_Contratable;
import interfaces.I_Pago;
import servicios.Factura;

/**
 * @author Grupo8
 *<br>
 *Clase que representa a una Persona Juridica
 */
@SuppressWarnings("serial")
public class Juridica extends Persona {
	private int CUIT;
	/**
	 * Constructor con dos parametros para setear el nombre y el CUIT de la persona juridica
	 * <br>
	 * @param nombre : parametro de tipo String que representa el nombre de la persona juridica
	 * @param CUIT : parametro de tipo int que representa el CUIT de la persona juridica 
	 */
	public Juridica(String nombre, int CUIT) {
		super(nombre);
		this.CUIT=CUIT;
	}
	public Juridica() {}
	public int getCUIT() {
		return CUIT;
	}
	/**
	 * Setea el CUIT de la persona juridica
	 * @param cUIT: parametro de tipo int, debe ser positivo
	 */
	public void setCUIT(int cUIT) {
		CUIT = cUIT;
	}
	/**
	 *Metodo para la clonacion de persona juridica,en este caso, como no ser� clonable siempre lanza una excepci�n
	 */
	@Override
    public Object clone() throws CloneNotSupportedException { 
        throw new CloneNotSupportedException();
    }
	/**
	 *Realiza el calculo del total a abonar la persona juridica aplicando el tipo de pago correspondiente(DOUBLE DISPATCH)<br>
	 *<b>Pre: </b> tipo debe ser distinto de null y el total debe ser positivo <br>
	 * <b>Post: </b> sera calculado el total aplicando el tipo de pago
	 * @param tipo: medio de pago para aplicar el porcentaje correspondiente
	 * @param total: total de la factura a pagar para calcular su precio final aplicando el porcentaje
	 * @return devuelve el valor del total calculado con el porcentaje aplicado
	 */
	@Override
	public double aplicarPorcentaje(I_Pago tipo, double total) {
		return total*tipo.porcentajeJuridica();
	}
	/**
	 *@return devuelve la informacion detallada de la persona juridica
	 */
	@Override
	public String toString() {
		return "ABONADO de tipo persona Juridica-->Nombre= " + this.getNombre() + " CUIT=" + CUIT;
	}
	/**
	 * Metodo para contratar un servicio.<br>	 
	 * @param contratacion: Parametro de tipo I_Contratable que representa la contratacion a agregar, debe ser distinto de null<br>
	 */
	@Override
	public void agregarContratacion(I_Contratable iContratable) {
		this.getListaContrataciones().add(iContratable);
	}
	/**
	 * Metodo para dar de baja algun servicio<br>	 
	 * @param domicilio: Parametro de tipo String que representa al domicilio del abonado,debe ser distinto de null<br>
	 */
	@Override
	public void eliminarContratacion(String domicilio) {
		this.getListaContrataciones().remove(this.buscaContratacion(domicilio));
		
	}
	/**
	 * Metodo para pagar una factura.<br>	
	 *@param tipo: Parametro de tipo I_Pago que representa al tipo de pago que corresponda, debe ser distinto de null<br>
	 *@param mes: Parametro de tipo int para ubicarse en la factura correspondiente, debe ser mayor a 0 y menor que 13<br> 
	 */
	@Override
	public void pagar(I_Pago tipo, int mes) {
		Factura factura=(Factura) this.getColeccionDeFacturas().buscarFactura(mes);
		factura.pagar();
		factura.setTotalConP(this.aplicarPorcentaje(tipo,factura.getTotalConP()));
		
	}
	
}
