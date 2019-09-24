package vista;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


public class EditorTexto
{

private JFrame frame;
private JPanel panelPrincipal;
private JPanel panelInferior;
private JPanel panelContenedor;
private JTextArea textArea;
private JToolBar toolBar;
private boolean ventanaVisible=false;

public EditorTexto()
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
	
	textArea = new JTextArea();
	panelContenedor.add(textArea);
	
	toolBar = new JToolBar();
	panelContenedor.add(toolBar, BorderLayout.NORTH);
}

public void EstablecerTexto(String texto)
{
	textArea.setText(texto);
}
	
public void Mostrar()
{
	frame.setVisible(true);
	ventanaVisible=true;
}
	
}
