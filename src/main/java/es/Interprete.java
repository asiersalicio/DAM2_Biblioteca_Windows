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
            lectorArchivos.close();
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
	
	public ArrayList<String[]> LectorArchivos3D(File archivo, String separador)
	{
		
		ArrayList<String[]> fila = new ArrayList<String[]>();
		String linea;
		
		try
	        {
	            
	            
	            //Create the file reader
	            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
	            //Read the file line by line
	            int contador=0;
	            while ((linea = lectorArchivos.readLine()) != null)
	            {
	            	String[] list = linea.split(separador);
	            	fila.add(contador,list);
	            	contador++;
	            }
	            lectorArchivos.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			
		   return fila;

	}
}
