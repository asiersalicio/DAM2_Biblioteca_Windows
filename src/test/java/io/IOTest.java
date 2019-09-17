package io;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class IOTest {

	@Test
	public void TerminalReaderTest()
	{
		Scanner reader=new Scanner(System.in);
		TerminalReader terminalReader=new TerminalReader(reader);
		
		
		//TEST lector numeros
		int esperado=2;
		int minimo=0;
		int maximo=10;
		
		System.out.println("\nTEST nextInt() ### INSTRUCCIONES DE LA PRUEBA ###");
		System.out.println("En la primera prueba introduce una letra");
		System.out.println("En la segunda prueba introduce un valor fuera de rango (menor de " + minimo + ")");
		System.out.println("En la segunda prueba introduce un valor fuera de rango (mayor de " + maximo + ")");
		System.out.println("En la tercera prueba introduce un " + esperado);
		assertEquals(esperado, terminalReader.nextInt("TEST lectorNumeros", minimo, maximo));
		
		//TEST lector texto
		System.out.println("\nTEST nextString() ### INSTRUCCIONES DE LA PRUEBA ###");
		String esperadoString="PRUEBA";
		System.out.println("Introduce " + esperadoString);
		assertEquals(esperadoString, terminalReader.nextString("TEST lectorTexto"));
		
	}
	
	
}
