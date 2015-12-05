package ee.itcollege.math.home;

import javax.swing.SwingUtilities;


import ee.itcollege.math.login.LoginWindow;

public class Start implements Runnable {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Start());
	}
	
	@Override
	public void run() {
		new LoginWindow().setVisible(true);
		
	}

}
