package proyectogui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class allworks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allworks frame = new allworks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public allworks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClasedejavaswim = new JLabel("Clase_de_JavaSwing");
		lblClasedejavaswim.setBounds(153, 0, 132, 22);
		contentPane.add(lblClasedejavaswim);
		
		JButton btnCalculadorajtext = new JButton("Calculadora_JText");
		btnCalculadorajtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculadorav1 calt = new Calculadorav1();
				calt.setVisible(true);
			}
		});
		btnCalculadorajtext.setBounds(129, 65, 177, 32);
		contentPane.add(btnCalculadorajtext);
		
		JButton wombocombobox = new JButton("Calculadora_ComboBox");
		wombocombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraWin wombocalt = new calculadoraWin();
				wombocalt.setVisible(true);
			}
		});
		wombocombobox.setBounds(129, 147, 177, 32);
		contentPane.add(wombocombobox);
		
		JButton btnEjemplodejmenu = new JButton("Ejemplo_de_Jmenu");
		btnEjemplodejmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejemplo_Jmenu EjW = new Ejemplo_Jmenu();
				EjW.setVisible(true);
			}
		});
		btnEjemplodejmenu.setBounds(129, 235, 177, 32);
		contentPane.add(btnEjemplodejmenu);
		
		JButton btnUsuarioycontrasea = new JButton("Usuario_y_Contraseña");
		btnUsuarioycontrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login Logpose = new Login();
				Logpose.setVisible(true);
			}
		});
		btnUsuarioycontrasea.setBounds(129, 322, 177, 32);
		contentPane.add(btnUsuarioycontrasea);
		
		JButton btnSwingherramientas = new JButton("SWING_Herramientas");
		btnSwingherramientas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elswim Nancy = new elswim();
				Nancy.setVisible(true);
			}
		});
		btnSwingherramientas.setBounds(129, 403, 177, 32);
		contentPane.add(btnSwingherramientas);
	}

}
