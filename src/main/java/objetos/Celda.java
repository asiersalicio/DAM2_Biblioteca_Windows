package objetos;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;

public class Celda {
	private JPanel panel;
	private int colX;
	private int colY;
	private JPanel panelDatos;
	private String nomCelda;
	
	public Celda(JPanel panelDatos, int colX, int colY, String nomCelda)
	{
		panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.colX=colX;
		this.colY=colY;
		this.panelDatos=panelDatos;
		this.nomCelda=nomCelda;
		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(colX*60, colY*60, 60, 60);
		panelDatos.add(panel);
		panel.setLayout(null);
		
		JLabel lblCol = new JLabel(nomCelda);
		lblCol.setBounds(10, 11, 46, 14);
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

	public void ActualizarPos(int x, int y, int ancho, int largo) {
		panel.setBounds(colX*ancho-(x*ancho), colY*largo-(y*largo), ancho, largo);
	}
	
}
