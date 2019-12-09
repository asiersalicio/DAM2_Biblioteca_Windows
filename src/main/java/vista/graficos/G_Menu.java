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
	public JButton btnTratamiento, CambiadorTamañoArchivos, catalogo, salir, editorTextoPlano;
	public JButton btnPropiedadesArchivo;

	public G_Menu() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 446, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		catalogo = new JButton("Lector Archivos");
		
		panel.add(catalogo);

		salir = new JButton("Salir");

		editorTextoPlano = new JButton("Editor texto plano");
		
		panel.add(editorTextoPlano);

		CambiadorTamañoArchivos = new JButton("Crear Archivo");
		
		CambiadorTamañoArchivos.setActionCommand("EditorArchivos");
		panel.add(CambiadorTamañoArchivos);
		
		btnPropiedadesArchivo = new JButton("Propiedades Archivo");
		panel.add(btnPropiedadesArchivo);

		btnTratamiento = new JButton("Tratamiento texto");
		
		panel.add(btnTratamiento);
		panel.add(salir);

		JLabel label = new JLabel("Bienvenido a  bidebarrieta, elige una de las opciones");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(label, BorderLayout.NORTH);

		frame.setVisible(true);

	}
}
