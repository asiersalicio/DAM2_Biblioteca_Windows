package vista.graficos;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;

import objetos.Celda;

public class G_EditorTablas {

	protected JFrame frame;
	protected JPanel panelPrincipal;
	protected JPanel panelInferior;
	protected JPanel panelContenedor;
	protected JPanel panelDatos;
	protected JScrollBar scrollHorizontal;
	protected JScrollBar scrollVertical;
	protected ArrayList<ArrayList<Celda>> celdas;
	protected int anchoCeldas = 60;
	protected int altoCeldas = 60;
	protected boolean ventanaVisible=false;
	protected JSlider sliderHorizontal, sliderVertical;
	
	public G_EditorTablas()
	{		
		frame = new JFrame();
		frame.setSize(500, 500);
		
		panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		sliderHorizontal = new JSlider();
		sliderHorizontal.setValue(60);
		sliderHorizontal.setMaximum(200);
		sliderHorizontal.setMinimum(25);
		

		panelInferior.add(sliderHorizontal);
		
		sliderVertical = new JSlider();
		sliderVertical.setValue(60);
		sliderVertical.setMaximum(200);
		sliderVertical.setMinimum(25);
		panelInferior.add(sliderVertical);
		
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
}

