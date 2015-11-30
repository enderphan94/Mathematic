package ee.itcollege.math.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

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
		
		g.setColor(Color.BLACK);
		((Graphics2D)g).setStroke(new BasicStroke(10));
		for (double x = -GraphicsWindow.GRAPHICS_WIDTH / 2; x < GraphicsWindow.GRAPHICS_WIDTH / 2; x++) {
			double y = a * x * x + b * x + c;
			
			int newX = (int) (x + GraphicsWindow.GRAPHICS_WIDTH / 2);
			int newY = (int) (-y + GraphicsWindow.GRAPHICS_WIDTH / 2);
			
			if (lastPoint != null) {
				g.drawLine((int)newX, (int)newY, (int)lastPoint.getX(), (int)lastPoint.getY());
			}
			
			
			lastPoint = new Point((int)newX, (int)newY);
		}
		
		// points
		g.setColor(Color.red);
		for (double x = -GraphicsWindow.GRAPHICS_WIDTH / 2; x < GraphicsWindow.GRAPHICS_WIDTH / 2; x++) {
			double y = a * x * x + b * x + c;
			g.fillOval((int)x + GraphicsWindow.GRAPHICS_WIDTH / 2 - 2, (int)-y + GraphicsWindow.GRAPHICS_WIDTH / 2 - 2, 4, 4);
		}	
	}
}

