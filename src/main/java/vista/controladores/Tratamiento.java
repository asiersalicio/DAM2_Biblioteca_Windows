package vista.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
				convertir();
			}

			
		});
		
	}
	
	private void convertir() {
		String texto=textOrigen.getText();
		
		if (chckbxFormatear.isSelected())
		{
			texto=formatear(texto);
		}
		if(chckboxQuitarTildes.isSelected())
		{
			texto=quitarTildes(texto);
		}
		
		if(textFormat.getText().length()>0)
		{
			if(regex(texto))
			{
				lblFormatoValido.setVisible(true);
				lblFormatoNoValido.setVisible(false);
			}
			else
			{
				lblFormatoValido.setVisible(false);
				lblFormatoNoValido.setVisible(true);
			}
		}
		
		
		if(rbMayusculas.isSelected())
		{
			texto=mayusculas(texto);
		}
		else if(rbMinusculas.isSelected())
		{
			texto=minusculas(texto);
		}
		
		textDestino.setText(texto);
	}
	
	public String formatear(String texto)
	{
		texto=texto.trim();
		texto=texto.replace("\t", " ");
		texto=texto.replace("  ", " ");
		texto=texto.replace("\n", " ");
		return texto;
	}
	
	public String quitarTildes(String texto)
	{
		texto = texto.replace("á", "a");
		texto = texto.replace("é", "e");
		texto = texto.replace("í", "i");
		texto = texto.replace("ó", "o");
		texto = texto.replace("ú", "u");
		texto = texto.replace("ñ", "n");
		
		texto = texto.replace("Á", "A");
		texto = texto.replace("É", "E");
		texto = texto.replace("Í", "I");
		texto = texto.replace("Ó", "O");
		texto = texto.replace("Ú", "U");
		texto = texto.replace("Ñ", "N");
		
		return texto;
	}
	
	public String mayusculas(String texto)
	{
		return texto.toUpperCase();
	}
	
	public String minusculas(String texto)
	{
		return texto.toLowerCase();
	}
	
	public boolean regex(String texto)
	{
		try {
			return texto.matches(textFormat.getText());
		}
		catch(java.util.regex.PatternSyntaxException ex)
		{
			JOptionPane.showMessageDialog(null, "Formato regex no valido\nBorre o cambie el formato", "Formato regex no valido", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
}
