package uiDesktop;

import java.awt.EventQueue;

import negocio.*;
import entidades.*;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import org.omg.CORBA.portable.ApplicationException;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class ABMCPersonaje {

	private JFrame frmCrearPersonaje;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtEnergia;
	private JTextField txtVida;
	private JTextField txtEvasion;
	private JTextField txtDefensa;
	private JTextField txtTotales;

	private CtrlABMPersonaje ctrl;
	private JTextField txtDisponibles;
	private int opcion;
	private Personaje p;
	private JButton btnBorrar;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje window = new ABMCPersonaje();
					window.frmCrearPersonaje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMCPersonaje() {

		try
		{ 
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		} 
		catch(Exception e){ 
		}

		initialize();
		
		ctrl = new CtrlABMPersonaje();

	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearPersonaje = new JFrame();
		frmCrearPersonaje.setTitle("Gesti\u00F3n de personaje");
		frmCrearPersonaje.setBounds(100, 100, 433, 263);
		frmCrearPersonaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearPersonaje.getContentPane().setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(98, 11, 38, 20);
		frmCrearPersonaje.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(33, 14, 55, 14);
		frmCrearPersonaje.getContentPane().add(lblCodigo);


		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(166, 14, 55, 14);
		frmCrearPersonaje.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setToolTipText("");
		txtNombre.setBounds(231, 11, 145, 20);
		frmCrearPersonaje.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblEnergia = new JLabel("Energia:");
		lblEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnergia.setBounds(42, 63, 46, 14);
		frmCrearPersonaje.getContentPane().add(lblEnergia);

		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefensa.setBounds(166, 63, 46, 14);
		frmCrearPersonaje.getContentPane().add(lblDefensa);

		JLabel lblVida = new JLabel("Vida:");
		lblVida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVida.setBounds(42, 94, 46, 14);
		frmCrearPersonaje.getContentPane().add(lblVida);

		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvasion.setBounds(166, 94, 46, 14);
		frmCrearPersonaje.getContentPane().add(lblEvasion);

		JLabel lblPuntosDisponibles = new JLabel("Puntos Disponibles");
		lblPuntosDisponibles.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntosDisponibles.setBounds(42, 149, 96, 20);
		frmCrearPersonaje.getContentPane().add(lblPuntosDisponibles);

		txtEnergia = new JTextField();

		txtEnergia.setBounds(101, 60, 35, 20);
		frmCrearPersonaje.getContentPane().add(txtEnergia);
		txtEnergia.setColumns(10);

		txtVida = new JTextField();
		txtVida.setColumns(10);
		txtVida.setBounds(101, 91, 35, 20);
		frmCrearPersonaje.getContentPane().add(txtVida);

		txtEvasion = new JTextField();
		txtEvasion.setColumns(10);
		txtEvasion.setBounds(231, 91, 35, 20);
		frmCrearPersonaje.getContentPane().add(txtEvasion);

		txtDefensa = new JTextField();
		txtDefensa.setBounds(231, 60, 35, 20);
		frmCrearPersonaje.getContentPane().add(txtDefensa);
		txtDefensa.setColumns(10);

		txtTotales = new JTextField();
		txtTotales.setEditable(false);
		txtTotales.setBounds(148, 184, 35, 20);
		frmCrearPersonaje.getContentPane().add(txtTotales);
		txtTotales.setColumns(10);

		txtDisponibles = new JTextField();
		txtDisponibles.setEditable(false);
		txtDisponibles.setBounds(148, 149, 35, 20);
		frmCrearPersonaje.getContentPane().add(txtDisponibles);
		txtDisponibles.setColumns(10);

		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPuntosTotales.setBounds(63, 184, 75, 20);
		frmCrearPersonaje.getContentPane().add(lblPuntosTotales);


		JLabel condDef = new JLabel();
		condDef.setText("Max 20 puntos");
		condDef.setFont(new Font("Tahoma", Font.BOLD, 11));
		condDef.setBackground(SystemColor.control);
		condDef.setBounds(278, 60, 98, 20);
		condDef.setVisible(false);
		frmCrearPersonaje.getContentPane().add(condDef);

		JLabel condEv = new JLabel();
		condEv.setText("Max 80 puntos");
		condEv.setFont(new Font("Tahoma", Font.BOLD, 11));
		condEv.setBackground(SystemColor.control);
		condEv.setBounds(278, 91, 98, 20);
		condEv.setVisible(false);
		frmCrearPersonaje.getContentPane().add(condEv);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(318, 183, 89, 23);
		frmCrearPersonaje.getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCrearPersonaje.setVisible(false);
			}
		});

		JButton btnGuardar = new JButton("Guardar");
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrar();
			}
		});
		frmCrearPersonaje.getContentPane().add(btnBorrar);
		btnBorrar.setVisible(false);

		btnBorrar.setBounds(212, 183, 89, 23);

		btnGuardar.setBounds(318, 148, 89, 23);
		frmCrearPersonaje.getContentPane().add(btnGuardar);
		

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(opcion==0)
					agregar();
				if(opcion==1)
					modificar();
			}
		});

		txtEnergia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtTotales.setText(String.valueOf(Integer.parseInt(txtEnergia.getText())+Integer.parseInt(txtDefensa.getText())+Integer.parseInt(txtEvasion.getText())+Integer.parseInt(txtVida.getText())));
			}
		});

		txtDefensa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtTotales.setText(String.valueOf(Integer.parseInt(txtEnergia.getText())+Integer.parseInt(txtDefensa.getText())+Integer.parseInt(txtEvasion.getText())+Integer.parseInt(txtVida.getText())));
			}
		});

		txtVida.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtTotales.setText(String.valueOf(Integer.parseInt(txtEnergia.getText())+Integer.parseInt(txtDefensa.getText())+Integer.parseInt(txtEvasion.getText())+Integer.parseInt(txtVida.getText())));
			}
		});

		txtEvasion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtTotales.setText(String.valueOf(Integer.parseInt(txtEnergia.getText())+Integer.parseInt(txtDefensa.getText())+Integer.parseInt(txtEvasion.getText())+Integer.parseInt(txtVida.getText())));
			}
		});
		
	} 
	
	protected void agregar() {
		if(datosValidos()){
			Personaje p=MapearDeFormulario();
			ctrl.add(p);
		}
	}

	protected void modificar() {

		if (datosValidos())
		{
			Personaje po = ctrl.getPersonaje(Integer.parseInt(txtCodigo.getText()));
			if(po!=null)	MapearAFormulario(po);
			Personaje p=MapearDeFormulario();
			ctrl.update(p, po.getNombre());
			limpiarCampos();}

	}

	protected void borrar() {

		ctrl.delete(Integer.parseInt(txtCodigo.getText()),txtNombre.getText());
		JOptionPane.showMessageDialog(null, "Personaje '" + txtNombre.getText() + "' eliminado correctamente.");
		limpiarCampos();

	}

	public void MapearAFormulario(Personaje p){
		if(p.getNombre()!=null || p.getCodigo()!=0) {	
			txtCodigo.setText(String.valueOf(p.getCodigo()));
			txtNombre.setText(String.valueOf(p.getNombre()));
		}
		txtEnergia.setText(String.valueOf( p.getEnergia()));
		txtDefensa.setText(String.valueOf(p.getDefensa()));
		txtVida.setText(String.valueOf(p.getVida()));
		txtEvasion.setText(String.valueOf( p.getEvasion()));
		txtTotales.setText(String.valueOf(p.getPtos_totales()));
		

	}

	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();

		p.setCodigo(Integer.parseInt("0"));
		p.setEnergia(Integer.parseInt(txtEnergia.getText()));
		p.setDefensa(Integer.parseInt(txtDefensa.getText()));
		p.setVida(Integer.parseInt(txtVida.getText()));
		p.setEvasion(Integer.parseInt(txtEvasion.getText()));
		p.setNombre(txtNombre.getText());
		int suma=0;
		suma=p.getEnergia()+p.getDefensa()+p.getVida()+p.getEvasion();
		p.setPtos_totales(suma);
		return p;
	}

	protected void limpiarCampos(){	

		txtTotales.setText("");
		txtDisponibles.setText("");
		txtEnergia.setText("");
		txtDefensa.setText("");
		txtVida.setText("");
		txtEvasion.setText("");
		txtNombre.setText("");
		txtCodigo.setText("");	
	}

	public boolean datosValidos(){
		boolean valido=true;
		boolean coincideNom=false;
		boolean coincideCodNom=false;
		int suma=0;



		if(!txtEnergia.getText().matches("[0-9]*") || txtEnergia.getText().matches(""))
		{
			JOptionPane.showMessageDialog(null, "Energía ingresada inválida");
			valido=false;
		}

		if(!txtDefensa.getText().matches("[0-9]*") || txtDefensa.getText().matches("") ||Integer.parseInt(txtDefensa.getText())>20 )
		{
			JOptionPane.showMessageDialog(null, "Defensa ingresada inválida");
			valido=false;
		}

		if(!txtEvasion.getText().matches("[0-9]*") || txtEvasion.getText().matches("") || Integer.parseInt(txtEvasion.getText())>80)
		{
			JOptionPane.showMessageDialog(null, "Evasión ingresada inválida.");
			valido=false;
		}

		if(!txtVida.getText().matches("[0-9]*")|| txtVida.getText().matches(""))
		{
			JOptionPane.showMessageDialog(null, "LA VIDA NO ES UN NUMERO");
			valido=false;
		}

		if(txtNombre.getText().matches("") || txtNombre.getText().matches("Ingrese nombre") )
		{
			JOptionPane.showMessageDialog(null, "No se ha ingresado un nombre.");
			valido=false;
			txtNombre.setText("Ingresa nombre!!");
		}

		coincideNom= ctrl.coincideNombre(txtNombre.getText());
		if(opcion==1) 
		{	coincideCodNom= ctrl.coincideCodNom(Integer.parseInt(txtCodigo.getText()), txtNombre.getText());
		if (coincideCodNom==false && coincideNom==true) 
		{JOptionPane.showMessageDialog(null, "No coincide Nombre con el codigo pero si esta en la BD");
		valido=false;
		}
		}

		if (coincideNom==true && opcion==0)
		{ 	valido=false;
		JOptionPane.showMessageDialog(null, "Ya existe nombre en BD");
		}



		if (valido==true)
		{	int resto=0;
		suma= Integer.parseInt(txtDefensa.getText()) + Integer.parseInt(txtEvasion.getText()) + Integer.parseInt(txtVida.getText()) + Integer.parseInt(txtEnergia.getText());
		if(suma>200)
		{
			JOptionPane.showMessageDialog(null, "Has asignado puntos de más.");
			valido=false;

		}
		resto=200-suma;
		if (resto>=0)
		{	txtTotales.setText(String.valueOf(suma));
		txtDisponibles.setText(String.valueOf(resto));
		JOptionPane.showMessageDialog(null, "Te sobran: "+resto+" puntos para asignar, podes modificar esos puntos en cualquier momento");
		}
		else JOptionPane.showMessageDialog(null, "Te excediste: "+ -(resto)+" puntos");
		}

		return valido;

	}
	
	public void show (boolean b){
		this.frmCrearPersonaje.setVisible(b);
	}
	
	public void setPersonaje(Personaje per){
		p = per;
		MapearAFormulario(p);
	}
	
	public void setOpcion(int o){
		opcion = o;
		if(opcion==1){
			btnBorrar.setVisible(true);
		}
	}
} 









