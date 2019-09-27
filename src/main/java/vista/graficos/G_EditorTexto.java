package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


public class G_EditorTexto
{

protected JFrame frame;
protected JPanel panelPrincipal;
protected JPanel panelInferior;
protected JPanel panelContenedor;
protected JTextArea textArea;
protected JToolBar toolBar;
protected boolean ventanaVisible=false;
protected JButton btnGuardar;

public G_EditorTexto()
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
	
	btnGuardar = new JButton("");
	btnGuardar.setIcon(new ImageIcon(G_EditorTexto.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
	toolBar.add(btnGuardar);
}
	
}
