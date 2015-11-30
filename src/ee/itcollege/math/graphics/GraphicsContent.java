package ee.itcollege.math.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class GraphicsContent extends JPanel {
	
	double a, b, c;
	
	public GraphicsContent(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.gray);
		
		g.drawLine(0, GraphicsWindow.GRAPHICS_WIDTH / 2,  GraphicsWindow.GRAPHICS_WIDTH, GraphicsWindow.GRAPHICS_WIDTH / 2);
		g.drawLine(GraphicsWindow.GRAPHICS_WIDTH / 2, 0,  GraphicsWindow.GRAPHICS_WIDTH / 2, GraphicsWindow.GRAPHICS_WIDTH);
		
		g.setColor(Color.black);
		
		Point lastPoint = null;
		
		for (double x = -GraphicsWindow.GRAPHICS_WIDTH / 2; x < GraphicsWindow.GRAPHICS_WIDTH / 2; x++) {
			double y = a * x * x + b * x + c;
			
			if (lastPoint != null) {
				g.drawLine((int)x, (int)y, (int)lastPoint.getX(), (int)lastPoint.getY());
			}
			//		g.fillRect((int)x + GraphicsWindow.GRAPHICS_WIDTH / 2, (int)-y + GraphicsWindow.GRAPHICS_WIDTH / 2, 3, 3);
			
			lastPoint = new Point((int)x, (int)y);
		}				
	}
}

