package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EditorTablas {

	private JFrame frame;
	private JPanel pane;
	
	public EditorTablas()
	{
		frame = new JFrame();
		frame.setSize(800,800);
		pane = new JPanel();
		frame.add(pane);
	}
	
	public void Mostrar()
	{
		frame.setVisible(true);
	}
}
