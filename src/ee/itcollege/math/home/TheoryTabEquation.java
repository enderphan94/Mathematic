package ee.itcollege.math.home;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TheoryTabEquation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TheoryTabEquation() {

		ImageIcon icon = new ImageIcon("java-swing-tutorial.JPG");
		JTabbedPane jtbExample = new JTabbedPane();
		JPanel jplInnerPanel1 = createInnerPanel("<html>" + "<br><h2>Qadratic Equation Theory</h2><br>"
				+ "A quadratic equation is a second-order polynomial equation in a single variable X<br>"
				+ "<br>ax\u00b2+bx+c=0<br>"

				+ "<br>where x represents an unknown, and a, b, and c represent known numbers such that a is not equal to 0<br>"
				+ "If a = 0, then the equation is linear, not quadratic. The numbers a, b, and c are the coefficients of the equation<br>"
				+ " and may be distinguished by calling them, respectively, the quadratic coefficient, the linear coefficient and the constant or free term<br>"
				+ "<br>Because the quadratic equation involves only one unknown, it is called univariate<br>"
				+ "The quadratic equation only contains powers of x that are non-negative integers, and therefore it is a polynomial equation<br>"
				+ "and in particular it is a second degree polynomial equation since the greatest power is two.<br>"
				+ "<br><br>" + "ax\u00b2+bx+c=0<br>" + "Z=b\u00b2 - 4ac<br>" + "<br>if a> 0"

				+ "<br> x1=(-b+&radic;Z)/2a" + "<br> x2=(-b-&radic;Z)/2a <br>  " + "<br>if a=0" + "<br> x1=x2=-c/b<br>"
				+ "<br>if Z is negative number<br> " + "The equation is no roots<br>"

				+ "<br>Quadratic equations can be solved by a process known in American English as factoring and <br>"
				+ "in other varieties of English as factorising<br> "
				+ "by completing the square, by using the quadratic formula, or by graphing.<br>"
				+ " Solutions to problems equivalent to the quadratic equation were known as early as 2000 BC.<br>"
				+ "<br><h3>Factoring by inspection</h3><br>"
				+ "It may be possible to express a quadratic equation ax2 + bx + c = 0 as a product (px + q)(rx + s) = 0.<br>"
				+ " In some cases, it is possible, by simple inspection, to determine values of p, q, r, and s that make the two forms equivalent to one another.<br> "
				+ "If the quadratic equation is written in the second form, then the Zero Factor Property states that the quadratic equation is satisfied if px + q = 0 or rx + s = 0.<br>"
				+ " Solving these two linear equations provides the roots of the quadratic.<br>"
				+ "For most students, factoring by inspection is the first method of solving quadratic equations to which they are exposed.<br>"
				+ " If one is given a quadratic equation in the form x2 + bx + c = 0, the sought factorization has the form (x + q)(x + s), <br>"
				+ "nd one has to find two numbers q and s that add up to b and whose product is c (this is sometimes called Vieta rule and is related to Vieta's formulas)<br>"
				+ "As an example, x2 + 5x + 6 factors as (x + 3)(x + 2).The more general case where a does not equal 1 can require a considerable effort in trial and error guess-and-check,<br>"
				+ "assuming that it can be factored at all by inspection <br>"
				+ "Except for special cases such as where b = 0 or c = 0, factoring by inspection only works for quadratic equations that have rational roots.<br>"
				+ " This means that the great majority of quadratic equations that arise in practical applications cannot be solved by factoring by inspection"

				+ "</html>");
		jtbExample.addTab("Theory", new JScrollPane(jplInnerPanel1));
		JLabel lbpanel1 = new JLabel();
		// lbpanel1.setText();

		jplInnerPanel1.add(lbpanel1);
		jtbExample.setSelectedIndex(0);

		JPanel jplInnerPanel2 = createInnerPanel("You can use to note here!");
		jtbExample.addTab("Note Pad", icon, jplInnerPanel2);
		JTextField txtpn2 = new JTextField();
		jplInnerPanel2.add(txtpn2);
		// Add the tabbed pane to this panel.

		setLayout(new GridLayout(1, 1));
		jplInnerPanel1.setLocation(10, 10);
		add(jtbExample);

	}

	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}

	public static void doshow() {
		JFrame frame = new JFrame("Theory of Quadratic Equation");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(new TheoryTabEquation(), BorderLayout.CENTER);
		frame.setSize(750, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		doshow();
	}
}
