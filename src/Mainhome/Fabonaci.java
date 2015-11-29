package Mainhome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Fabonaci extends JFrame {

	private static final long serialVersionUID = 1L;
	public Fabonaci(){
		setVisible(true);
	
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		Processing();
		
		
	}
	
	public void Processing(){
		//North
		this.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		this.add(pnNorth);
		JLabel lblTitle = new JLabel("Fibonacci Calculation ");
		lblTitle.setOpaque(false);
		pnNorth.add(lblTitle);
		this.add(pnNorth, BorderLayout.NORTH);
		lblTitle.setForeground(Color.RED);
		Font ft = new Font("arial", Font.BOLD, 25);
		lblTitle.setFont(ft);
		// South

		JPanel pnSouth = new JPanel();
		JButton btnsolve = new JButton("Solve");
		final JFrame frame = new JFrame();
		pnSouth.add(btnsolve);
		this.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setBackground(Color.BLACK);
		Border southborder = BorderFactory.createLineBorder(Color.BLACK);
		
		//Center
		JPanel pnCenter = new JPanel();
		pnCenter.setOpaque(false);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		this.add(pnCenter, BorderLayout.CENTER);
		Border centerborder = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder centerTitleBorder = new TitledBorder(centerborder, "");
		pnCenter.setBorder(centerTitleBorder);
		pnCenter.setOpaque(false);
		
		//SetInput and OUtput
		pnCenter.setLayout(null);
		JLabel lbform = new JLabel("             F(n)= F(n-1)+F(n-2)");
		Font ff = new Font("arial", Font.BOLD, 15);
		lbform.setFont(ff);
		lbform .setBounds(70, 20, 230, 25);
		pnCenter.add(lbform );
		
		JLabel lbn = new JLabel("Enter  n :");
		lbn.setBounds(70, 70, 150, 25);
		pnCenter.add(lbn);
		
		JTextField txtn = new JTextField(20);
		txtn.setBounds(140, 70, 160, 25);
		
		pnCenter.add(txtn);
		
		JLabel lbresult = new JLabel("The Fabonacci Value is   :");
		lbresult.setBounds(70, 110, 230, 25);
		pnCenter.add(lbresult);

		JTextField txtresult = new JTextField(10);
		txtresult.setBounds(220, 110, 80, 25);
		pnCenter.add(txtresult);
		
		
		btnsolve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			     String inputn = txtn.getText();
			     long number= Integer.parseInt(inputn);
			     long egine;
			     egine = FibonacEngine.fib(number);
			     txtresult.setText(""+egine);
			    
			}
		});;
		KeyListener enterLogin = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_ENTER == e.getKeyCode()) {
					 String inputn = txtn.getText();
				     long number= Integer.parseInt(inputn);
				     long egine;
				     egine = FibonacEngine.fib(number);
				     txtresult.setText(""+egine);
				}
			}
		};
		txtn.addKeyListener(enterLogin);
		
		
	}
	
	
	public static void main(String[] args) {

		Fabonaci fa = new Fabonaci();
		fa.Processing();

	}

}
