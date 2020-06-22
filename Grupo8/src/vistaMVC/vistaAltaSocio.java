package vistaMVC;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;

public class vistaAltaSocio extends JFrame {

	private JPanel contentPane;
	private JTextField nombreTextField;
	private final ButtonGroup seleccionRadioButton = new ButtonGroup();
	private JTextField dniTextField;
	private JTextField cuitTextField;
	private JRadioButton juridicaRadioButton;
	private JRadioButton fisicaRadioButton ;
	private  JLabel nombreLabel;
	private  JLabel seleccionLabel;
	private JLabel dniLabel;
	private  JLabel cuitLabel;
	private  JButton aceptarBoton;
	private ActionListener actionlistener;
	
	
	public vistaAltaSocio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		nombreLabel = new JLabel("Ingrese Nombre:");
		panel_4.add(nombreLabel);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		nombreTextField = new JTextField();
		panel_5.add(nombreTextField);
		nombreTextField.setColumns(10);
		
		seleccionLabel = new JLabel("Seleccione un tipo de persona:");
		contentPane.add(seleccionLabel);
		
		fisicaRadioButton = new JRadioButton("Fisica");
		seleccionRadioButton.add(fisicaRadioButton);
		contentPane.add(fisicaRadioButton);
		
		juridicaRadioButton = new JRadioButton("Juridica");
		seleccionRadioButton.add(juridicaRadioButton);
		contentPane.add(juridicaRadioButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		dniLabel = new JLabel("Ingrese DNI:");
		dniLabel.setEnabled(false);
		panel_6.add(dniLabel);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		dniTextField = new JTextField();
		dniTextField.setEnabled(false);
		panel_7.add(dniTextField);
		dniTextField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		cuitLabel = new JLabel("Ingrese CUIT:");
		cuitLabel.setEnabled(false);
		panel_8.add(cuitLabel);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		cuitTextField = new JTextField();
		cuitTextField.setEnabled(false);
		panel_9.add(cuitTextField);
		cuitTextField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		aceptarBoton = new JButton("Aceptar");
		aceptarBoton.setEnabled(false);
		panel_3.add(aceptarBoton);
	}

}

