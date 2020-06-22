package vistaMVC;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	// LABEL CON LA FECHA ACTUAL
	private JLabel fechaLabel;
	// BOTONES
	private JButton agregarSocioBoton;
	private JButton quitarSocioBoton;
	private JButton buscarSocioBoton;
	private JButton agregarServicioBoton; 
	private JButton quitarServicioBoton;
	private JButton pagarBoton;
	private JButton eptBoton;
	private JButton afipBoton;
	// CONTROLADOR
	private ActionListener actionlistener;
	
	
	public ventanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(9, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		JLabel fechaLabel = new JLabel("");
		panel_8.add(fechaLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton agregarSocioBoton = new JButton("Agregar Socio");
		panel.add(agregarSocioBoton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton quitarSocioBoton = new JButton("Quitar Socio");
		panel_1.add(quitarSocioBoton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton buscarSocioBoton = new JButton("Buscar Socio");
		panel_2.add(buscarSocioBoton);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton agregarServicioBoton = new JButton("Agregar Servicio");
		panel_3.add(agregarServicioBoton);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton quitarServicioBoton = new JButton("Quitar Servicio");
		panel_4.add(quitarServicioBoton);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton pagarBoton = new JButton("Pagar");
		panel_5.add(pagarBoton);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JButton eptBoton = new JButton("EPT");
		panel_6.add(eptBoton);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton afipBoton = new JButton("Afip");
		panel_7.add(afipBoton);
	}

}
