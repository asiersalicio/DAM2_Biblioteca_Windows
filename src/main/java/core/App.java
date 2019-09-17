package core;

import java.util.Scanner;

import io.TerminalReader;

public class App {

	public static TerminalReader terminalReader;
	
	public static void main(String[] args) {
		Inicializar();
		System.out.println(terminalReader.nextInt("AAAA", 0, 10));
	}
	
	private static void Inicializar()
	{
		terminalReader = new TerminalReader(new Scanner(System.in));
	}

}
