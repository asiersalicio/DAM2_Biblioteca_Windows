package objetos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CeldaAnadir extends Celda {

	public CeldaAnadir(JPanel panelDatos, int colX, int colY) {
		super(panelDatos, colX, colY);
		JButton lblCol = new JButton("PRUEBA");
		lblCol.setBounds(0, 0, 60, 60);
		panel.add(lblCol);
	}
	
}
