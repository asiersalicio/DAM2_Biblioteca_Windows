package nucleo;

import es.Es;
import vista.Vista;
import vista.graficos.G_Menu;

public class App {

	public static Es es;
	public static Vista vista;
	public static MenuConsola menu;
	
	public static void main(String[] args) {
		Inicializar();
		menu.MostrarMenu();
//		System.out.println(es.consola.IntroducirInt("AAAA", 0, 10));
//		System.out.println(es.interprete.LectorTextoPlano(es.archivos.ElegirArchivo(new JFileChooser(),new FileNameExtensionFilter("CSV o TXT", "csv", "txt"))));
//		es.consola.ImprimirArray2D(es.interprete.LectorArchivos2D(es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("csv", "csv")), ";"));
//		es.consola.ImprimirArray2D(es.interprete.LectorArchivosINI(es.archivos.ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivos .ini", "ini"))));
		
	}
	
	private static void Inicializar()
	{
		es = new Es();
		vista = new Vista();
		menu = new MenuConsola();
	}
	
}
