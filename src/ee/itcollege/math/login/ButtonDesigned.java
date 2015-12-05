package ee.itcollege.math.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonDesigned extends JButton {

	private static final long serialVersionUID = 1L;

	public ButtonDesigned(String label) {
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}

	Shape shape;

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

	public static void main(String[] args) {
		JButton button = new ButtonDesigned("click");
		JButton button1 = new ButtonDesigned("click");
		JButton button2 = new ButtonDesigned("click");
		JButton button3 = new ButtonDesigned("click");

		button.setBackground(Color.red);
		JFrame frame = new JFrame();
		frame.getContentPane().add(button);
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		frame.getContentPane().setLayout(null);
		button.setBounds(50, 50, 100, 100);
		button1.setBounds(10, 10, 100, 100);
		button2.setBounds(70, 10, 100, 100);
		button3.setBounds(90, 10, 100, 100);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
