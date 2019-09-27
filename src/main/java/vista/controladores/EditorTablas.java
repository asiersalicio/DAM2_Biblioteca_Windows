package vista.controladores;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import objetos.Celda;
import vista.graficos.G_EditorTablas;

public class EditorTablas extends G_EditorTablas {

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
	}

	public void Mostrar()
	{
		frame.setVisible(true);
		ventanaVisible=true;
	}
	
	public void RellenarCeldas(ArrayList<ArrayList<String>> arrayList, File archivo)
	{
		celdas = new ArrayList<ArrayList<Celda>>();
		scrollVertical.setMaximum(arrayList.size());
		frame.setTitle(archivo.getName());
		for(int y=0;y<arrayList.size();y++)
		{
			celdas.add(y, new ArrayList<Celda>());
			for(int x=0;x<arrayList.get(y).size();x++)
			{
				celdas.get(y).add(x, new Celda(panelDatos, x, y, arrayList.get(y).get(x)));
			}
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
}
