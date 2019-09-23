package nucleo;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.Es;
import vista.Vista;

public class App {

	public static Es es;
	public static Vista vista;
	
	public static void main(String[] args) {
		Inicializar();
		System.out.println(es.consola.IntroducirInt("AAAA", 0, 10));
		System.out.println(es.interprete.LectorTextoPlano(es.archivos.ElegirArchivo(new JFileChooser(),new FileNameExtensionFilter("CSV o TXT", "csv", "txt"))));
		es.consola.ImprimirArray2D(es.interprete.LectorArchivos2D(es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("csv", "csv")), ";"));
		
		vista.editorTablas.RellenarCelda(es.interprete.LectorArchivos2D(es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("csv", "csv")), ";"));
		vista.editorTablas.Mostrar();
	}
	
	private static void Inicializar()
	{
		es = new Es();
		vista = new Vista();
	}

}
