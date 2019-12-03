package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.graficos.G_Tratamiento;

public class Tratamiento extends G_Tratamiento {

	public Tratamiento()
	{
		anadirListeners();
		frame.setVisible(true);
	}

	private void anadirListeners() {
		
		btnConvertir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	}
	
}
