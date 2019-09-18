package io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileReader {

	private JFileChooser fileChooser;

	public FileReader(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public File ElegirArchivo(FileNameExtensionFilter filtro) {
		System.out.println("Abriendo selector de archivos");
		fileChooser.setFileFilter(filtro);
		int returnVal = fileChooser.showOpenDialog(null);
		File file;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			String path = file.getPath();
			System.out.println("La ruta del archivo seleccionado es" + fileChooser.getSelectedFile().getPath());
			return file;
		} else {
			return null;
		}
	}

}


