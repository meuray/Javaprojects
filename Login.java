package proyectogui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	public Image img;
	public URL backg;
	
	private JPanel contentPane;
	private JTextField cuadrouser;
	private JPasswordField passclave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblUsername = new JLabel("User_Name:");
		lblUsername.setFont(new Font("Hack", Font.BOLD, 13));
		lblUsername.setBounds(62, 88, 86, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Hack", Font.BOLD, 13));
		lblPassword.setBounds(62, 122, 77, 22);
		contentPane.add(lblPassword);
		
		cuadrouser = new JTextField();
		cuadrouser.setBounds(166, 84, 142, 26);
		contentPane.add(cuadrouser);
		cuadrouser.setColumns(10);
		
		passclave = new JPasswordField();
		passclave.setBounds(166, 120, 142, 26);
		contentPane.add(passclave);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        String userName = cuadrouser.getText();
		        String password = passclave.getText();
				if (userName.equals("admin") && password.equals("123")) {
				JOptionPane.showMessageDialog( null, "Bienvenido_al_Sistema", "you entered", JOptionPane.INFORMATION_MESSAGE );
				main m = new main();
				m.setVisible(true);
				}else {
				 JOptionPane.showMessageDialog(null, "invalid user or password", "ERROR",JOptionPane.ERROR_MESSAGE);
				cuadrouser.setText("");
				passclave.setText("");
				}
			}
		});
		btnEnter.setFont(new Font("Hack", Font.BOLD, 16));
		btnEnter.setBounds(62, 179, 108, 32);
		contentPane.add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cuadrouser.setText("");
				passclave.setText("");
			}
		});
		btnCancel.setFont(new Font("Hack", Font.BOLD, 16));
		btnCancel.setBounds(196, 179, 108, 32);
		contentPane.add(btnCancel);
		
		JLabel backcack = new JLabel("");
		Dimension dimi = this.getSize();
		backcack.setIcon(new ImageIcon(Login.class.getResource("/image/IMG_1305copy.JPG")));
		backcack.setBounds(0,0,dimi.width,dimi.height);
		contentPane.add(backcack);
	}
	

}
