package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vista.graficos.G_EditorTexto;

public class EditorTexto extends G_EditorTexto {

	private File archivo;
	private boolean cambios=false;
	
	public EditorTexto()
	{
		AnadirListeners();
	}
	
	private void AnadirListeners() {
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoArchivo();
				cambios=false;
			}
		});	
		
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuardarArchivo();
				cambios=false;
			}
		});	
		
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				cambios=true;
			}

			@Override
			public void insertUpdate(DocumentEvent e) {cambios=true;}
			@Override
			public void removeUpdate(DocumentEvent e) {cambios=true;}
		});
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if(cambios) {
		        	int respuesta = JOptionPane.showConfirmDialog(frame, "No ha guardado los cambios, ¿Desea guardarlos?", "No ha guardado los cambios", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		        	if (respuesta==JOptionPane.YES_OPTION){
				        if(GuardarArchivo())
				        {
				        	frame.dispose();
				        }
				        
				    }
		        	else if(respuesta==JOptionPane.NO_OPTION)
		        	{
		        		frame.dispose();
		        	}		    	
		        }
		        else
		        {
		        	frame.dispose();
		        }
		    }
		});
	}

	public void EstablecerTexto(String texto, File archivo)
	{
		this.archivo=archivo;
		frame.setTitle(archivo.getName());
		textArea.setText(texto);
		cambios=false;
	}
		
	public void Mostrar()
	{
		frame.setVisible(true);
		ventanaVisible=true;
	}
	
	private void NuevoArchivo()
	{
		archivo=null;
		textArea.setText("");
		frame.setTitle("Nuevo documento de texto plano");
	}
	
	private boolean GuardarArchivo()
	{
		archivo=es.archivos.GrabarTextoPlano(archivo, textArea.getText());
		if(archivo!=null)
			{
				frame.setTitle(archivo.getName());
				return true;
			}
		else
		{
			return false;
		}
	}
	
	
}
