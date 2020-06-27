package vistaMVC;

import controladorMVC.Controlador;

/**
 * @author Grupo8
 * <br>
 * Clase que representa a la prueba de ventana, que es donde se inicia la aplicacion
 */
public class PruebaVentana {
	
	public static String texto() {
		String text="";
		String esp="                 \n";
		for (int i='A' ;i<='Z';i++) {
			char val= (char) i;
			text= text+ val+ esp  ;
		}
		return text;
	}

	//public static void main(String[] args) {
	//	ventanaAFIP vista= new ventanaAFIP();
	//}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Controlador c= new Controlador();
	}

}
