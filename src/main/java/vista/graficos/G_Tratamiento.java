package vista.graficos;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Cursor;

public class G_Tratamiento {

	public JDialog frame;
	public JTextField textFormat;
	public JLabel lblRegex;
	public JTextPane textOrigen, textDestino;
	public JCheckBox chckbxQuitarEspacios;
	public JRadioButton rbMayusculas, rbMinusculas, rbNoCambiar;
	public JButton btnConvertir;
	
	public G_Tratamiento()
	{
		frame = new JDialog();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setModal(true);
		frame.setSize(588,370);
		frame.getContentPane().setLayout(null);
		
		textOrigen = new JTextPane();
		textOrigen.setText("Lorem ipsum dolor sit amet consectetur, adipiscing elit imperdiet venenatis malesuada dictum, magna inceptos id odio. Class velit felis facilisis suscipit urna quam semper fames conubia, dignissim et sem maecenas feugiat cras proin erat auctor, lacus varius aliquam porta rhoncus at id mi. Sollicitudin pulvinar primis venenatis porta non hac fusce feugiat, maecenas sem natoque volutpat lectus augue nunc, cras mus lacinia malesuada massa ante eros.");
		textOrigen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textOrigen.setBounds(10, 11, 562, 105);
		frame.getContentPane().add(textOrigen);
		
		textFormat = new JTextField();
		textFormat.setBounds(76, 127, 120, 20);
		frame.getContentPane().add(textFormat);
		textFormat.setColumns(10);
		
		lblRegex = new JLabel("Format");
		lblRegex.setBounds(20, 130, 46, 14);
		frame.getContentPane().add(lblRegex);
		
		textDestino = new JTextPane();
		textDestino.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textDestino.setBackground(Color.LIGHT_GRAY);
		textDestino.setEditable(false);
		textDestino.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDestino.setBounds(10, 188, 562, 105);
		frame.getContentPane().add(textDestino);
		
		chckbxQuitarEspacios = new JCheckBox("Quitar espacios");
		chckbxQuitarEspacios.setBounds(202, 126, 109, 23);
		frame.getContentPane().add(chckbxQuitarEspacios);
		
		rbMayusculas = new JRadioButton("Mayusculas");
		rbMayusculas.setBounds(110, 158, 109, 23);
		frame.getContentPane().add(rbMayusculas);
		
		rbMinusculas = new JRadioButton("Minusculas");
		rbMinusculas.setBounds(221, 158, 109, 23);
		frame.getContentPane().add(rbMinusculas);
		
		rbNoCambiar = new JRadioButton("No cambiar");
		rbNoCambiar.setSelected(true);
		rbNoCambiar.setBounds(332, 158, 109, 23);
		frame.getContentPane().add(rbNoCambiar);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbMayusculas);
		group.add(rbMinusculas);
		group.add(rbNoCambiar);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBounds(241, 307, 89, 23);
		frame.getContentPane().add(btnConvertir);
	}
}
