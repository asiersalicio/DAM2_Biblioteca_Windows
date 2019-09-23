package nucleo;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.Archivos;
import es.Consola;
import es.Es;
import es.Interprete;
import vista.EditorTablas;

public class App {

	public static Es es;
	
	public static void main(String[] args) {
		Inicializar();
		//System.out.println(consola.IntroducirInt("AAAA", 0, 10));
		System.out.println(es.interprete.LectorTextoPlano(es.archivos.ElegirArchivo(new JFileChooser(),new FileNameExtensionFilter("CSV o TXT", "csv", "txt"))));
		//consola.ImprimirArray1D(interprete.LectorLineas(archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("TXT", "txt")), ","));
		es.consola.ImprimirArray2D(es.interprete.LectorArchivos2D(es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("csv", "csv")), ";"));
		
	}
	
	private static void Inicializar()
	{
		es = new Es();
	}

}
