package vista;

import vista.controladores.EditorTablas;
import vista.controladores.EditorTexto;
import vista.graficos.G_EditorTablas;
import vista.graficos.G_EditorTexto;

public class Vista {

	public EditorTablas editorTablas;
	public EditorTexto editorTexto;
	
	public Vista()
	{
		editorTablas = new EditorTablas();
		editorTexto = new EditorTexto();
	}
	
}
