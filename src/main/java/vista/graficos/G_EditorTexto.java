package vista.graficos;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import nucleo.App;

import java.awt.Toolkit;


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
	frame.setIconImage(Toolkit.getDefaultToolkit().getImage(G_EditorTexto.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
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
	
	btnNuevo = new JButton("");
	btnNuevo.setIcon(new ImageIcon(G_EditorTexto.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
	toolBar.add(btnNuevo);
	
	btnGuardar = new JButton("");
	btnGuardar.setIcon(new ImageIcon(G_EditorTexto.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
	toolBar.add(btnGuardar);
}
	
}
