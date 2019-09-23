package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	public String[] LectorArchivos1D(File archivo, String separador)
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
	
	public String[][] LectorArchivos2D(File archivo, String separador)
	{
		
		String[][] fila = null;
		String linea;
		
		try
	        {
	            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
	            BufferedReader contadorFilas = new BufferedReader(new FileReader(archivo));
	            int filas=0;
	            while(contadorFilas.readLine() !=null)
	            	filas++;
	            contadorFilas.close();
	            
	            fila = new String[filas][0];
	            int contador=0;
	            while ((linea = lectorArchivos.readLine()) != null)
	            {
	            	String[] list = linea.split(separador);
	            	fila[contador] = list;
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
