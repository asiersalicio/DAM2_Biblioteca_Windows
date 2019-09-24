package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import nucleo.App;

public class Interprete extends App {

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
	
	public String[][] LectorArchivosINI(File archivo)
	{
		
		String[][] fila = null;
		String linea;
		
		try
	        {
	            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
	            BufferedReader contadorFilas = new BufferedReader(new FileReader(archivo));
	            int filas=0;
	            String filaTemporal;
	           
	            while((filaTemporal=contadorFilas.readLine()) !=null)
	            	 try {
	            	if(!(filaTemporal.charAt(0)=='#') && !(filaTemporal.charAt(0)==' '))
					{
						filas++;
					}
	            	 }
	            	catch(StringIndexOutOfBoundsException ex) {} catch(ArrayIndexOutOfBoundsException ex2) {}
	  	        	
	            contadorFilas.close();
	            
	            fila = new String[filas][0];
	            int contador=0;
	            while ((linea = lectorArchivos.readLine()) != null)
	            {
	            	try {
		            	if(!(linea.charAt(0)=='#') && !(linea.charAt(0)==' '))
		            	{
			            	String[] list = linea.split("=");
			            	fila[contador] = list;
			            	contador++;
		            	} else if(linea.charAt(0)=='[')
		            	{
		            		System.out.println("pos muy bien");
		            	}
	            	}catch(StringIndexOutOfBoundsException ex) {} catch(ArrayIndexOutOfBoundsException ex2) {}
	            	
	            }
	            lectorArchivos.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			
		   return fila;
	}
	
	public boolean LeerArchivoConsolaPorExtension(File archivo)
	{
		if(archivo.getPath().endsWith(".txt"))
		{
			System.out.println("[INFO] txt detectado");
			System.out.println(LectorTextoPlano(archivo));
			return true;
		}
		else if (archivo.getPath().endsWith(".csv"))
		{
			System.out.println("[INFO] csv detectado");
			es.consola.ImprimirArray2D(LectorArchivos2D(archivo, ";"));
			return true;
		}
		else if (archivo.getPath().endsWith(".ini"))
		{
			System.out.println("[INFO] ini detectado");
			es.consola.ImprimirArray2D(LectorArchivosINI(archivo));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean LeerArchivoGraficoPorExtension(File archivo)
	{
		if(archivo.getPath().endsWith(".txt"))
		{
			System.out.println("[INFO] .txt detectado");
			vista.editorTexto.EstablecerTexto(LectorTextoPlano(archivo));
			vista.editorTexto.Mostrar();
			return true;
		}
		else if (archivo.getPath().endsWith(".csv"))
		{
			System.out.println("[INFO] .csv detectado");
			vista.editorTablas.RellenarCelda(es.interprete.LectorArchivos2D(archivo,";"));
			vista.editorTablas.Mostrar();
			return true;
		}
		else if (archivo.getPath().endsWith(".ini"))
		{
			System.out.println("[INFO] .ini detectado");
			vista.editorTablas.RellenarCelda(es.interprete.LectorArchivos2D(archivo,";"));
			vista.editorTablas.Mostrar();
			return true;
		}
		else
		{
			return false;
		}
	}
}
