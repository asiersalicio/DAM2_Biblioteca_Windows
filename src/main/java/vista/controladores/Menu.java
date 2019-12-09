package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import nucleo.App;
import vista.graficos.G_CambiarTamaño;
import vista.graficos.G_Menu;

public class Menu extends G_Menu {
 
	public Menu()
	{
		AnadirListeners();
	}
	
	public void AnadirListeners()
	{
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		editorTextoPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.editorTexto = new EditorTexto();
				vista.editorTexto.Mostrar();
			}
		});
		
		CambiadorTamañoArchivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new G_CambiarTamaño();
			}
		});
		
		btnTratamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tratamiento();
			}
		});
		
		catalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App.menu.LeerModoGrafico();
			}
		});
		btnPropiedadesArchivo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditarAtributos(new es.Archivos().ElegirArchivo(new JFileChooser(), new FileNameExtensionFilter("Archivos txt o exe", "txt","exe")));
			}
		});
	}
}
