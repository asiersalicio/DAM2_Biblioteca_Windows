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
		texto = texto.replace("�", "a");
		texto = texto.replace("�", "e");
		texto = texto.replace("�", "i");
		texto = texto.replace("�", "o");
		texto = texto.replace("�", "u");
		texto = texto.replace("�", "n");
		
		texto = texto.replace("�", "A");
		texto = texto.replace("�", "E");
		texto = texto.replace("�", "I");
		texto = texto.replace("�", "O");
		texto = texto.replace("�", "U");
		texto = texto.replace("�", "N");
		
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
