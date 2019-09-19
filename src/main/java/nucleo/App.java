package nucleo;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.Archivos;
import es.Consola;

public class App {

	public static Consola consola;
	public static Archivos archivos;
	
	public static void main(String[] args) {
		Inicializar();
		System.out.println(consola.IntroducirInt("AAAA", 0, 10));
		archivos.ElegirArchivo(new JFileChooser(),new FileNameExtensionFilter("CSV o TXT", "csv", "txt"));
	}
	
	private static void Inicializar()
	{
		consola = new Consola(new Scanner(System.in));
		archivos = new Archivos();
	}

}
