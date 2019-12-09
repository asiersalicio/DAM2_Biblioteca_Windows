package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import vista.graficos.G_EditarAtributos;

public class EditarAtributos extends G_EditarAtributos {

	File file;
	
	public EditarAtributos(File file)
	{
		
		this.file=file;
		
		AnadirListeners();
		
		frame.setVisible(true);
	}

	private void AnadirListeners() {
		
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEjecutable.isSelected())
				{
					file.setExecutable(true);
				}
				else
				{
					file.setExecutable(false);
				}
				if(rdbtnEscritura.isSelected())
				{
					file.setWritable(true);
				}
				else
				{
					file.setWritable(false);
				}
				if(rdbtnLectura.isSelected())
				{
					file.setReadable(true);
				}
				else
				{
					file.setReadable(false);
				}
				
			}
		});
		
	}
	
}
