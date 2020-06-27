package personas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import agregado.Celular;
import agregado.DecoratorAgregado;
import agregado.TV_Cable;
import agregado.Telefono;
import excepciones.NoPuedeContratarException;
import excepciones.NoPuedeDarDeBajaException;
import excepciones.NoPuedePagarException;
import interfaces.I_ColeccionDeFacturas;
import interfaces.I_Contratable;
import interfaces.I_Pago;
import servicios.Domicilio;
import servicios.Factura;
import servicios.Internet100;
import servicios.Internet500;
import servicios.ListaFacturas;
import servicios.Servicio;

/**
 * @author Grupo8
 * <br>
 * Clase abstracta que representa una Persona
 */
@SuppressWarnings("serial")
public abstract class Persona implements Cloneable,Serializable{
	
	private String nombre;
	protected ArrayList<I_Contratable> listaContrataciones;
	private I_ColeccionDeFacturas coleccionDeFacturas;
	/**
	 * Constructor con un parametro para setear el nombre de la persona e inicializar las colecciones
	 * <br>
	 * @param nombre: parametro de tipo String que representa el nombre de la persona 
	 */
	public Persona(String nombre) {
		this.nombre = nombre;
		this.coleccionDeFacturas= new ListaFacturas();
		this.listaContrataciones= new ArrayList<I_Contratable>();
	}
	public Persona() {}
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre Setea el nombre de la persona, debe ser distinto de null y no repetido
	 */
	public void setNombre(String nombre) { 
		this.nombre = nombre;
	}
	public ArrayList<I_Contratable> getListaContrataciones() {
		return listaContrataciones;
	}
	public void setListaContrataciones(ArrayList<I_Contratable> listaContrataciones) {
		this.listaContrataciones = listaContrataciones;
	}
	/**
	 *Metodo de clonacion condicional
	 *<br>
	 *La clase Persona conserva la propagacion de la excepcion, ya que no sabemos si las clases hijas seran o no cloneables
	 */
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	/**
	 *Realiza el calculo del total a abonar aplicando el tipo de pago correspondiente<br>
	 *<b>Pre: </b> tipo debe ser distinto de null y el total debe ser positivo <br>
	 * <b>Post: </b> sera calculado el total aplicando el tipo de pago
	 * @param tipo: medio de pago para aplicar el porcentaje correspondiente
	 * @param total: total de la factura a pagar para calcular su precio final aplicando el porcentaje
	 * @return devuelve el valor del total calculado con el porcentaje aplicado
	 */
	public abstract double aplicarPorcentaje(I_Pago tipo,double total); 
	/**
	 * Agrega una nueva linea de contratacion a la factura
	 * <b>Pre: </b> iContratable debe ser distinto de null <br>
	 * <b>Post: </b> Se agrega una contratacion mas a la lista<br>
	 * @param iContratable : Parametro que sera agregado a nuestra factura
	 * @throws NoPuedeContratarException : Se lanza en el caso de que no se pueda contratar algun servicio
	 */
	public abstract void agregarContratacion(I_Contratable iContratable) throws NoPuedeContratarException;
	/**
	 * Busca una linea contratacion de acuerdo al domicilio ingresado
	 * <b>Pre: </b> El parametro domicilio tiene que exisitr y distinto de null o cadena vacia <br>
	 * <b>Post: </b> Encuentra la posicion de la linea de contratacion<br>
	 * @param domicilioPersona: Parametro que se usa para buscar la linea de contratacion
	 * @return Devuelve el valor de tipo int la posicion de la linea de contratacion buscada
	 */
	public int buscaContratacion(String domicilioPersona) { 
		domicilioPersona= domicilioPersona.toUpperCase();
		int res=0;
		if (!this.listaContrataciones.isEmpty()) {
			int i=0;
			while(i<this.listaContrataciones.size() && !this.listaContrataciones.get(i).getDomicilio().getDireccion().equals(domicilioPersona) ) 
				i++;
			if (i<this.listaContrataciones.size())
				res=i;
		}
		return res;
	}
	
	/**
	 * Cambia o quitar algun servicio o agregado
	 * <b>Pre: </b> I_Contratable debe ser distinto de null <br>
	 * <b>Post: </b> Se agrega una contratacion mas a la lista<br>
	 * @param pos: Parametro de tipo int que representa el ID de la linea de contratacion
	 * @param accion: Parametro de tipo String que representa la accion tales como modificar o quitar
	 * @param servicio: Parametro de tipo String que representa el servicio a modificar o quitar algun agregado
	 */
	public void modificaContratacion(int pos,String accion,String servicio) { 
		int cantCelulares=0,cantFijo=0,cantTV=0;									
		accion=accion.toUpperCase();
		servicio=servicio.toUpperCase();
		I_Contratable contratable= this.listaContrataciones.get(pos);

		while(contratable.isCelular() || contratable.isTelefono() || contratable.isTV_Cable()) { 
			DecoratorAgregado decorador= (DecoratorAgregado) contratable;
			if (contratable.isCelular()) {
				cantCelulares= decorador.getCantLineas();
			}
			else if (contratable.isTelefono()) {
				cantFijo=decorador.getCantLineas(); 
			}
			else if (contratable.isTV_Cable()) {
				cantTV= decorador.getCantLineas();
			}
			contratable= decorador.getContratable();
		}	
		I_Contratable reemplazo= contratable;
		Servicio s= (Servicio) contratable;
		Domicilio domicilio= s.getDomicilio();
		
		if (accion.equals("CAMBIAR")) {
			if (servicio.equals("INTERNET100")) 
				reemplazo= new Internet100(domicilio,s.getID());
			 else if(servicio.equals("INTERNET500"))
				reemplazo= new Internet500(domicilio,s.getID());
		}
		else if (accion.equals("QUITAR")) {
			if (servicio.equals("TVCABLE"))
				 cantTV--;
			if (servicio.equals("CELULAR"))
				 cantCelulares--;
			if (servicio.equals("TELEFONO FIJO"))
				 cantFijo--;
		}
		else if (accion.equals("AGREGAR")) {
			if (servicio.equals("TVCABLE"))
				 cantTV++;
			if (servicio.equals("CELULAR"))
				 cantCelulares++;
			if (servicio.equals("TELEFONO FIJO"))
				 cantFijo++;
		}
		if (cantTV>0) { //ACTUALIZAR
			I_Contratable auxreemplazo= new TV_Cable(cantTV,reemplazo);
			reemplazo=auxreemplazo;
		}
		if (cantCelulares>0) {
			I_Contratable auxreemplazo= new Celular(cantCelulares,reemplazo);
			reemplazo=auxreemplazo;
		}
		if (cantFijo>0) {
			I_Contratable auxreemplazo= new Telefono(cantTV,reemplazo);
			reemplazo=auxreemplazo;
		}
		this.listaContrataciones.set(pos, reemplazo);
	}
	/**
	 * Elimina o da de baja un servicio 
	 * <b>Pre: </b> El parametro Domicilio debe ser distinto de null<br>
	 * <b>Post: </b> Se elimina una linea de contratacion de la factura<br>
	 * @param domicilio: Parametro de tipo String que representa al domicilio que pertenece a la linea de contratacion que desea eliminar.
	 * @throws NoPuedeDarDeBajaException : Se lanza en el caso de que no se pueda dar de baja algun servicio
	 */
	public abstract void eliminarContratacion(String domicilio) throws NoPuedeDarDeBajaException ;
	/**
	 * @return Devuelve toda la informacion detallada de la lista de contrataciones
	 */
	public String listarContrataciones(int mes) {
		StringBuilder sb= new StringBuilder();
		int i=0;
		int j=1;
		sb.append(this.toString()+"\n");
		sb.append("FACTURA DE MES Nº"+mes+"\n");
		sb.append("Lista de contrataciones: \n");
		while(i<this.listaContrataciones.size()) {
			sb.append("ID: " + j+" "+ this.listaContrataciones.get(i).toString()+"\n");
			i++;
			j++;
		}
		return sb.toString();	
	}
	public I_ColeccionDeFacturas getColeccionDeFacturas() {
		return coleccionDeFacturas;
	}
	public void setColeccionDeFacturas(I_ColeccionDeFacturas coleccionDeFacturas) {
		this.coleccionDeFacturas = coleccionDeFacturas;
	}
	/**
	 *Realiza el calculo del total sin tener en cuenta al descuento o recargo<br>
	 * @return devuelve el valor del total calculado
	 */
	public double precioOriginal() { //precio original, sin descuento, sin recargo
		double total=0;
		for(int i=0;i<this.listaContrataciones.size();i++)
			total+=this.listaContrataciones.get(i).getPrecio();
		return total;
	}
	/**
	 * Metodo para pagar una factura.<br>	
	 *@param tipo: Parametro de tipo I_Pago que representa al tipo de pago que corresponda, debe ser distinto de null<br>
	 *@param mes: Parametro de tipo int para ubicarse en la factura correspondiente, debe ser mayor a 0 y menor que 13<br> 
	 *@throws NoPuedePagarException:se lanza cuando no se puede pagar alguna factura
	 */
	public abstract void pagar(I_Pago tipo,int mes) throws NoPuedePagarException;
	
	/**
	 * @return devuelve toda la informacion detallada de las facturas
	 */
	@SuppressWarnings("rawtypes")
	public String listarFacturas() {
		StringBuilder sb= new StringBuilder();
		Factura actualF;
		Iterator iteratorFactura=this.getColeccionDeFacturas().getFacturaIterator();
		while(iteratorFactura.hasNext()) {
			actualF=(Factura) iteratorFactura.next();
			sb.append(actualF.getDetalles());
			if(actualF.isPagado()==true) {
				sb.append("PAGADA\n");
				sb.append("PRECIO ORIGINAL: $"+ actualF.getTotalSinP()+"\n");
				sb.append("PRECIO PAGADO APLICANDO DESCUENTO/RECARGO: $" + actualF.getTotalConP()+"\n");
			}
			else {
				sb.append("NO PAGADA\n");
				sb.append("PRECIO ORIGINAL: $"+ actualF.getTotalSinP()+"\n");
			}
			sb.append("---------------------------------------------------------------------------\n");
	    }
		return sb.toString();
	}
	
}
