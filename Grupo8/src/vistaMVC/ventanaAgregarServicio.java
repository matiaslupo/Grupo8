package vistaMVC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class ventanaAgregarServicio extends JFrame implements KeyListener,MouseListener {

	private JPanel contentPane;
	private JTextField nombretextField;
	private JTextField calleTextField;
	private JTextField alturaTextField;
	private JTextField pisoTextField;
	private final ButtonGroup tipoDepabuttonGroup = new ButtonGroup();
	private JTextField descripcionTextField;
	private JLabel nombreLabel;
	private JLabel seleccion1Label ;
	private JRadioButton casaRadioButton;
	private JRadioButton departamentoRadioButton ;
	private JLabel pisoLabel;
	private JLabel calleLabel ;
	private JLabel alturaLabel ;
	private JLabel descripcionLabel ;
	private JLabel seleccion2Label  ;
	private JRadioButton cienMBNewRadioButton ;
	private JRadioButton quinientosMBRadioButton ;
	private JButton aceptarButton ;
	private final ButtonGroup tipoInternetGroup = new ButtonGroup();
	private ActionListener actionlistener;

	public ventanaAgregarServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(12, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		nombreLabel = new JLabel("Ingrese Nombre:");
		panel_3.add(nombreLabel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		nombretextField = new JTextField();
		panel_4.add(nombretextField);
		nombretextField.setColumns(10);
		
		seleccion1Label = new JLabel("Seleccione tipo de Departamento:");
		contentPane.add(seleccion1Label);
		
		casaRadioButton = new JRadioButton("Casa");
		tipoDepabuttonGroup.add(casaRadioButton);
		contentPane.add(casaRadioButton);
		
		departamentoRadioButton = new JRadioButton("Departamento");
		tipoDepabuttonGroup.add(departamentoRadioButton);
		contentPane.add(departamentoRadioButton);
		
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_10.add(panel_1);
		
		calleLabel = new JLabel("Calle:");
		panel_1.add(calleLabel);
		
		JPanel panel_2 = new JPanel();
		panel_10.add(panel_2);
		
		calleTextField = new JTextField();
		panel_2.add(calleTextField);
		calleTextField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		
		alturaLabel = new JLabel("Altura:");
		panel_8.add(alturaLabel);
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9);
		
		alturaTextField = new JTextField();
		panel_9.add(alturaTextField);
		alturaTextField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		pisoLabel = new JLabel("Piso:");
		pisoLabel.setEnabled(false);
		panel_11.add(pisoLabel);
		
		JPanel panel_12 = new JPanel();
		panel_6.add(panel_12);
		
		pisoTextField = new JTextField();
		pisoTextField.setEnabled(false);
		panel_12.add(pisoTextField);
		pisoTextField.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);
		
		descripcionLabel = new JLabel("Descripcion:");
		descripcionLabel.setEnabled(false);
		panel_13.add(descripcionLabel);
		
		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14);
		
		descripcionTextField = new JTextField();
		descripcionTextField.setEnabled(false);
		panel_14.add(descripcionTextField);
		descripcionTextField.setColumns(15);
		
	    seleccion2Label = new JLabel("Seleccione internet:");
		seleccion2Label.setEnabled(false);
		contentPane.add(seleccion2Label);
		
		cienMBNewRadioButton = new JRadioButton("100 MB");
		cienMBNewRadioButton.setEnabled(false);
		tipoInternetGroup.add(cienMBNewRadioButton);
		contentPane.add(cienMBNewRadioButton);
		
		quinientosMBRadioButton= new JRadioButton("500 MB");
		quinientosMBRadioButton.setEnabled(false);
		tipoInternetGroup.add(quinientosMBRadioButton);
		contentPane.add(quinientosMBRadioButton);
		
		JPanel panel_15 = new JPanel();
		contentPane.add(panel_15);
		
		aceptarButton = new JButton("Aceptar");
		aceptarButton.setEnabled(false);
		panel_15.add(aceptarButton);
		
		this.nombretextField.addKeyListener(this);
		this.calleTextField.addKeyListener(this);
		this.alturaTextField.addKeyListener(this);
		this.pisoTextField.addKeyListener(this);
		this.descripcionTextField.addKeyListener(this);
		
		this.casaRadioButton.addMouseListener(this);
		this.departamentoRadioButton.addMouseListener(this);
		this.cienMBNewRadioButton.addMouseListener(this);
		this.quinientosMBRadioButton.addMouseListener(this);
		
		this.setVisible(true);
	}

	public void keyPressed(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {
		String nombre, calle, descripcion;
		int altura=-1,piso=-1;
		nombre= this.nombretextField.getText();
		calle =this.calleTextField.getText();
		descripcion= this.descripcionTextField.getText();
		try {
			altura= Integer.parseInt(this.alturaTextField.getText());
			piso= Integer.parseInt(this.pisoTextField.getText());
		}
		catch(NumberFormatException e) {}
		boolean res= (this.casaRadioButton.isSelected() && !nombre.equals("") && !calle.equals("") && altura>0) || 
				(this.departamentoRadioButton.isSelected() && !nombre.equals("") && !calle.equals("") && altura>0 && !descripcion.equals("") && piso>=0);
		this.seleccion2Label.setEnabled(res);
		this.cienMBNewRadioButton.setEnabled(res);
		this.quinientosMBRadioButton.setEnabled(res);
		if (this.cienMBNewRadioButton.isSelected() || this.quinientosMBRadioButton.isSelected()) {
			this.aceptarButton.setEnabled(res);
		}
	
	}

	public void keyTyped(KeyEvent arg0) {}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {
		if (arg0.getButton()==1) {
			this.pisoLabel.setEnabled(this.departamentoRadioButton.isSelected());
			this.pisoTextField.setEnabled(this.departamentoRadioButton.isSelected());
			this.descripcionLabel.setEnabled(this.departamentoRadioButton.isSelected());
			this.descripcionTextField.setEnabled(this.departamentoRadioButton.isSelected());
			if (!this.departamentoRadioButton.isEnabled()) {
				this.pisoTextField.setText("0");
				this.descripcionTextField.setText("none");
			}
			String nombre, calle, descripcion;
			int altura=-1,piso=-1;
			nombre= this.nombretextField.getText();
			calle =this.calleTextField.getText();
			descripcion= this.descripcionTextField.getText();
			try {
				altura= Integer.parseInt(this.alturaTextField.getText());
				piso= Integer.parseInt(this.pisoTextField.getText());
			}
			catch(NumberFormatException e) {}
			
			if (this.cienMBNewRadioButton.isSelected() || this.quinientosMBRadioButton.isSelected()) {
				boolean res= (this.casaRadioButton.isSelected() && !nombre.equals("") && !calle.equals("") && altura>0) || 
						(this.departamentoRadioButton.isSelected() && !nombre.equals("") && !calle.equals("") && altura>0 && !descripcion.equals("") && piso>=0);
				this.aceptarButton.setEnabled(res);
			}
			
		}
		
	}

	public void mouseReleased(MouseEvent arg0) {}

}
