package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;



public class LoginWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public LoginWindow() {
		super("Login");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				BufferedImage img = null;
				System.out.println("paint");
				try {
					img = ImageIO.read(new File("C:\\Users\\Ender\\Desktop\\Group\\ground.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(img, 0, 0, null);
				//super.paint(g);
			}
		};
		add(panel);
		placeComponents(panel);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("Email         :");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(30, 80, 80, 25);
		panel.add(loginButton);
		
		

		// login
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				String usern = userText.getText();

				if (usern.trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Please Enter Username");

					userText.selectAll();

					userText.requestFocus();

					return;

				}
				//Using Regular Expression 
				 StringBuilder regex = new StringBuilder();
			        regex.append("^");
			        regex.append("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			        regex.append("$");
			        Pattern pattern = Pattern.compile(regex.toString());
			        Matcher matcher = pattern.matcher(usern);
			        boolean valid = matcher.matches();
			        if (valid) {
			        	JOptionPane.showMessageDialog(null, "You have loged in successfully");
			        } else {
			        	JOptionPane.showMessageDialog(null, "Email is invalid");
			        	return;
			        }
			    //Password check
			    
				@SuppressWarnings("deprecation")
				String passw = passwordText.getText();
				String hash = DigestUtils.shaHex(passw);
				if (passw.trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Please Enter Password");

					passwordText.selectAll();

					passwordText.requestFocus();
 
					return;

				}
				
			//Get User Information
				try {
					  File out = new File("/users/Ender/Desktop/GetUser/InputUser.txt");
					 if (!out.exists()) {
		                    out.createNewFile();
		                }
					
					  FileWriter fw = new FileWriter(out.getAbsoluteFile());
		                BufferedWriter bw = new BufferedWriter(fw);
		                bw.write(usern+ "\t" + hash);    
		                bw.close();

		                System.out.println("Done");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ChooseWindow ptb = new ChooseWindow();
				ptb.setVisible(true);
				LoginWindow.this.dispose();
			}
		});
		//EXIT
		JButton btnregis = new JButton("Sign up");
		btnregis.setBounds(150, 80, 100, 25);
		panel.add(btnregis);
		btnregis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Register rg = new Register();
				rg.setVisible(true);

			}
		});
	}

}