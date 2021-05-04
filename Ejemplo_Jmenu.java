package proyectogui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.EventQueue;
import javax.swing.JFileChooser;

public class Ejemplo_Jmenu extends JFrame {

	private JPanel contentPane;
    private static int result;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo_Jmenu frame = new Ejemplo_Jmenu();
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
	public Ejemplo_Jmenu() {
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 534);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem diOpen = new JMenuItem("Open");
		mnFile.add(diOpen);
		diOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		                String folder = System.getProperty("user.dir");
		                JFileChooser fc = new JFileChooser(folder);
		                result = fc.showOpenDialog(null);      
			}
		});
		
		JMenuItem mntmSaveas = new JMenuItem("Save_as");
		mnFile.add(mntmSaveas);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mnFile.add(mntmPrint);
		
		JMenuItem diExit = new JMenuItem("Exit");
		mnFile.add(diExit);
		diExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0); 
			}
		});
		
		JMenu mnNewMenu = new JMenu("Edit");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnNewMenu.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnNewMenu.add(mntmPaste);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnNewMenu.add(mntmCut);
		
		JMenu mnProject = new JMenu("Project");
		menuBar.add(mnProject);
		
		JMenuItem mntmNewproject = new JMenuItem("New_Project");
		mnProject.add(mntmNewproject);
		
		JMenuItem mntmOpenproject = new JMenuItem("Open_Project");
		mnProject.add(mntmOpenproject);
		
		JMenuItem mntmSaveproject = new JMenuItem("Save_Project");
		mnProject.add(mntmSaveproject);
		
		JMenuItem mntmCloseproject = new JMenuItem("Close_Project");
		mnProject.add(mntmCloseproject);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}
