package es;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
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
	
	public ArrayList<ArrayList<String>> LectorArchivos2D(File archivo, String separador)
	{
		
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		String linea;
		
		try
	        {
	            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
	            int contador=0;
	            while ((linea = lectorArchivos.readLine()) != null)
	            {
	            	String[] list = linea.split(separador);
	            	tabla.add(new ArrayList<String>());
	            	for(int i=0;i<list.length;i++)
	            	{
	            		tabla.get(contador).add(i, list[i]);
	            	}
	            	contador++;
	            }
	            lectorArchivos.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			
		   return tabla;
	}
	
	public ArrayList<ArrayList<String>> LectorArchivosINI(File archivo)
	{
		
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		String linea;
		
		try
        {
            BufferedReader lectorArchivos = new BufferedReader(new FileReader(archivo));
            int contador=0;
            while ((linea = lectorArchivos.readLine()) != null)
            {
            	if(!(linea.charAt(0)=='#') && !(linea.charAt(0)==' ')) 
            	{
	            	String[] list = linea.split("=");
	            	tabla.add(new ArrayList<String>());
	            	for(int i=0;i<list.length;i++)
	            	{
	            		tabla.get(contador).add(i, list[i]);
	            	}
	            	contador++;
            	}
            }
            lectorArchivos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
			
		   return tabla;
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
			vista.editorTablas.RellenarCelda(es.interprete.LectorArchivosINI(archivo));
			vista.editorTablas.Mostrar();
			return true;
		}
		else
		{
			return false;
		}
	}
}
