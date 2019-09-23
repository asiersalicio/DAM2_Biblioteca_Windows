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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JSlider;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class EditorTablas extends App {

	private JFrame frame;
	private JPanel panelPrincipal;
	private JPanel panelInferior;
	private JPanel panelContenedor;
	private JPanel panelDatos;
	private JScrollBar scrollHorizontal;
	private JScrollBar scrollVertical;
	private Celda[][] celdas;
	private int anchoCeldas = 60;
	private int altoCeldas = 60;
	private boolean ventanaVisible=false;
	
	public EditorTablas()
	{		
		frame = new JFrame();
		frame.setSize(500, 500);
		
		panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		panelInferior = new JPanel();
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		JSlider sliderHorizontal = new JSlider();
		sliderHorizontal.setValue(60);
		sliderHorizontal.setMaximum(200);
		sliderHorizontal.setMinimum(25);
		sliderHorizontal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				anchoCeldas=sliderHorizontal.getValue();
				ActualizarPosCeldas();
			}
		});

		panelInferior.add(sliderHorizontal);
		
		JSlider sliderVertical = new JSlider();
		sliderVertical.setValue(60);
		sliderVertical.setMaximum(200);
		sliderVertical.setMinimum(25);
		sliderVertical.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				altoCeldas=sliderVertical.getValue();
				ActualizarPosCeldas();
			}
		});
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
		scrollVertical.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				ActualizarPosCeldas();
			}
		});
		panelContenedor.add(scrollVertical, BorderLayout.EAST);
	}
	
	public void Mostrar()
	{
		frame.setVisible(true);
		ventanaVisible=true;
	}
	
	public void RellenarCelda(String[][] textos)
	{
		scrollVertical.setMaximum(textos.length);
		celdas=new Celda[textos.length][];
		for(int y=0;y<textos.length;y++)
		{
			for(int x=0;x<textos[y].length;x++)
			{
				celdas[y]=new Celda[textos[y].length];
			}
		}
		for(int y=0;y<textos.length;y++)
		{
			for(int x=0;x<textos[y].length;x++)
			{
				celdas[y][x]=new Celda(panelDatos, x, y, textos[y][x]);
			}
		}
	}
	
	private void ActualizarPosCeldas()
	{
		if(ventanaVisible)
			for(int y=0;y<celdas.length;y++)
			{
				try {
				for(int x=0;x<celdas[y].length;x++)
				{					
					celdas[y][x].ActualizarPos(scrollHorizontal.getValue(), scrollVertical.getValue(), anchoCeldas, altoCeldas);
					}
				}
				catch(NullPointerException ex) {}
			}
		}
	}

