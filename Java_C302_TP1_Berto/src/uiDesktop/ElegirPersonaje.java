package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import data.DataPersonaje;
import entidades.Personaje;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import negocio.CtrlABMPersonaje;
import utils.ApplicationException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElegirPersonaje {

	private JFrame frmElegirPersonaje;
	private JTable tblListaPersonajes;
	private JButton btnSeleccionar;
	private JButton btnCancelar;
	private Personaje j=null;
	private ABMCPersonaje abm;
	private MenuPelea mp;
	private String accion="abm";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirPersonaje window = new ElegirPersonaje();
					window.frmElegirPersonaje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ElegirPersonaje() {
				
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
		frmElegirPersonaje = new JFrame();
		frmElegirPersonaje.setTitle("Elegir personaje...");
		frmElegirPersonaje.setBounds(100, 100, 450, 300);
		frmElegirPersonaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmElegirPersonaje.getContentPane().add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnSeleccionar = new JButton("Seleccionar");
		
		
		btnCancelar = new JButton("Cancelar");
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionar();
				
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmElegirPersonaje.setVisible(false);
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(256, Short.MAX_VALUE)
					.addComponent(btnSeleccionar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSeleccionar)
						.addComponent(btnCancelar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tblListaPersonajes = new JTable();
		tblListaPersonajes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblListaPersonajes);
		panel.setLayout(gl_panel);
		
		DataPersonaje dp = new DataPersonaje();
		try {
			dp.cargarListaPersonajes(tblListaPersonajes);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Personaje getPersonaje(int codigo){
		
		DataPersonaje dp = new DataPersonaje();
		j = dp.getByCodigo(codigo);
		return j;
	}
	
	public void setCaller(MenuPelea menuPelea) {
		mp = menuPelea;
		accion = "elegir";
	}
	
	public MenuPelea getCaller(){
		return mp;
	}
	
	public void show(boolean b){
		frmElegirPersonaje.setVisible(b);
	}
	
	private void seleccionar() {
		int row = tblListaPersonajes.getSelectedRow();	
		String id=tblListaPersonajes.getValueAt(row, 0).toString();
		int cod=Integer.parseInt(id);
		j=getPersonaje(cod);
		send();
		this.frmElegirPersonaje.setVisible(false);
	}
	
	private void send(){
		if (accion=="abm"){
			abm = new ABMCPersonaje();
			abm.setOpcion(1);
			abm.setPersonaje(j);
			abm.show(true);
		}
		if (accion=="elegir"){
			this.getCaller().addPersonaje(j);
			accion="abm";
		}
	}
	
	
}


