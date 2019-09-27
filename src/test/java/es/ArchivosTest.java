package es;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.junit.Test;

public class ArchivosTest {

	@Test
	public void ElegirArchivoTest() {
		
		Archivos archivos = new Archivos();
	
		System.out.println(" ## Instruicciones de la prueba ##");
		System.out.println("[TEST] No haga caso a mensajes que no sean de tipo TEST");
		System.out.println("[TEST] 1. En la primera prueba selecciona cancelar");
		assertEquals(null, archivos.ElegirArchivo(new JFileChooser(),new FileNameExtensionFilter("[TEST] 1. PULSA CANCELAR", "qwerty")));
		System.out.println("[TEST] 2. Selecciona un archivo con una extension que no sea txt");
		File archivo = archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("[TEST] 2. Selecciona un No TXT 3. Selecciona un TXT", "txt"));
		assertEquals(true, archivo.getAbsolutePath().endsWith(".txt"));
	}

}
