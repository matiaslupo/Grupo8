package vistaMVC;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
/**
 * @author Grupo8
 * <br>
 * Clase que representa a la ventana de AFIP,que cuando se ejecuta solicita un reporte de todas las facturas
 */
@SuppressWarnings("serial")
public class ventanaAFIP extends JFrame {

	private JPanel contentPane;
	private JTextArea reporteTextArea ;

	public ventanaAFIP() {
		setTitle("AFIP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		reporteTextArea = new JTextArea();
		reporteTextArea.setTabSize(10);
		contentPane.add(reporteTextArea, BorderLayout.CENTER);
	}
	
	private void seteaText(String texto) {
		this.reporteTextArea.setText(texto);
	}

}
