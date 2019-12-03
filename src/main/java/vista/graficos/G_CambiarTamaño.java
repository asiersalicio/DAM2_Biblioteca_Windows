package vista.graficos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import nucleo.App;
import objetos.Celda;

public class G_CambiarTamaño extends App {

	protected JDialog frame;
	protected JPanel panelPrincipal;
	protected boolean ventanaVisible=false;
	private JTextField textField;
	
	public G_CambiarTamaño()
	{		
		frame = new JDialog();
		frame.setSize(500, 111);
		
		panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		JLabel lblEstablezcaElTamao = new JLabel("Establezca el tama\u00F1o de archivo");
		lblEstablezcaElTamao.setBounds(10, 11, 234, 18);
		panelPrincipal.add(lblEstablezcaElTamao);
		
		textField = new JTextField();
		textField.setBounds(10, 38, 86, 20);
		panelPrincipal.add(textField);
		textField.setColumns(10);
		
		JButton btnGenerarArchivo = new JButton("Generar archivo");
		btnGenerarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File archivo=es.archivos.DialgoGuardarSinFiltro(new JFileChooser());
				try {
				FileWriter fw= new FileWriter(archivo.getAbsolutePath()); 
				System.out.println("Generando archivo espere...");
				for(int i=0;i<Integer.parseInt(textField.getText())*1024;i++)
				{
						try {
							Random random = new Random();
							fw.write(Integer.toString(random.nextInt(2)));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
				}
				fw.close();
				}catch(Exception ex) {}
				System.out.println("Archivo generado");
			}
		});
		btnGenerarArchivo.setBounds(312, 38, 162, 23);
		panelPrincipal.add(btnGenerarArchivo);
		
		
		
		
		
		JLabel lblKb = new JLabel("KB");
		lblKb.setBounds(104, 41, 46, 14);
		panelPrincipal.add(lblKb);
		
		frame.setVisible(true);
	}
}

