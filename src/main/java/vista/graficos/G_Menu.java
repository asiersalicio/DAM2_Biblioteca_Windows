package vista.graficos;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import nucleo.App;
import vista.controladores.EditorTexto;
import vista.controladores.Tratamiento;

import javax.swing.JButton;


public class G_Menu extends App {

	private JPanel contentPane;

	public G_Menu() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 419, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Button catalogo = new Button("Catálogo");
		catalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App.menu.LeerModoGrafico();
			}
		});
		panel.add(catalogo);
		
		Button clientes = new Button("Clientes");
		clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(clientes);
		
				Button salir = new Button("Salir");
				salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				
				Button editorTextoPlano = new Button("Editor texto plano");
				editorTextoPlano.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new EditorTexto(); vista.editorTexto = new EditorTexto(); vista.editorTexto.Mostrar();
					}
				});
				panel.add(editorTextoPlano);
				
				Button CambiadorTamañoArchivos = new Button("CambiarTama\u00F1oArchivo");
				CambiadorTamañoArchivos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new G_CambiarTamaño();
					}
				});
				CambiadorTamañoArchivos.setActionCommand("EditorArchivos");
				panel.add(CambiadorTamañoArchivos);
				
				Button btnTratamiento = new Button("Tratamiento texto");
				btnTratamiento.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new Tratamiento();
					}
				});
				panel.add(btnTratamiento);
				panel.add(salir);
		
		JLabel label = new JLabel("Bienvenido a  bidebarrieta, elige una de las opciones");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(label, BorderLayout.NORTH);
		
		frame.setVisible(true);
		
	}
}
