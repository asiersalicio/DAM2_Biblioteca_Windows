package objetos;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CeldaDatos extends Celda {
	private String nomCelda;
	
	public CeldaDatos(JPanel panelDatos, int colX, int colY, String nomCelda)
	{
		super(panelDatos,colX,colY);
		this.nomCelda=nomCelda;
		
		JLabel lblCol = new JLabel(nomCelda);
		lblCol.setBounds(5, 30, 279, 14);
		panel.add(lblCol);
		
		CrearListeners();
	}
	
	private void CrearListeners()
	{
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel.setBackground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				 JOptionPane.showMessageDialog(null, "Libro: " + nomCelda, "Información del libro", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	

	
}
