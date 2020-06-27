package vistaMVC;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	private JButton salirBoton;
	private TextArea reporteTextArea;
	private ActionListener actionlistener;

	public ventanaAFIP() {
		setTitle("AFIP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		reporteTextArea = new TextArea();
		contentPane.add(reporteTextArea, BorderLayout.CENTER);
		
		this.setVisible(false);
	}
	
	public void seteaText(String texto) {
		this.reporteTextArea.setText(texto);
	}
	
	public void setActionListener(ActionListener actionlistener) {
		this.actionlistener=actionlistener;
	}

}
