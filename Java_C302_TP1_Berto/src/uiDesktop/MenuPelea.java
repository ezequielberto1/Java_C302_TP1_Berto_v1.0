package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import entidades.Personaje;

public class MenuPelea {

	private JFrame frmSeleccinDePersonajes;
	private JTextField evP1;
	private JTextField defP1;
	private JTextField vidaP1;
	private JTextField energiaP1;
	private JLabel lblEnerga;
	private JLabel lblEvP1;
	private JLabel lblDefensa;
	private JLabel lblJugador1;
	private JLabel lblJugador2;
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JTextField codP1;
	private JTextField nomP1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblEvasion;
	private JLabel label_3;
	private JTextField energiaP2;
	private JTextField vidaP2;
	private JTextField defP2;
	private JTextField evP2;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField codP2;
	private JTextField nomP2;
	private JButton btnElegirJ1;
	private JButton btnElegirJ2;
	private JButton btnCancelar;
	private JButton btnpelear;
	private Personaje j1, j2;
	private int jugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPelea window = new MenuPelea();
					window.frmSeleccinDePersonajes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPelea() {
		j1 = new Personaje();
		j2 = new Personaje();
		try 
	    { 
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	    } 
	    catch(Exception e){ 
	    }
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccinDePersonajes = new JFrame();
		frmSeleccinDePersonajes.setTitle("Selecci\u00F3n de personajes");
		frmSeleccinDePersonajes.setBounds(100, 100, 357, 343);
		frmSeleccinDePersonajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		evP1 = new JTextField();
		evP1.setEditable(false);
		evP1.setBounds(66, 146, 35, 20);
		evP1.setColumns(10);
		
		defP1 = new JTextField();
		defP1.setEditable(false);
		defP1.setBounds(66, 175, 35, 20);
		defP1.setColumns(10);
		
		vidaP1 = new JTextField();
		vidaP1.setEditable(false);
		vidaP1.setBounds(66, 203, 35, 20);
		vidaP1.setColumns(10);
		
		energiaP1 = new JTextField();
		energiaP1.setEditable(false);
		energiaP1.setBounds(66, 230, 35, 20);
		energiaP1.setColumns(10);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(30, 205, 20, 14);
		
		lblEnerga = new JLabel("Energ\u00EDa");
		lblEnerga.setBounds(14, 233, 36, 14);
		
		lblEvP1 = new JLabel("Evasion");
		lblEvP1.setBounds(15, 149, 41, 14);
		
		lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(10, 178, 40, 14);
		
		lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setBounds(14, 11, 137, 14);
		lblJugador1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setBounds(176, 11, 137, 14);
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(frmSeleccinDePersonajes.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		panel.add(lblJugador1);
		panel.add(lblEnerga);
		panel.add(lblVida);
		panel.add(lblEvP1);
		panel.add(lblDefensa);
		panel.add(energiaP1);
		panel.add(vidaP1);
		panel.add(defP1);
		panel.add(evP1);
		panel.add(lblJugador2);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(15, 79, 36, 14);
		panel.add(lblCdigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 104, 40, 14);
		panel.add(lblNombre);
		
		codP1 = new JTextField();
		codP1.setEditable(false);
		codP1.setColumns(10);
		codP1.setBounds(66, 76, 35, 20);
		panel.add(codP1);
		
		nomP1 = new JTextField();
		nomP1.setEditable(false);
		nomP1.setBounds(66, 101, 86, 20);
		panel.add(nomP1);
		nomP1.setColumns(10);
		
		label = new JLabel("Energ\u00EDa");
		label.setBounds(175, 233, 36, 14);
		panel.add(label);
		
		label_1 = new JLabel("Vida");
		label_1.setBounds(191, 205, 20, 14);
		panel.add(label_1);
		
		lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(176, 149, 41, 14);
		panel.add(lblEvasion);
		
		label_3 = new JLabel("Defensa");
		label_3.setBounds(171, 178, 40, 14);
		panel.add(label_3);
		
		energiaP2 = new JTextField();
		energiaP2.setEditable(false);
		energiaP2.setColumns(10);
		energiaP2.setBounds(227, 230, 35, 20);
		panel.add(energiaP2);
		
		vidaP2 = new JTextField();
		vidaP2.setEditable(false);
		vidaP2.setColumns(10);
		vidaP2.setBounds(227, 202, 35, 20);
		panel.add(vidaP2);
		
		defP2 = new JTextField();
		defP2.setEditable(false);
		defP2.setColumns(10);
		defP2.setBounds(227, 175, 35, 20);
		panel.add(defP2);
		
		evP2 = new JTextField();
		evP2.setEditable(false);
		evP2.setColumns(10);
		evP2.setBounds(227, 146, 35, 20);
		panel.add(evP2);
		
		label_4 = new JLabel("C\u00F3digo");
		label_4.setBounds(176, 76, 36, 14);
		panel.add(label_4);
		
		label_5 = new JLabel("Nombre");
		label_5.setBounds(176, 104, 40, 14);
		panel.add(label_5);
		
		codP2 = new JTextField();
		codP2.setEditable(false);
		codP2.setColumns(10);
		codP2.setBounds(227, 73, 35, 20);
		panel.add(codP2);
		
		nomP2 = new JTextField();
		nomP2.setEditable(false);
		nomP2.setColumns(10);
		nomP2.setBounds(227, 101, 86, 20);
		panel.add(nomP2);
		
		btnElegirJ1 = new JButton("Elegir J1...");
		btnElegirJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugador = 1;
				seleccionarPersonaje();
				
			}
		});
		btnElegirJ1.setBounds(40, 36, 89, 23);
		panel.add(btnElegirJ1);
		
		btnElegirJ2 = new JButton("Elegir J2...");
		btnElegirJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jugador = 2;
				seleccionarPersonaje();
				}
		});
		btnElegirJ2.setBounds(200, 36, 89, 23);
		panel.add(btnElegirJ2);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSeleccinDePersonajes.setVisible(false);
			}
		});
		btnCancelar.setBounds(242, 271, 89, 23);
		panel.add(btnCancelar);
		
		btnpelear = new JButton("\u00A1Pelear!");
		btnpelear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pelear();
			}
		});
		btnpelear.setBounds(143, 271, 89, 23);
		panel.add(btnpelear);
		frmSeleccinDePersonajes.getContentPane().setLayout(groupLayout);
	};
	
	public void mapearJ1(){
			System.out.println(j1.getCodigo() + j1.getNombre());
			codP1.setText(String.valueOf(j1.getCodigo()));
			nomP1.setText(String.valueOf(j1.getNombre()));
			energiaP1.setText(String.valueOf(j1.getEnergia()));
			defP1.setText(String.valueOf(j1.getDefensa()));
			vidaP1.setText(String.valueOf(j1.getVida()));
			evP1.setText(String.valueOf(j1.getEvasion()));
		
	}
	
	public void mapearJ2(){
		System.out.println(j2.getCodigo() + j2.getNombre());
		codP2.setText(String.valueOf(j2.getCodigo()));
		nomP2.setText(String.valueOf(j2.getNombre()));
		energiaP2.setText(String.valueOf(j2.getEnergia()));
		defP2.setText(String.valueOf(j2.getDefensa()));
		vidaP2.setText(String.valueOf(j2.getVida()));
		evP2.setText(String.valueOf(j2.getEvasion()));
	}
		
	public void addPersonaje(Personaje j){
		if (jugador == 1){
			j1 = j;
			if(j1.getCodigo()!=0) mapearJ1();
		}
		if (jugador == 2){
			j2 = j;
			if(j2.getCodigo()!=0) mapearJ2();
		}
	}
	
	private void seleccionarPersonaje(){
		ElegirPersonaje frmElegirPersonaje = new ElegirPersonaje();
		frmElegirPersonaje.setCaller(this);
		frmElegirPersonaje.show(true);
	}
	
	private void pelear(){
		Pelea pelea = new Pelea();
		pelea.setCaller(this);
		pelea.show(true);
	}
	
	public Personaje getJ1(){
		return j1;
	}
	
	public Personaje getJ2(){
		return j2;
	}

}
