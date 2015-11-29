package Mainhome;

import javax.swing.SwingUtilities;

import login.ChoosePanel;
import login.ChooseWindow;
import login.LoginWindow;

public class Start implements Runnable {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Start());
	}
	
	@Override
	public void run() {
		new ChooseWindow().setVisible(true);
		
	}

}
