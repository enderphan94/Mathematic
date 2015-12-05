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

public class TheoryTabFibonacci extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TheoryTabFibonacci(){
		
		ImageIcon icon = new ImageIcon("java-swing-tutorial.JPG");
		JTabbedPane jtbExample = new JTabbedPane();
		JPanel jplInnerPanel1 = createInnerPanel("<html>"
	            + "<br><h2>Fibonacci number Theory</h2><br>"
	            +"In mathematics, the Fibonacci numbers or Fibonacci sequence are the numbers in the following integer sequence:<br>"
	            +"<br>1, 1, 2, 5, 8, 13, 21, 34, 66, 89, 144"  
	           
	           +"<br>or often in modern usage<br>"
	           + "0, 1, 1, 2, 5, 8, 13, 21, 34, 66, 89, 144<br>"
	           +"By definition, the first two numbers in the Fibonacci sequence are either 1 and 1, or 0 and 1<br>"
	           + "<br>epending on the chosen starting point of the sequence, and each subsequent number is the sum of the previous two.<br>"
	            +"In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation<br>" 
	           +" F(n)= F(n-1)+F(n-2)<br>" 
	           +"<br><br>"
	           +"with seed values<br>" 
	           +"F1=1<br>"
	           +"<br>F2=1"
	              

	            +"<br>The Fibonacci sequence is named after Italian mathematician Fibonacci.<br> "
	            + "His 1202 book Liber Abaci introduced the sequence to Western European mathematics, <br>"
	            + "although the sequence had been described earlier in Indian mathematics<br> "
	            + "By modern convention, the sequence begins either with F0 = 0 or with F1 = 1. The Liber Abaci began the sequence with F1 = 1.<br>"
	            

	            + "</html>");
		jtbExample.addTab("Theory", new JScrollPane(jplInnerPanel1));
		JLabel lbpanel1 =new JLabel();
		//lbpanel1.setText();
		
		 jplInnerPanel1.add(lbpanel1);
		jtbExample.setSelectedIndex(0);
		
		JPanel jplInnerPanel2 = createInnerPanel("You can use to note here!");
		jtbExample.addTab("Note Pad", icon, jplInnerPanel2);
		JTextField txtpn2= new JTextField();
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
		
	public static void doshowing(){
		JFrame frames = new JFrame("Theory of Fibonacci Number");
		frames.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frames.getContentPane().add(new TheoryTabFibonacci(),BorderLayout.CENTER);
		frames.setSize(750, 700);
		frames.setLocationRelativeTo(null);
		frames.setVisible(true);
	}
	public static void main(String[] args) {
		doshowing();
	}
	}
