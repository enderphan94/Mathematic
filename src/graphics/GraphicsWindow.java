package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsWindow extends JFrame {
	
	public static final int GRAPHICS_WIDTH = 500;

	
	public GraphicsWindow(double a, double b, double c) {
		super("Investigation Chart");
		
		setContentPane(new GraphicsContent(a, b, c));
		setSize(GRAPHICS_WIDTH, GRAPHICS_WIDTH);
		setVisible(true);
	}
	

}
