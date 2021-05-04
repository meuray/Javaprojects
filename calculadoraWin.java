package proyectogui2;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class calculadoraWin extends javax.swing.JFrame {
public calculadoraWin() {
initComponents();
this.setSize(490,230);
cboOperaciones.addItem("Suma");
cboOperaciones.addItem("Resta");
cboOperaciones.addItem("Multiplicacion");
cboOperaciones.addItem("Division");
}
private void initComponents() {
txtNum1 = new javax.swing.JTextField();
txtNum2 = new javax.swing.JTextField();
lblOperador = new javax.swing.JLabel();
cboOperaciones = new javax.swing.JComboBox();
btnDoOper = new javax.swing.JButton();
txtResult = new javax.swing.JTextField();
lblIgual = new javax.swing.JLabel();
lblTipOper = new javax.swing.JLabel();
lblInstrucciones = new javax.swing.JLabel();
mnbMenu = new javax.swing.JMenuBar();
menProg = new javax.swing.JMenu();
mniSalir = new javax.swing.JMenuItem();
menAyuda = new javax.swing.JMenu();
mniAcerca = new javax.swing.JMenuItem();

getContentPane().setLayout(null);

setTitle("CalculadoraComboBox");
addWindowListener(new java.awt.event.WindowAdapter() {
public void windowClosing(java.awt.event.WindowEvent evt) {
exitForm(evt);
}
});

txtNum1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
txtNum1ActionPerformed(evt);
}
});

getContentPane().add(txtNum1);
txtNum1.setBounds(20, 90, 70, 20);

txtNum2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
txtNum2ActionPerformed(evt);
}
});

getContentPane().add(txtNum2);
txtNum2.setBounds(130, 90, 70, 20);

lblOperador.setText("Tipo de operacion a realizar");
getContentPane().add(lblOperador);
lblOperador.setBounds(20, 25, 190, 16);

cboOperaciones.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
cboOperacionesActionPerformed(evt);
}
});

getContentPane().add(cboOperaciones);
cboOperaciones.setBounds(230, 20, 120, 25);

btnDoOper.setText("Realizar operacion");
btnDoOper.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
btnDoOperActionPerformed(evt);
}
});

getContentPane().add(btnDoOper);
btnDoOper.setBounds(120, 130, 180, 26);

getContentPane().add(txtResult);
txtResult.setBounds(240, 90, 100, 20);

lblIgual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
lblIgual.setText("=");
lblIgual.setBorder(new javax.swing.border.EtchedBorder());
getContentPane().add(lblIgual);
lblIgual.setBounds(210, 90, 20, 20);

lblTipOper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
lblTipOper.setText("+");
lblTipOper.setBorder(new javax.swing.border.EtchedBorder());
getContentPane().add(lblTipOper);
lblTipOper.setBounds(100, 90, 20, 20);

lblInstrucciones.setFont(new java.awt.Font("Dialog", 0, 12));
lblInstrucciones.setText("Escriba el operador y el operando para realizar la operacion");
getContentPane().add(lblInstrucciones);
lblInstrucciones.setBounds(20, 60, 390, 16);

menProg.setText("Programa");
mniSalir.setText("Salir");
mniSalir.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
mniSalirActionPerformed(evt);
}
});

menProg.add(mniSalir);
mnbMenu.add(menProg);
menAyuda.setText("Ayuda");
mniAcerca.setText("Acerca de...");
mniAcerca.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
mniAcercaActionPerformed(evt);
}
});

menAyuda.add(mniAcerca);
mnbMenu.add(menAyuda);
setJMenuBar(mnbMenu);

pack();
}

private void btnDoOperActionPerformed(java.awt.event.ActionEvent evt) {
try{
Float fNum1, fNum2;
fNum1 = new Float( txtNum1.getText() );
fNum2 = new Float( txtNum2.getText() );
Calculadoram miCalc = new Calculadoram( fNum1.floatValue(), fNum2.floatValue() );
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Suma") )
txtResult.setText( miCalc.suma() );
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Resta") )
txtResult.setText( miCalc.resta() );
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Multiplicacion") )
txtResult.setText( miCalc.multiplica() );
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Division") )
txtResult.setText( miCalc.divide() );
} 
catch( NumberFormatException NFEx ){
javax.swing.JOptionPane.showMessageDialog(this,
"Introduce solo numeros","Debug", javax.swing.JOptionPane.ERROR_MESSAGE );
if ( NFEx.toString().endsWith("\""+txtNum1.getText()+"\"") ){
txtNum1.requestFocus();
txtNum1.selectAll();
} 
else{
txtNum2.requestFocus();
txtNum2.selectAll();
} 
} 
}

private void cboOperacionesActionPerformed(java.awt.event.ActionEvent evt) {
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Suma") )
lblTipOper.setText("+");
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Resta") )
lblTipOper.setText("-");
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Multiplicacion") )
lblTipOper.setText("*");
if ( cboOperaciones.getSelectedItem().toString().equalsIgnoreCase("Division") )
lblTipOper.setText("/");
}
private void txtNum2ActionPerformed(java.awt.event.ActionEvent evt) {
}
private void txtNum1ActionPerformed(java.awt.event.ActionEvent evt) {
}
private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {
System.exit(0);
}

private void mniAcercaActionPerformed(java.awt.event.ActionEvent evt) {
javax.swing.JOptionPane.showMessageDialog(this, "Raymar Vernaza- \nCalculadorComboBox \nProgramacion_1 abril-2021", "Acerca de...",javax.swing.JOptionPane.INFORMATION_MESSAGE);}//GEN-LAST:event_mniAcercaActionPerformed


private void exitForm(java.awt.event.WindowEvent evt) {
System.exit(0);
}


public static void main(String args[]) {
new calculadoraWin().show();
}

private javax.swing.JMenuItem mniSalir;
private javax.swing.JTextField txtNum2;
private javax.swing.JTextField txtNum1;
private javax.swing.JComboBox cboOperaciones;
private javax.swing.JMenuItem mniAcerca;
private javax.swing.JButton btnDoOper;
private javax.swing.JLabel lblTipOper;
private javax.swing.JTextField txtResult;
private javax.swing.JLabel lblIgual;
private javax.swing.JLabel lblOperador;
private javax.swing.JMenuBar mnbMenu;
private javax.swing.JLabel lblInstrucciones;
private javax.swing.JMenu menProg;
private javax.swing.JMenu menAyuda;

}

class Calculadoram{
private double Num1, Num2;

public Calculadoram( double num1, double num2 ){
this.Num1 = num1;
this.Num2 = num2;
} 
public String suma(){
return java.lang.String.valueOf( this.Num1 + this.Num2 );
}

public String resta(){
return java.lang.String.valueOf( this.Num1 - this.Num2 );
}
public String multiplica(){
return java.lang.String.valueOf( this.Num1 * this.Num2 );
} 
public String divide(){
return java.lang.String.valueOf( this.Num1 / this.Num2 );
}
} 

