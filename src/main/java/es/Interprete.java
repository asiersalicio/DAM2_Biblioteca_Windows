package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Interprete {

	public Interprete()
	{
		
	}
	
	public String LectorTextoPlano(File archivo)
	{
		String resultado = "";
		try
        {
            String linea = "";
            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
            while ((linea = lectorArchivos.readLine()) != null)
            {
                resultado=resultado + linea + "\n";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return resultado;
	}
	
	public String[] LectorArchivos2D(File archivo, String separador)
	{
		String[] resultado = new String[0];
		try
        {
            String linea = "";
            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
            int contador=0;
            while ((linea = lectorArchivos.readLine()) != null)
            {
            	contador++;
            	resultado=Arrays.copyOf(resultado, contador);
            	resultado[contador-1] = linea;//.split(separador);
            }
            lectorArchivos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return resultado;
	}
	
	public void LectorArchivos3D(File archivo, String separador)
	{
		
		//ESTO HAY QUE MEJORARLO
		   try
	        {
	            String linea = "";
	            //Create the file reader
	            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
	             
	            //Read the file line by line
	            while ((linea = lectorArchivos.readLine()) != null)
	            {
	                //Get all tokens available in line
	                String[] tokens = linea.split(separador);
	                for(String token : tokens)
	                {
	                    //Print all tokens
	                    System.out.println(token);
	                }
	            }
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	}
}
