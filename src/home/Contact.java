package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Contact extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Contact() {

		setTitle("Contact us");
		setSize(450, 450);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Content();
		setResizable(false);
	}
	
	public void Content(){
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();

		this.add(pnNorth);

		pnBorder.add(pnNorth, BorderLayout.NORTH);
	
		ImageIcon contact = new ImageIcon("put.gif");
		JLabel label1 = new JLabel(contact);
		pnNorth.add(label1);
		
		//South
		JTextField txtcomment = new JTextField("Write here!!",100);
		txtcomment.setHorizontalAlignment(JTextField.LEFT);
		txtcomment.setSize(300, 200);
		JPanel pnSouth = new JPanel();
        	//Button send the feedback
		JButton btnContact = new JButton("Send");
		 final JFrame frame = new JFrame();
		btnContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(frame.getComponent(0), "<html>Your feedback has been sent to admin <br><br>"
				 		+ "<i>Thank you for choosing my application</i><br><br>"
				 		+ "Ender Phan</html>");
					//get Feedback
				 String comment = txtcomment.getText();
					try {
						  File out = new File("/users/Ender/Desktop/GetUser/Feedback.txt");
						 if (!out.exists()) {
			                    out.createNewFile();
			                }
						
						  FileWriter fw = new FileWriter(out.getAbsoluteFile());
			                BufferedWriter bw = new BufferedWriter(fw);
			                bw.write(comment);    
			                bw.close();

			                System.out.println("Done");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

		});

		pnSouth.add(btnContact);

		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		pnSouth.setBackground(Color.LIGHT_GRAY);

		Border southborder = BorderFactory.createLineBorder(Color.BLUE);


		//CENTER
		JPanel pnCenter = new JPanel(new GridLayout());

		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Border centerborder = BorderFactory.createLineBorder(Color.BLUE);

		TitledBorder centerTitleBorder = new TitledBorder(centerborder, "  My information :   ");
		centerTitleBorder.setTitleColor(Color.red);
		JLabel labelinfo = new JLabel("My label");

		labelinfo.setText("<html><br>This application made by Ender Phan<br>"
				+ "E-mail: enderlocphan@gmail.com<br> "
				+ "Tel: +372 5911 1421 <br>"
				+ "Cyber Security Engineering - Estonian Information Technology College <br><br></html>");
		pnCenter.add(labelinfo);
		//Feedback
		JLabel lbwrite = new JLabel("You can write your feedback here: ");
		pnCenter.add(lbwrite);
		
		pnCenter.add(txtcomment,BorderLayout.CENTER);
		pnCenter.setBorder(centerTitleBorder);
		
		//Button Feedback
		//GridBagConstraints gbc = new GridBagConstraints();
		//gbc.insets = new Insets(20,20,100,100);
		
		Container con = getContentPane();
		
		con.add(pnBorder);
	}
	public void Commt(){
		
	}

}
