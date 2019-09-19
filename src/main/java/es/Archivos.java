package es;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivos {

	public Archivos() {
	}

	public File ElegirArchivo(JFileChooser fileChooser, FileNameExtensionFilter filtro) {
		System.out.println("Abriendo selector de archivos");
		fileChooser.setFileFilter(filtro);
		int returnVal = fileChooser.showOpenDialog(null);
		File file = null;;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			System.out.println("La ruta del archivo seleccionado es " + file.getPath());
			for(int i=0;i<filtro.getExtensions().length;i++)
			{
				if(file.getPath().toLowerCase().endsWith(filtro.getExtensions()[i]))
				{
					System.out.println("Archivo seleccionado de tipo correcto");
					return file;
				}
			}
			System.out.println("No ha seleccionado el tipo de archivo correcto");
			return ElegirArchivo(new JFileChooser(), filtro);
			
		} else {
			System.out.println("Seleccion de archivo cancelada");
			return null;
		}
	}

}


