package core;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import io.FileReader;
import io.TerminalReader;

public class App {

	public static TerminalReader terminalReader;
	public static FileReader fileReader;
	
	public static void main(String[] args) {
		Inicializar();
		System.out.println(terminalReader.nextInt("AAAA", 0, 10));
		fileReader.ElegirArchivo(new FileNameExtensionFilter("CSV", ".csv", ".txt"));
	}
	
	private static void Inicializar()
	{
		terminalReader = new TerminalReader(new Scanner(System.in));
		fileReader = new FileReader(new JFileChooser());
	}

}
