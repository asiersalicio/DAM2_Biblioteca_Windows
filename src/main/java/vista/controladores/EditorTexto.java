package vista.controladores;

import vista.graficos.G_EditorTexto;

public class EditorTexto extends G_EditorTexto {

	public EditorTexto()
	{
		
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
