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
	
	public void ImprimirArray1D(String[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
			System.out.println("----------------------------------");
		}
	}
	
	public void ImprimirArray2D(String[][] array)
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.print(i + "\t");
			for(int z=0;z<array[i].length;z++)
			{
				if(array[i][z].length()>12)
				{
					System.out.print("|" + array[i][z].substring(0, 12) + "...");
				}
				else if(array[i][z].length()>6) 
				{
					System.out.print("|" + array[i][z] + "\t");
				}
				else
				{
					System.out.print("|" + array[i][z] + "\t\t");
				}
				
			}
			System.out.println("\n-------------------------------------------------------------------------------");
		}
	}
	
}
