package nucleo;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.Archivos;
import es.Consola;
import es.Interprete;

public class App {

	public static Consola consola;
	public static Archivos archivos;
	public static Interprete interprete;
	
	public static void main(String[] args) {
		Inicializar();
		//System.out.println(consola.IntroducirInt("AAAA", 0, 10));
		System.out.println(interprete.LectorTextoPlano(archivos.ElegirArchivo(new JFileChooser(),new FileNameExtensionFilter("CSV o TXT", "csv", "txt"))));
		//consola.ImprimirArray2D(interprete.LectorLineas(archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("TXT", "txt")), ","));
		consola.ImprimirArray3D(interprete.LectorArchivos3D(archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("csv", "csv")), ";"));
		
	}
	
	private static void Inicializar()
	{
		consola = new Consola(new Scanner(System.in));
		archivos = new Archivos();
		interprete = new Interprete();
	}

}
