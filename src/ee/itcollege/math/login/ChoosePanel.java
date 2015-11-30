package ee.itcollege.math.login;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ee.itcollege.math.home.Contact;
import ee.itcollege.math.home.PTB2UI;

public class ChoosePanel extends JPanel {

	private static final long serialVersionUID = 1L;


	public ChoosePanel() {


		functions();
		
		
		setVisible(true);
	}
	
	//Background
	public void paintComponent(Graphics g) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\Ender\\Desktop\\Group\\water.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, null);
		//super.paint(g);
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}
	
	public void functions() {
//		JPanel pnBorder = new JPanel();
		this.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();		
		this.add(pnNorth);
		JLabel lblTitle = new JLabel("WELCOME TO MATHEMATIC CALCULATION");
		lblTitle.setOpaque(false);
		pnNorth.add(lblTitle);
		this.add(pnNorth, BorderLayout.NORTH);
		lblTitle.setForeground(Color.BLACK);
		Font ft = new Font("arial", Font.BOLD, 25);
		lblTitle.setFont(ft);
		
		
		//South
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
					Contact ct= new Contact();
					ct.setVisible(true);
			}
		});
		pnSouth.add(btnLogout);
		pnSouth.add(btnContact);
		this.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setBackground(Color.LIGHT_GRAY);
		Border southborder = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder southTitleBorder = new TitledBorder(southborder, "! Helps");
		southTitleBorder.setTitleColor(Color.red);
		pnSouth.setBorder(southTitleBorder);
		
		//Center
		JPanel pnCenter = new JPanel();
		pnCenter.setOpaque(false);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		this.add(pnCenter, BorderLayout.CENTER);
		Border centerborder = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder centerTitleBorder = new TitledBorder(centerborder, "  Choose the functions :   ");
		centerTitleBorder.setTitleColor(Color.red);
		pnCenter.setBorder(centerTitleBorder);
		pnCenter.setLayout(null);
		
		JLabel lbform = new JLabel("   Quadratic Equation: ");
		Font ff = new Font("arial", Font.BOLD, 15);
		lbform.setFont(ff);
		lbform.setForeground(Color.BLACK);
		lbform .setBounds(20, 40, 230, 25);
		pnCenter.add(lbform );
		
		
	}
	
	//MENUBAR
	

}
