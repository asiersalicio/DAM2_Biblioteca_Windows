package objetos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vista.controladores.Catalogo;
import vista.controladores.Dialogos;

public class CeldaDatos extends Celda {
	private String nomCelda;
	private JFrame framePadre;
	private JLabel lblCol;
	
	public CeldaDatos(JFrame framePadre, JPanel panelDatos, int colX, int colY, String nomCelda)
	{
		super(panelDatos,colX,colY, true);
		this.nomCelda=nomCelda;
		this.framePadre=framePadre;
		
		lblCol = new JLabel(nomCelda);
		lblCol.setBounds(5, 30, 279, 14);
		panel.add(lblCol);
		
		CrearListeners();
	}
	
	private void CrearListeners()
	{
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EstablecerTexto(Dialogos.EditorRapido(framePadre, activada, nomCelda));
			}
		});
	}
	
	public void EstablecerTexto(String texto)
	{
		nomCelda=texto;
		lblCol.setText(texto);		
	}


}
