package ee.itcollege.math.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ee.itcollege.math.home.Contact;
import ee.itcollege.math.home.Fabonaci;
import ee.itcollege.math.home.PTB2UI;

public class ChooseWindow extends JFrame {

	public ChooseWindow() {

		setTitle("Welcome to mathematic calculation");
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		createMenuBar();
		setContentPane(new ChoosePanel());
		setResizable(true);
		setVisible(true);
	
	}
	
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
        //Fibonacci
        JMenuItem fibItem = new JMenuItem("Fibonacci");
        fibItem .setMnemonic(KeyEvent.VK_F);
        fibItem .addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fabonaci fib= new Fabonaci();
				fib.setVisible(true);
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
        func.add(fibItem);
        file.add(eMenuItem);
        menubar.add(file);
        menubar.add(func);

        setJMenuBar(menubar);
    }
	
}
