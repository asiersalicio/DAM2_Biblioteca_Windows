package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import objetos.Celda;
import objetos.CeldaDatos;
import objetos.CeldaTitulo;
import vista.graficos.G_EditorTablas;

public class EditorTablas extends G_EditorTablas {

	public boolean cambios = false;
	private File archivo=null;
	public boolean ratonEncima=false;
	
	public EditorTablas()
	{
		AnadirListeners();
	}
	
	private void AnadirListeners() {
		
		sliderHorizontal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				anchoCeldas=sliderHorizontal.getValue();
				ActualizarPosCeldas();
			}
		});
		sliderVertical.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				altoCeldas=sliderVertical.getValue();
				ActualizarPosCeldas();
			}
		});
		scrollHorizontal.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				ActualizarPosCeldas();
			}
		});
		scrollVertical.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				ActualizarPosCeldas();
			}
		});
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoArchivo();
				cambios=false;
			}
		});	
		
		btnEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ActivarModoEdcionCeldas(btnEdicion.isSelected());
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GuardarArchivo();				
			}
		});
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if(cambios) {
		        	int respuesta = JOptionPane.showConfirmDialog(frame, "No ha guardado los cambios, �Desea guardarlos?", "No ha guardado los cambios", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		        	if (respuesta==JOptionPane.YES_OPTION){
				        if(GuardarArchivo())
				        {
				        	frame.dispose();
				        }
				        
				    }
		        	else if(respuesta==JOptionPane.NO_OPTION)
		        	{
		        		frame.dispose();
		        	}		    	
		        }
		        else
		        {
		        	frame.dispose();
		        }
		    }
		});
	}

	public void Mostrar()
	{
		frame.setVisible(true);
		ventanaVisible=true;
	}
	
	public void RellenarCeldas(ArrayList<ArrayList<String>> arrayList, File archivo)
	{
		frame.setTitle(archivo.getName());
		celdas = new ArrayList<ArrayList<Celda>>();
		scrollVertical.setMaximum(arrayList.size());
		frame.setTitle(archivo.getName());
		int x,y;
		celdas.add(0, new ArrayList<Celda>());
		for(x=0;x<6;x++)
		{
			switch(x)
			{
			case 0: celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, "C�digo de barras"));
			break;
			case 1: celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, "ISBN"));
			break;
			case 2: celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, "Autor"));
			break;
			case 3: celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, "Descripci�n"));
			break;
			case 4: celdas.get(0).add(x, new CeldaTitulo(panelDatos, x, 0, "Prestado a"));
			break;
			}
			
		}
		for(y=1;y<arrayList.size();y++)
		{
			celdas.add(y, new ArrayList<Celda>());
			for(x=0;x<arrayList.get(y).size();x++)
			{
				celdas.get(y).add(x, new CeldaDatos(frame, panelDatos, x, y, arrayList.get(y).get(x)));
			}
			//celdas.get(y).add(x+1, new CeldaAnadir(panelDatos, x+1, y));
		}
	}
	
	private void ActualizarPosCeldas()
	{
		if(ventanaVisible)
		{
			for(int y=0;y<celdas.size();y++)
			{
				try 
				{
					for(int x=0;x<celdas.get(y).size();x++)
					{					
						celdas.get(y).get(x).ActualizarPos(scrollHorizontal.getValue(), scrollVertical.getValue(), anchoCeldas, altoCeldas);
					}
				}
				catch(NullPointerException ex) {}
			}
		}
	}
	
	private void ActivarModoEdcionCeldas(boolean ModoEdcion)
	{
		if(ventanaVisible)
		{
			for(int y=0;y<celdas.size();y++)
			{
				try 
				{
					for(int x=0;x<celdas.get(y).size();x++)
					{					
						celdas.get(y).get(x).ModoEdicion(ModoEdcion);;
					}
				}
				catch(NullPointerException ex) {}
			}
		}
	}
	
	private void NuevoArchivo()
	{
		archivo=null;
		frame.setTitle("Nuevo documento de texto plano");
	}
	
	private boolean GuardarArchivo()
	{
		ArrayList<ArrayList<String>> textoAGuardar = new ArrayList<ArrayList<String>>();
		for(int y=0;y<celdas.size();y++)
		{
			textoAGuardar.add(y, new ArrayList<String>());
			for(int x=0;x<celdas.get(y).size();x++)
			{					
				Celda celda = celdas.get(y).get(x);
				if(celda instanceof CeldaDatos)
				{
					textoAGuardar.get(y).add(x,((CeldaDatos) celda).nomCelda);
				}
				else
				{
					textoAGuardar.get(y).add(x,"");
				}
			}
		}
		
		archivo=es.interprete.GuardarArrayListEnCSV(archivo, textoAGuardar, ";");
		if(archivo!=null)
			{
				frame.setTitle(archivo.getName());
				return true;
			}
		else
		{
			return false;
		}
	}
}
