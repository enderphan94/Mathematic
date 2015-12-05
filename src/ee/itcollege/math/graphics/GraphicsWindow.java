package ee.itcollege.math.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsWindow extends JFrame {
	
	public static final int GRAPHICS_WIDTH = 500;

	
	public GraphicsWindow(double a, double b, double c) {
		super("Investigation Chart");
		setIconImage(new ImageIcon(getClass().getResource("chart.png")).getImage());
		setContentPane(new GraphicsContent(a, b, c));
		setSize(GRAPHICS_WIDTH, GRAPHICS_WIDTH);
		setVisible(true);
	}
	

}
