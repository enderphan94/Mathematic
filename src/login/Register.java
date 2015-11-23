package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Mainhome.Contact;

public class Register extends JFrame{
	private static final long serialVersionUID = 1L;


	public Register() {
		setTitle("Regiteration Form");
		setSize(400, 350);
		setLocationRelativeTo(null);
		Signup();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		setResizable(false);
	}
	
public void Signup() {
		
//		JPanel pnBorder = new JPanel();
		this.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		
		this.add(pnNorth);

		JLabel lblTitle = new JLabel("Enter Your Information ");
		lblTitle.setOpaque(false);

		pnNorth.add(lblTitle);

		this.add(pnNorth, BorderLayout.NORTH);

		lblTitle.setForeground(Color.BLACK);

		Font ft = new Font("arial", Font.BOLD, 20);

		lblTitle.setFont(ft);
		//South

		JPanel pnSouth = new JPanel();
		
		JButton btnsubmit = new JButton("Submit");
		final JFrame frame =new JFrame();
		
		btnsubmit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				 JOptionPane.showMessageDialog(frame.getComponent(0), "Congratulation, You got an new account!!");
				 Register.this.dispose();
			}
		});
	
		pnSouth.add(btnsubmit);
		this.add(pnSouth, BorderLayout.SOUTH);

		pnSouth.setBackground(Color.BLACK);

		Border southborder = BorderFactory.createLineBorder(Color.BLACK);

		JPanel pnCenter = new JPanel();
		pnCenter.setOpaque(false);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		this.add(pnCenter, BorderLayout.CENTER);

		Border centerborder = BorderFactory.createLineBorder(Color.BLACK);

		TitledBorder centerTitleBorder = new TitledBorder(centerborder, " Registeration Form :   ");

		pnCenter.setBorder(centerTitleBorder);
		//Input
		pnCenter.setLayout(null);
		JLabel lbname = new JLabel("Full name   :");
		lbname .setBounds(50, 50, 80, 25);
		pnCenter.add(lbname );
		
		JTextField nameText = new JTextField(20);
		nameText.setBounds(140, 50, 160, 25);
		pnCenter.add(nameText);
		
		JLabel lbage = new JLabel("Your age   :");
		lbage.setBounds(50, 80, 160, 25);
		pnCenter.add(lbage);
		
		JTextField ageText = new JTextField(20);
		ageText .setBounds(140, 80, 160, 25);
		pnCenter.add(ageText );
		
		JLabel userLabel = new JLabel("Your Email   :");
		userLabel.setBounds(50, 110, 80, 25);
		pnCenter.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(140, 110, 160, 25);
		pnCenter.add(userText);

		JLabel passwordLabel = new JLabel("Password  :");
		passwordLabel.setBounds(50, 140, 80, 25);
		pnCenter.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(140, 140, 160, 25);
		pnCenter.add(passwordText);
		
		JLabel lbpasscf = new JLabel("Confirm Password  :");
		lbpasscf.setBounds(50, 170, 170, 25);
		pnCenter.add(lbpasscf);

		JPasswordField passcfText = new JPasswordField(20);
		passcfText.setBounds(180, 170, 160, 25);
		pnCenter.add(passcfText);
		
		
	}
}
