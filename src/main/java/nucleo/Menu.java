package nucleo;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import vista.controladores.EditorTexto;

public class Menu extends App {

	public void MostrarMenu()
	{
 		while(true)
 		{
		System.out.println("### Biblioteca de Bidebarrieta ###");
		System.out.println("0. Salir");
		System.out.println("1. Leer archivo (Consola)");
		System.out.println("2. Leer archivo (Editor grafico)");
		System.out.println("3. Abrir editor de texto");
		switch(es.consola.IntroducirInt("Selecione una opcion", 0, 3))
		{
		case 0: System.exit(0);
		break;
		case 1: LeerModoConsola();
		break;
		case 2: LeerModoGrafico();
		break;
		case 3: new EditorTexto(); vista.editorTexto.Mostrar();
		break;
		}
 		}
	}
	
	private void LeerModoGrafico() {
		{
			File archivo = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivos: .txt .csv .ini", "txt", "csv", "ini"));
			if(archivo!=null)
			{
				es.interprete.LeerArchivoGraficoPorExtension(archivo);
			}
			else
			{
				System.out.println("Cancelado... Volviendo al menu");
			}
		}
	}

	private void LeerModoConsola()
	{
		File archivo = es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivos: .txt .csv .ini", "txt", "csv", "ini"));
		if(archivo!=null)
		{
			es.interprete.LeerArchivoConsolaPorExtension(archivo);
		}
		else
		{
			System.out.println("Cancelado... Volviendo al menu");
		}
	}

}
