package proyectogui2;

import java.sql.*;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Javacrud {

	private JFrame frame;
	private JTextField txtesname;
	private JTextField txteslastn;
	private JTable nutable;
	private JTextField numid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Javacrud window = new Javacrud();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Javacrud() {
		initialize();
		Connect();
		table_load(); 
	}
    
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtrename;

	
	public void Connect() {
	try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost/Testc","","");
		 
	}catch (ClassNotFoundException ex) {
		
	}catch (SQLException ex) {
		
	}                  	
	}
	

	public void table_load() {
		
		try {
			
			pst = con.prepareStatement("select * from students");
			rs = pst.executeQuery();
			nutable.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		   }catch (SQLException eoo) {
			eoo.printStackTrace();
			
		}
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1026, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titlelabel = new JLabel("Student Testc");
		Titlelabel.setFont(new Font("Gargi", Font.BOLD, 28));
		Titlelabel.setBounds(412, 12, 213, 68);
		frame.getContentPane().add(Titlelabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(44, 144, 464, 259);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel theNombre = new JLabel("Nombre");
		theNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		theNombre.setBounds(37, 44, 79, 34);
		panel.add(theNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 16));
		lblApellido.setBounds(37, 160, 79, 34);
		panel.add(lblApellido);
		
		txtesname = new JTextField();
		txtesname.setBounds(164, 47, 240, 31);
		panel.add(txtesname);
		txtesname.setColumns(10);
		
		txteslastn = new JTextField();
		txteslastn.setBounds(164, 161, 240, 34);
		panel.add(txteslastn);
		txteslastn.setColumns(10);
		

		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);  
			}
		});
		btnSalir.setBounds(201, 415, 116, 73);
		frame.getContentPane().add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txtesname.setText("");
				 txteslastn.setText("");
				 numid.setText("");
			}
		});
		btnLimpiar.setBounds(355, 415, 103, 73);
		frame.getContentPane().add(btnLimpiar);
		
		JButton btnEscribir = new JButton("Escribir");
		btnEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre, apellido;
				nombre = txtesname.getText();
				apellido = txteslastn.getText();
				try {
					 pst = con.prepareStatement("insert into students(nombre,lastname)values(?,?)");
					 pst.setString(1, nombre);
					 pst.setString(2, apellido);
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "nuevos datos introducidos");
		
					 table_load();
					 txtesname.setText("");
					 txteslastn.setText("");
					 txtesname.requestFocus();
					
				}catch (SQLException e1) {
				e1.printStackTrace();
				}
				
			}
		});
		btnEscribir.setBounds(44, 415, 125, 73);
		frame.getContentPane().add(btnEscribir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(549, 148, 449, 340);
		frame.getContentPane().add(scrollPane);
		
		nutable = new JTable();
		nutable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nombre", "lastname"
			}
		));
		scrollPane.setViewportView(nutable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(44, 500, 464, 122);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Dialog", Font.BOLD, 30));
		lblId.setBounds(12, 45, 54, 49);
		panel_1.add(lblId);
		
		numid = new JTextField();
		numid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

             	  try {
             		 String aidi = numid.getText();
             		 
             		 pst =con.prepareStatement("select nombre, lastname from students where id = ?");
             		 pst.setString(1, aidi);
             		 ResultSet rs = pst.executeQuery();
             		  if (rs.next()==true) {
             			 String elnombre = rs.getString(1);
             			 String elape = rs.getString(2);
             			txtesname.setText(elnombre);
             			txteslastn.setText(elape);
             			 
             			  
             			  
             		  }else {
               			txtesname.setText("");
               			txteslastn.setText("");
             		  }
             		  
             	  }catch (SQLException eti) {
          			eti.printStackTrace();
             	  }
				
			}
		});
		numid.setBounds(100, 45, 236, 49);
		panel_1.add(numid);
		numid.setColumns(10);
		
		JButton btnActulizar = new JButton("Actulizar");
		btnActulizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre, apellido, bid;
				nombre = txtesname.getText();
				apellido = txteslastn.getText();
				bid =  numid.getText();
				try {
					 pst = con.prepareStatement("update students set nombre= ?, lastname= ? where id= ?");
					 pst.setString(1, nombre);
					 pst.setString(2, apellido);
					 pst.setString(3, bid);
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "datos actualizados");
		
					 table_load();
					 txtesname.setText("");
					 txteslastn.setText("");
					 numid.setText("");
					 txtesname.requestFocus();
					
				}catch (SQLException e2) {
				e2.printStackTrace();
				}
				
				
				}
				
			
		});
		btnActulizar.setBounds(596, 514, 135, 108);
		frame.getContentPane().add(btnActulizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String  bid;
				bid =  numid.getText();
				try {
					 pst = con.prepareStatement("delete from students where id= ?");
					 pst.setString(1, bid);
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "datos borrados");
		
					 table_load();
					 txtesname.setText("");
					 txteslastn.setText("");
					 numid.setText("");
					 txtesname.requestFocus();
					
				}catch (SQLException e3) {
				e3.printStackTrace();
				}
				
			}
		});
		btnBorrar.setBounds(774, 514, 135, 108);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnExpo = new JButton("Exportar_csv");
		btnExpo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					PrintWriter pow= new PrintWriter(new File("/home/mueumi/Documentos/books_table1.csv"));
					StringBuilder sub=new StringBuilder();
					
					pst = con.prepareStatement("select * from students");
					rs = pst.executeQuery();
					 sub.append("id");
					 sub.append(",");
					 sub.append("nombre");
					 sub.append(",");
					 sub.append("lastnate");
					 sub.append("\r\n");
					 while(rs.next()){
						 sub.append(rs.getString("id"));
						 sub.append(",");
						 sub.append(rs.getString("nombre"));
						 sub.append(",");
						 sub.append(rs.getString("lastname"));
						 sub.append("\r\n");
					 }
					pow.write(sub.toString());
					pow.close();
					System.out.println("finished");
					
					
				}catch (Exception e4) {
					e4.printStackTrace();
					System.out.println("oh no");
				}
				
			}
		});
		btnExpo.setBounds(847, 92, 135, 32);
		frame.getContentPane().add(btnExpo);
		
		txtrename = new JTextField();
		txtrename.setBounds(549, 95, 157, 26);
		frame.getContentPane().add(txtrename);
		txtrename.setColumns(10);
		
		JButton btnRenombrar = new JButton("Renombrar");
		btnRenombrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Path source = Paths.get("/home/mueumi/Documentos/books_table1.csv");
				String nuname = txtrename.getText()+".csv";
				
				  try{

					    // rename a file in the same directory
					    Files.move(source, source.resolveSibling(nuname));
					    System.out.println("finished");

					  } catch (Exception em) {
					    em.printStackTrace();
					    System.out.println("oh no");
					  }

				
			}
		});
		btnRenombrar.setBounds(716, 89, 101, 32);
		frame.getContentPane().add(btnRenombrar);
		
		JButton btnBorrado = new JButton("Borrado");
		btnBorrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String surname = txtrename.getText()+".csv";
				String fileName = "/home/mueumi/Documentos/"+surname;
				try {
					Files.delete(Paths.get(fileName));
					System.out.println("yes");
				}catch(Exception rem) {
					rem.printStackTrace();
					System.out.println("oh no");
				}
				

				
				
				
			}
		});
		btnBorrado.setBounds(709, 34, 108, 32);
		frame.getContentPane().add(btnBorrado);
		
		JButton elimportado = new JButton("Importar");
		elimportado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String csvFilePath = "/home/mueumi/Documentos/lapx.csv";
				int batchSize = 20;
				
				try {
					  pst = con.prepareStatement("insert into students(nombre,lastname)values(?,?)");
					  BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
					  String lineText = null;
					  int count = 0;
					  lineReader.readLine();
					  while ((lineText = lineReader.readLine()) != null) {
						  String[] data = lineText.split(",");
			               String elnombre = data[0];
			               String elapellido = data[1];
                           pst.setString(1, elnombre);
                           pst.setString(2, elapellido);
                           pst.executeUpdate();

					  }
					  JOptionPane.showMessageDialog(null, "nuevos datos introducidos");
					  table_load();

				            
				}catch (IOException ex) {
		            System.err.println(ex);
		        } catch (SQLException ex) {
		            ex.printStackTrace();
				}
				
				
				
				

				
				
			
		}});
		elimportado.setBounds(874, 34, 108, 32);
		frame.getContentPane().add(elimportado);
	}
}
