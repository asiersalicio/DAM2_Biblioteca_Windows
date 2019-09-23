package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import nucleo.App;

import javax.swing.JScrollBar;

public class EditorTablas extends App {

	private JFrame frame;
	private JPanel panelPrincipal;
	private JPanel panelInferior;
	private JPanel panelContenedor;
	private JPanel panelDatos;
	private JScrollBar scrollHorizontal;
	private JScrollBar scrollVertical;
	
	public EditorTablas()
	{		
		frame = new JFrame();
		frame.setSize(500, 500);
		
		panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		panelContenedor = new JPanel();
		panelPrincipal.add(panelContenedor, BorderLayout.CENTER);
		panelContenedor.setLayout(new BorderLayout(0, 0));
		
		panelDatos = new JPanel();
		panelContenedor.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(null);

		
		scrollHorizontal = new JScrollBar();
		scrollHorizontal.setOrientation(JScrollBar.HORIZONTAL);
		panelContenedor.add(scrollHorizontal, BorderLayout.SOUTH);
		
		scrollVertical = new JScrollBar();
		panelContenedor.add(scrollVertical, BorderLayout.EAST);
	}
	
	public void Mostrar()
	{
		frame.setVisible(true);
	}
	
	public void RellenarCelda(String[][] celdas)
	{
		for(int i=0;i<celdas.length;i++)
		{
			for(int z=0;z<celdas[i].length;z++)
			{
				new Celda(panelDatos, z, i, celdas[i][z]);
			}
		}
	}
}
