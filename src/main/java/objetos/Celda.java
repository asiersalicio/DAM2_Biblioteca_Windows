package objetos;

import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Celda {

	protected JPanel panel;
	protected int colX;
	protected int colY;
	
	public Celda(JPanel panelDatos, int colX, int colY)
	{
		panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.colX=colX;
		this.colY=colY;
		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(colX*60, colY*60, 60, 60);
		panelDatos.add(panel);
		panel.setLayout(null);
		
		
	}
	
	public void ActualizarPos(int x, int y, int ancho, int largo) {
		panel.setBounds(colX*ancho-(x*ancho), colY*largo-(y*largo), ancho, largo);
	}
	
}
