package vista.controladores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import vista.graficos.G_EditorRapido;

public class Dialogos {

	public static String EditorRapido(JFrame framePadre, boolean activo, String texto) {
		G_EditorRapido editorRapido = new G_EditorRapido(framePadre, texto);		
		editorRapido.getTextArea().setEnabled(activo);
		editorRapido.getBtnAceptar().setVisible(activo);
		editorRapido.getFrame().setVisible(true);
		return editorRapido.getTextArea().getText();
	}
	
	
	private void ModoEdicion(boolean activo)
	{
		
//		if(activo)
//		{
//			textArea.setBackground(Color.WHITE);
//		}
//		else
//		{
//			textArea.setBackground(Color.LIGHT_GRAY);
//		}
	}

}
