package vista.graficos;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

public class G_EditarAtributos {

	public JDialog frame;
	public JCheckBox rdbtnEjecutable, rdbtnLectura, rdbtnEscritura;
	public JButton btnModificar;
	
	public G_EditarAtributos()
	{
		frame = new JDialog();
		frame.setModal(true);
		frame.setResizable(false);
		frame.setSize(459,295);
		frame.getContentPane().setLayout(null);
		
		rdbtnEjecutable = new JCheckBox("Ejecutable");
		rdbtnEjecutable.setBounds(45, 79, 109, 23);
		frame.getContentPane().add(rdbtnEjecutable);
		
		rdbtnLectura = new JCheckBox("Lectura");
		rdbtnLectura.setBounds(168, 79, 109, 23);
		frame.getContentPane().add(rdbtnLectura);
		
		rdbtnEscritura = new JCheckBox("Escritura");
		rdbtnEscritura.setBounds(279, 79, 109, 23);
		frame.getContentPane().add(rdbtnEscritura);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(341, 232, 89, 23);
		frame.getContentPane().add(btnModificar);
		
	}
}
