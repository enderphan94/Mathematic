package Mainhome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
 
public class Tab extends JFrame {
     
    public Tab() {
         
        setTitle("Tabbed Pane");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel(); 
        JLabel label1 = new JLabel();
        label1.setText("You are in area of Tab1");
        JLabel label2 = new JLabel();
        label2.setText("You are in area of Tab2");
        
        JButton btn1= new JButton("Click to change");
        jp1.add(btn1);
        btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 JPanel jp2 = new JPanel();  
		            //panel4.setLayout(null);
				 jp2.add(new JLabel("welcome buddy"));
				jtp.addTab("Tab2", jp2);
				
			}
		});
        jp1.add(label1);
        jp2.add(label2);
        jtp.addTab("Tab1", jp1);
       
         
    }
    public static void main(String[] args) {
         
        Tab tp = new Tab();
        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.setVisible(true);
         
    }
}
