package vista.graficos;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

import nucleo.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dialog.ModalExclusionType;

public class G_EditorRapido extends App {
	protected JDialog frame;
	protected JTextArea textArea;
	protected JButton btnAceptar;
	protected JButton btnCancelar;
	
	public G_EditorRapido(JFrame framePadre, String texto)
	{
		Dibujar(framePadre, texto);
	}
	
	private void Dibujar(JFrame framePadre, String texto)
	{
		frame = new JDialog(framePadre, Dialog.ModalityType.DOCUMENT_MODAL);
		frame.setTitle("EditorRapido");
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		
		textArea = new JTextArea(texto);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, BorderLayout.WEST);
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, BorderLayout.EAST);
	}
	
	public JDialog getFrame() {
		return frame;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
}
