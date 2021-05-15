import javax.swing.*; //JFrame, Timer, JPanel
import java.awt.*;

public class CrearPantalla extends JPanel
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Pantalla.flappyBirdMan.repaint(g);
	}

	
	
}
