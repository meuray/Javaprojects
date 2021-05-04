package proyectogui2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class elswim extends JFrame {

	private JPanel contentPane;
	private JTextField textone;
	private JTextField texttwo;
	private JTextField textthree;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					elswim frame = new elswim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public elswim() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 701);
		
		JMenuBar elmenuBar = new JMenuBar();
		setJMenuBar(elmenuBar);
		
		JMenu filedentro = new JMenu("File");
		elmenuBar.add(filedentro);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Student Details", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Modify Delete Student Details", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblOk = new JLabel("Modify Student Details");
		lblOk.setBounds(12, 12, 198, 22);
		panel_1.add(lblOk);
		
		JLabel lblStudentname = new JLabel("Student_Name:");
		lblStudentname.setBounds(173, 56, 125, 22);
		panel_1.add(lblStudentname);
		
		JLabel lblStudentadress = new JLabel("Student_Adress:");
		lblStudentadress.setBounds(173, 90, 102, 22);
		panel_1.add(lblStudentadress);
		
		JLabel lblFathresname = new JLabel("Fathre's_Name:");
		lblFathresname.setBounds(173, 123, 102, 22);
		panel_1.add(lblFathresname);
		
		textone = new JTextField();
		textone.setBounds(283, 54, 114, 26);
		panel_1.add(textone);
		textone.setColumns(10);
		
		texttwo = new JTextField();
		texttwo.setBounds(283, 88, 114, 26);
		panel_1.add(texttwo);
		texttwo.setColumns(10);
		
		textthree = new JTextField();
		textthree.setBounds(283, 121, 114, 26);
		panel_1.add(textthree);
		textthree.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(429, 52, 135, 31);
		comboBox.addItem("Nancy");
		panel_1.add(comboBox);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(283, 155, 119, 30);
		panel_1.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(428, 155, 136, 30);
		panel_1.add(rdbtnFemale);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(173, 197, 63, 22);
		panel_1.add(lblClass);
		
		JComboBox comboBox_one = new JComboBox();
		comboBox_one.setBounds(283, 193, 134, 31);
		comboBox_one.addItem("2nd PUC");
		panel_1.add(comboBox_one);
		
		JComboBox wombocombo = new JComboBox();
		wombocombo.setBounds(429, 193, 135, 31);
		wombocombo.addItem("Section A");
		panel_1.add(wombocombo);
		
		JCheckBox chckbxSslcMarksCard = new JCheckBox("SSLC Marks Card");
		chckbxSslcMarksCard.setBounds(283, 238, 135, 30);
		panel_1.add(chckbxSslcMarksCard);
		
		JCheckBox chckbxCharacterCertificater = new JCheckBox("Character Certificater");
		chckbxCharacterCertificater.setBounds(283, 265, 157, 30);
		panel_1.add(chckbxCharacterCertificater);
		
		JCheckBox chckbxPhotopassportSize = new JCheckBox("PHOTO_(Passport Size)");
		chckbxPhotopassportSize.setBounds(444, 232, 211, 30);
		panel_1.add(chckbxPhotopassportSize);
		
		JCheckBox chckbxNccCertificadesGives = new JCheckBox("NCC Certificades Gives");
		chckbxNccCertificadesGives.setBounds(444, 265, 211, 30);
		panel_1.add(chckbxNccCertificadesGives);
		
		JButton btnDeleteRecord = new JButton("DELETE RECORD");
		btnDeleteRecord.setBounds(283, 303, 145, 32);
		panel_1.add(btnDeleteRecord);
		
		JButton btnModifyRecord = new JButton("MODIFY RECORD");
		btnModifyRecord.setBounds(444, 303, 145, 32);
		panel_1.add(btnModifyRecord);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(elswim.class.getResource("/image/Screenshot_20210430_023754.png")));
		lblNewLabel.setBounds(283, 347, 330, 212);
		panel_1.add(lblNewLabel);
		
		
		
		
	}
}
