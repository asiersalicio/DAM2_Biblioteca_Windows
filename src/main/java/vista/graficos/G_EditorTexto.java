package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import nucleo.App;



public class G_EditorTexto extends App
{

protected JFrame frame;
protected JPanel panelPrincipal;
protected JPanel panelInferior;
protected JPanel panelContenedor;
protected JTextArea textArea;
protected JToolBar toolBar;
protected boolean ventanaVisible=false;
protected JButton btnGuardar;
protected JButton btnNuevo;

public G_EditorTexto()
{			
	frame = new JFrame();
	frame.setTitle("Nuevo documento de texto plano");
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
	
	btnNuevo = new JButton("Nuevo");
	toolBar.add(btnNuevo);
	
	btnGuardar = new JButton("Guardar");
	toolBar.add(btnGuardar);
}
	
}
