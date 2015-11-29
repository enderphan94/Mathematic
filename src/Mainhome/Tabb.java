package Mainhome;

import java.awt.Color;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
/**
 * ----------------- @author nguyenvanquan7826 -----------------
 * ---------------nguyenvanquan7826.wordpress.com --------------
 */
public class Tabb extends JFrame {
 
        panel1 = new JPanel();
        panel1.setLayout(null);

        JLabel label1 = new JLabel("Username:");
        label1.setBounds(10, 15, 150, 20);
        panel1.add(label1);

        JTextField field = new JTextField();
        field.setBounds(10, 35, 150, 20);
        panel1.add(field);

        JLabel label2 = new JLabel("Password:");
        label2.setBounds(10, 60, 150, 20);
        panel1.add(label2);

        JPasswordField fieldPass = new JPasswordField();
        fieldPass.setBounds(10, 80, 150, 20);
        panel1.add(fieldPass);

         JButton login=new JButton("login");
         login.setBounds(10, 120, 80, 25);
         panel1.add(login);

         login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            panel4=new JPanel();    
            //panel4.setLayout(null);
            panel4.add(new JLabel("welcome buddy"));
            tabbedPane.addTab("Page 4", panel4);
            }
        });
    }
}
