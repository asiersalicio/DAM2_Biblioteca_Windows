package vista.graficos;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;

import nucleo.App;
import objetos.Celda;
import objetos.CeldaDatos;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class G_EditorTablas extends App {

	protected JFrame frame;
	protected JPanel panelPrincipal;
	protected JPanel panelInferior;
	protected JPanel panelContenedor;
	public JPanel panelDatos;
	protected JScrollBar scrollHorizontal;
	protected JScrollBar scrollVertical;
	protected ArrayList<ArrayList<Celda>> celdas;
	protected int anchoCeldas = 60;
	protected int altoCeldas = 60;
	protected boolean ventanaVisible=false;
	protected JSlider sliderHorizontal, sliderVertical;
	protected JButton btnNuevo;
	protected JButton btnGuardar;
	protected JToggleButton btnEdicion;
	
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
		panelDatos.setBackground(Color.WHITE);
		panelContenedor.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(null);

		
		scrollHorizontal = new JScrollBar();
		scrollHorizontal.setOrientation(JScrollBar.HORIZONTAL);
		panelContenedor.add(scrollHorizontal, BorderLayout.SOUTH);
		
		
		scrollVertical = new JScrollBar();
		panelContenedor.add(scrollVertical, BorderLayout.EAST);
		
		JToolBar toolBar = new JToolBar();
		panelContenedor.add(toolBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		toolBar.add(panel);
		
		btnNuevo = new JButton("Nuevo");
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		btnEdicion = new JToggleButton("Modo edicion");
		
		panel.add(btnEdicion);
	}
}

