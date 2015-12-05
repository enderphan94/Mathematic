package ee.itcollege.math.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ee.itcollege.math.home.Contact;
import ee.itcollege.math.home.Fabonaci;
import ee.itcollege.math.home.PTB2UI;
import ee.itcollege.math.home.TheoryTabEquation;
import ee.itcollege.math.home.TheoryTabFibonacci;

public class ChoosePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	protected static final LayoutManager JPanel = null;

	public ChoosePanel() {
		functions();
		setVisible(true);

	}

	// Background
	public void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\Ender\\Desktop\\Group\\Test.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, null);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}

	public void functions() {

		this.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		this.add(pnNorth);
		ImageIcon header = new ImageIcon("head1.png");
		JLabel labeheader = new JLabel(header);
		pnNorth.add(labeheader);
		this.add(pnNorth, BorderLayout.NORTH);
		// South
		JPanel pnSouth = new JPanel();
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ret = JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		JButton btnContact = new JButton("Contact");
		btnContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Contact ct = new Contact();
				ct.setVisible(true);
			}
		});
		pnSouth.add(btnLogout);
		pnSouth.add(btnContact);
		this.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setBackground(Color.LIGHT_GRAY);

		// Center
		JPanel pnCenter = new JPanel();
		pnCenter.setOpaque(false);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		this.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		JLabel lbform = new JLabel("CHOOSE THE FUNCTIONS ");
		Font ff = new Font("arial", Font.BOLD, 17);
		lbform.setFont(ff);

		// Get button
		JButton button = new ButtonDesigned("Fibonacci");
		pnCenter.add(button);
		button.setBackground(Color.YELLOW);
		button.setBounds(50, 70, 145, 145);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fabonaci fa = new Fabonaci();
				fa.Processing();

			}
		});

		JButton button1 = new ButtonDesigned("Quadratic Equation");
		pnCenter.add(button1);
		button1.setBackground(Color.WHITE);
		button1.setBounds(360, 100, 145, 145);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PTB2UI pt = new PTB2UI("Quadratic Equation");
				pt.doShow();

			}
		});

		JButton button2 = new ButtonDesigned("Theory");
		pnCenter.add(button2);
		button2.setBackground(Color.cyan);
		button2.setBounds(150, 185, 90, 90);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TheoryTabEquation.doshow();

			}
		});

		JButton button3 = new ButtonDesigned("Theory");
		pnCenter.add(button3);
		button3.setBackground(Color.PINK);
		button3.setBounds(460, 40, 90, 90);

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TheoryTabFibonacci.doshowing();

			}
		});

		// form
		lbform.setForeground(Color.BLACK);
		lbform.setBounds(180, 20, 230, 25);
		pnCenter.add(lbform);
		// Button Designed

	}
}
