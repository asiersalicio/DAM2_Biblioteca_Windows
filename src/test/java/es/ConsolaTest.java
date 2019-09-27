package es;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

import es.Consola;

public class ConsolaTest {

	@Test
	public void IntroducirInt()
	{
		Scanner reader=new Scanner(System.in);
		Consola terminalReader=new Consola(reader);
		
		
		int esperado=2;
		int minimo=0;
		int maximo=10;
		
		System.out.println("### INSTRUCCIONES DE LA PRUEBA ###");
		System.out.println("[TEST] No haga caso a mensajes que no sean de tipo TEST");
		System.out.println("[TEST] En la primera prueba introduce una letra");
		System.out.println("[TEST] En la segunda prueba introduce un valor fuera de rango (menor de " + minimo + ")");
		System.out.println("[TEST] En la segunda prueba introduce un valor fuera de rango (mayor de " + maximo + ")");
		System.out.println("[TEST] En la tercera prueba introduce un " + esperado);
		assertEquals(esperado, terminalReader.IntroducirInt("TEST lectorNumeros", minimo, maximo));

		
	}
	
	@Test
	public void IntroducirTexto()
	{
		Scanner reader=new Scanner(System.in);
		Consola terminalReader=new Consola(reader);
		System.out.println("### INSTRUCCIONES DE LA PRUEBA ###");
		String esperadoString="PRUEBA";
		System.out.println("[TEST] Introduce " + esperadoString);
		assertEquals(esperadoString, terminalReader.IntroducirString("TEST lectorTexto "));
	}
	
	
}
