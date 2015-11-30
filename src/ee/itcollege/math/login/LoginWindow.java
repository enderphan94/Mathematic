package ee.itcollege.math.login;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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

public class LoginWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public LoginWindow() {
		super("Login");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("C:\\Users\\Ender\\Desktop\\Group\\ground.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(img, 0, 0, null);
			}
		};
		add(panel);
		placeComponents(panel);

		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	JLabel userLabel = new JLabel("Email         :");
	JTextField userText = new JTextField(20);
	JLabel passwordLabel = new JLabel("Password :");
	JPasswordField passwordText = new JPasswordField(20);
	JButton loginButton = new JButton("login");
	
	private boolean checkPassword(String username, String hashp) {
		try {
			FileReader inFile = new FileReader("/users/Ender/Desktop/GetUser/submit.txt");

			BufferedReader inStream = new BufferedReader(inFile);

			String line;

			while ((line = inStream.readLine()) != null) {
				String[] words = line.split("\t");
				System.out.println("debugging: " + Arrays.toString(words));
				if (username.equals(words[0]) && hashp.equals(words[1])) {
					inStream.close();
					return true;
				}
			
			}
			inStream.close();

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		KeyListener enterLogin = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_ENTER == e.getKeyCode()) {
					doLogin();
				}
			}
		};

		passwordText.setBounds(100, 40, 160, 25);
		passwordText.addKeyListener(enterLogin);
		panel.add(passwordText);

		loginButton.setBounds(30, 80, 80, 25);
		loginButton.addKeyListener(enterLogin);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doLogin();
			}
		});
		panel.add(loginButton);

		// login

		// EXIT
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

	private void doLogin() {
		String usern = userText.getText();
		

		if (usern.trim().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Please Enter Username");

			userText.selectAll();

			userText.requestFocus();

			return;

		}
		// Using Regular Expression
		StringBuilder regex = new StringBuilder();
		regex.append("^");
		regex.append("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		regex.append("$");
		Pattern pattern = Pattern.compile(regex.toString());
		Matcher matcher = pattern.matcher(usern);
		boolean valid = matcher.matches();
		if (!valid) {
			JOptionPane.showMessageDialog(null, "Email is invalid");
			return;
		}
		// Password check

		@SuppressWarnings("deprecation")
		String passw = passwordText.getText();
		String hash = DigestUtils.shaHex(passw);
		if (passw.trim().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Please Enter Password");

			passwordText.selectAll();

			passwordText.requestFocus();

			return;

		}
		
		if (checkPassword(usern, hash)) {
			System.out.println("Logged in!");
			ChooseWindow ptb = new ChooseWindow();
			ptb.setVisible(true);
			LoginWindow.this.dispose();
			JOptionPane.showMessageDialog(null, "Welcome \t"+usern+ "\t to Math Application");
		} else {
			JOptionPane.showMessageDialog(null, "You need to sign an new account");
		}
		
		

	}

}