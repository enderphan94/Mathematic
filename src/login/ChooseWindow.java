package login;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

import Mainhome.Contact;
import Mainhome.PTB2UI;

public class ChooseWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public ChooseWindow() {

		setTitle("Welcome to mathematic calculation");
		setSize(600, 600);
		setLocationRelativeTo(null);
		/*
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\Users\\Ender\\Desktop\\Group\\back.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		setContentPane(new JLabel(imageIcon));
	*/
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(true);

		functions();
		createMenuBar();
		
		setVisible(true);
	}
	
	

	public void functions() {
		
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();

		this.add(pnNorth);

		JLabel lblTitle = new JLabel("WELCOME TO MATHEMATIC CALCULATION");

		pnNorth.add(lblTitle);

		pnBorder.add(pnNorth, BorderLayout.NORTH);

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

		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		pnSouth.setBackground(Color.LIGHT_GRAY);

		Border southborder = BorderFactory.createLineBorder(Color.BLUE);

		TitledBorder southTitleBorder =

		new TitledBorder(southborder, "! Helps");

		pnSouth.setBorder(southTitleBorder);

		JPanel pnCenter = new JPanel();

		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Border centerborder = BorderFactory.createLineBorder(Color.BLUE);

		TitledBorder centerTitleBorder = new TitledBorder(centerborder, "  Choose the functions :   ");

		pnCenter.setBorder(centerTitleBorder);
		
		Container con = getContentPane();

		con.add(pnBorder);
		
	}
	
	//MENUBAR
	private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("exit.png");

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        JMenu func = new JMenu("Functions");
        func.setMnemonic(KeyEvent.VK_T);
        //Quadratic
        JMenuItem equaItem = new JMenuItem("Quadratic equation");
        equaItem.setMnemonic(KeyEvent.VK_Q);
        equaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PTB2UI pt= new PTB2UI("title");
				pt.doShow();
				
			}
		});
        //COntact
        ImageIcon icontact = new ImageIcon("ct.jpg");
        JMenuItem contact= new JMenuItem("Contact", icontact);
        contact.setMnemonic(KeyEvent.VK_C);
        contact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Contact ct= new Contact();
				ct.setVisible(true);
				// TODO Auto-generated method stub
				
			}
		});
        //EXIT
        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        file.add(contact);
        func.add(equaItem);
        file.add(eMenuItem);
        menubar.add(file);
        menubar.add(func);

        setJMenuBar(menubar);
    }

}
