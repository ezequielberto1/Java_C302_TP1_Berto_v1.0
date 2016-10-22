package uiDesktop;/*Nico*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import negocio.*;
import entidades.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class Pelea {

	private JFrame frmpelea;
	private JTextField txtVida1;
	private JTextField txtVida2;
	private JTextField txtEnergia1;
	private JTextField txtEnergia2;
	private JTextField txtTurno;
	private Personaje per, p1, p2;
	private JTextField txtEnergiaAtaque;
	private String tipo_pelea;
	private MenuPelea mp;


	/**
	 * **Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pelea window = new Pelea();
					window.frmpelea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pelea() {

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
		frmpelea = new JFrame();
		frmpelea.setTitle("\u00A1Pelea!");
		frmpelea.setResizable(false);
		frmpelea.setBounds(100, 100, 320, 300);
		frmpelea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmpelea.getContentPane().setLayout(null);
		
		JLabel lblPelea = new JLabel("PELEA");
		lblPelea.setHorizontalAlignment(SwingConstants.CENTER);
		lblPelea.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		lblPelea.setBounds(88, 11, 129, 38);
		frmpelea.getContentPane().add(lblPelea);
		
		JLabel lblPersonaje = new JLabel("Personaje 1");
		lblPersonaje.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 14));
		lblPersonaje.setBounds(38, 93, 78, 14);
		frmpelea.getContentPane().add(lblPersonaje);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(12, 118, 46, 14);
		frmpelea.getContentPane().add(lblVida);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(12, 148, 46, 14);
		frmpelea.getContentPane().add(lblEnergia);
		
		txtVida1 = new JTextField();
		txtVida1.setEditable(false);
		txtVida1.setBounds(66, 115, 46, 20);
		frmpelea.getContentPane().add(txtVida1);
		txtVida1.setColumns(10);
		
		JLabel lblPersonaje_1 = new JLabel("Personaje 2");
		lblPersonaje_1.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 14));
		lblPersonaje_1.setBounds(184, 93, 78, 14);
		frmpelea.getContentPane().add(lblPersonaje_1);
		
		txtVida2 = new JTextField();
		txtVida2.setEditable(false);
		txtVida2.setBounds(216, 115, 46, 20);
		frmpelea.getContentPane().add(txtVida2);
		txtVida2.setColumns(10);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setEditable(false);
		txtEnergia1.setBounds(66, 145, 46, 20);
		frmpelea.getContentPane().add(txtEnergia1);
		txtEnergia1.setColumns(10);
		
		JLabel lblVida_1 = new JLabel("Vida");
		lblVida_1.setBounds(171, 118, 46, 14);
		frmpelea.getContentPane().add(lblVida_1);
		
		JLabel lblEnergia_1 = new JLabel("Energia");
		lblEnergia_1.setBounds(171, 148, 46, 14);
		frmpelea.getContentPane().add(lblEnergia_1);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setEditable(false);
		txtEnergia2.setBounds(216, 145, 46, 20);
		frmpelea.getContentPane().add(txtEnergia2);
		txtEnergia2.setColumns(10);
		
		JLabel lblTurno = new JLabel("Turno Personaje: ");
		lblTurno.setBounds(88, 40, 88, 41);
		frmpelea.getContentPane().add(lblTurno);
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setBounds(175, 50, 40, 20);
		frmpelea.getContentPane().add(txtTurno);
		txtTurno.setColumns(10);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tipo_pelea = "A";
			}
		});
		btnAtacar.setBounds(195, 206, 89, 23);
		frmpelea.getContentPane().add(btnAtacar);
		
		JButton btnDefender = new JButton("Defender");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo_pelea = "D";
			}
		});
		btnDefender.setBounds(197, 240, 89, 23);
		frmpelea.getContentPane().add(btnDefender);
		
		txtEnergiaAtaque = new JTextField();
		txtEnergiaAtaque.setColumns(10);
		txtEnergiaAtaque.setBounds(113, 208, 46, 20);
		frmpelea.getContentPane().add(txtEnergiaAtaque);
		
		JLabel lblEnergiaDeAtaque = new JLabel("Energia de ataque:");
		lblEnergiaDeAtaque.setBounds(12, 210, 100, 14);
		frmpelea.getContentPane().add(lblEnergiaDeAtaque);
		
		mapearAFormulario(p1, p2);
	}
	
	public void pelear(Personaje j1, Personaje j2){
		String turno="P1";
		int energiaAtaque;

		p1 = j1;
		p2 = j2; 		
		p1.setEnergiaPartida(); 		
		p2.setEnergiaPartida(); 		
		p1.setVidaPartida(); 		
		p2.setVidaPartida(); 
		
		if(!txtEnergiaAtaque.getText().matches("[0-9]*") || txtEnergiaAtaque.getText().matches("")) {
			JOptionPane.showMessageDialog(null, "Valor de energía de ataque inválido.");
		}
		else {
			
			if(turno== "P1"){
				turno = "P2";
				if(tipo_pelea == "A"){
					p1.atacar(Integer.valueOf(txtEnergiaAtaque.getText()), p2.getEvasion());
				}
				if (tipo_pelea == "D"){
					p1.defender();
				}
			}
			
			else{
				turno = "P1";
				if(tipo_pelea == "A"){
					p2.atacar(Integer.valueOf(txtEnergiaAtaque.getText()), p1.getEvasion());
				}
				if (tipo_pelea == "D"){
					p2.defender();
				}
			}
			
			mapearAFormulario(p1,p2);
		
			if(p1.getVidaPartida()==0){ 								
				JOptionPane.showMessageDialog(null, "Felicitaciones "+ p2.getNombre()+"¡Has ganado!"); 
				}
			else{ 								
					JOptionPane.showMessageDialog(null, "Felicitaciones "+ p1.getNombre()+"¡Has ganado!"); 
				}  
		}
		
	}
	
	public void mapearAFormulario(Personaje p1, Personaje p2){
		txtEnergia1.setText(String.valueOf( p1.getEnergia()));
		txtVida1.setText(String.valueOf(p1.getVida()));
		txtEnergia2.setText(String.valueOf( p2.getEnergia()));
		txtVida2.setText(String.valueOf(p2.getVida()));
	}
	
	public void setCaller(MenuPelea menuPelea) {
		mp = menuPelea;
		getJugadores();
	}
	
	public MenuPelea getCaller(){
		return mp;
	}
	
	public void getJugadores(){
		p1 = mp.getJ1();
		p2 = mp.getJ2();
	}
	
	
	public void show(boolean b) {
		frmpelea.setVisible(b);
		
	}
		
	
}



//Para agarrar cada personaje se basa en el codigo y nombre proporcioando en la ABMCBusqueda