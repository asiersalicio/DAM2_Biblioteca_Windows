package es;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

	private Scanner reader;
	public Consola(Scanner reader)
	{
		this.reader=reader;
	}
	
	public int IntroducirInt(String pregunta, int numeroMinimo, int numeroMaximo)
	{
		boolean error=true;
		int resultado = 0;
		while(error)
		{
			System.out.print(pregunta + " (" + numeroMinimo + " - " + numeroMaximo + "): ");
			try {
				resultado=reader.nextInt();
				if (resultado<numeroMinimo || resultado > numeroMaximo)
				{
					System.out.println("Solo se permiten numeros entre " + numeroMinimo + " y " + numeroMaximo);
				}
				else
				{
					error=false;
				}
					
			}catch(InputMismatchException ex)
			{
				System.out.println("Solo se admiten numeros");
				reader.nextLine();
			}
		}
		return resultado;
	}
	
	public String IntroducirString(String pregunta)
	{
		System.out.print(pregunta);
		return reader.next();
	}
	
}
