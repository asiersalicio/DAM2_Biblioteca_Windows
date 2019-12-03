package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nucleo.App;
import vista.graficos.G_CambiarTamaņo;
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
				new EditorTexto();
				vista.editorTexto = new EditorTexto();
				vista.editorTexto.Mostrar();
			}
		});
		
		CambiadorTamaņoArchivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new G_CambiarTamaņo();
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
	}
}
