package ee.itcollege.math.home;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ee.itcollege.math.graphics.GraphicsWindow;

//import loc.graphics.GraphicsContent;


public class PTB2UI extends JFrame {
	private static final long serialVersionUID = 1L;

	double a = 0, b = 0, c = 0;

	public PTB2UI(String title) {

		setTitle(title);

	}
	public void doShow() {

		setSize(400, 300);

		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("quadra.jpg")).getImage());

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		addControl();

		setResizable(false);

		setVisible(true);

	}

	public void addControl()
	{
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		
		//North
		this.add(pnNorth);
		JLabel lblTitle = new JLabel("Quadratic Equation");
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		lblTitle.setForeground(Color.BLUE);
		Font ft = new Font("arial", Font.BOLD, 25);
		lblTitle.setFont(ft);
		JPanel pnSouth = new JPanel();
		JButton btnGiai = new JButton("Solve");
		JButton btnXoa = new JButton("Reset");
		JButton btnline = new JButton("Show Chart");

		pnSouth.add(btnGiai);
		pnSouth.add(btnline);
		pnSouth.add(btnXoa);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setBackground(Color.LIGHT_GRAY);

		Border southborder = BorderFactory.createLineBorder(Color.RED);

		TitledBorder southTitleBorder = new TitledBorder(southborder, "Chose functions");

		pnSouth.setBorder(southTitleBorder);

		JPanel pnCenter = new JPanel();

		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		pnBorder.add(pnCenter, BorderLayout.CENTER);

		Border centerborder = BorderFactory.createLineBorder(Color.RED);

		TitledBorder centerTitleBorder =

		new TitledBorder(centerborder, "  Format: ax\u00b2+bx+c=0   ||    Enter a - b- c:   ");

		pnCenter.setBorder(centerTitleBorder);

		JPanel pna = new JPanel();

		JLabel lbla = new JLabel("Enter a:");

		final JTextField txta = new JTextField(15);

		pna.add(lbla);

		pna.add(txta);

		pnCenter.add(pna);

		JPanel pnb = new JPanel();

		JLabel lblb = new JLabel("Enter b:");

		final JTextField txtb = new JTextField(15);

		pnb.add(lblb);

		pnb.add(txtb);

		pnCenter.add(pnb);

		JPanel pnc = new JPanel();

		JLabel lblc = new JLabel("Enter c:");

		final JTextField txtc = new JTextField(15);

		pnc.add(lblc);

		pnc.add(txtc);

		pnCenter.add(pnc);

		JPanel pnkq = new JPanel();

		JLabel lblkq = new JLabel("Roots here:");

		final JTextField txtkq = new JTextField(15);

		pnkq.add(lblkq);

		pnkq.add(txtkq);

		pnCenter.add(pnkq);

		lbla.setPreferredSize(lblkq.getPreferredSize());

		lblb.setPreferredSize(lblkq.getPreferredSize());

		lblc.setPreferredSize(lblkq.getPreferredSize());


		btnXoa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				txtb.setText("");

				txtc.setText("");

				txtkq.setText("");

				txta.requestFocus();

			}

		});

		// SOLVE
		btnGiai.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String sa = txta.getText();

				try

				{

					a = Double.parseDouble(sa);
				}

				catch (Exception ex)

				{

					JOptionPane.showMessageDialog(null, "Can not find this format");

					txta.selectAll();

					txta.requestFocus();

					return;

				}

				String sb = txtb.getText();
				try
				{
					b = Double.parseDouble(sb);
				}
				catch (Exception ex)

				{

					JOptionPane.showMessageDialog(null, "Can not find this format!");

					txtb.selectAll();

					txtb.requestFocus();

					return;

				}

				String sc = txtc.getText();

				try

				{

					c = Double.parseDouble(sc);

				}

				catch (Exception ex)

				{

					JOptionPane.showMessageDialog(null, "Can not find this format!");

					txtc.selectAll();

					txtc.requestFocus();

					return;

				}

				JFrame frame = new JFrame("Processing....");

				ImageIcon loading = new ImageIcon("load.gif");
				frame.add(new JLabel("", loading, JLabel.CENTER));
				frame.setIconImage(new ImageIcon(getClass().getResource("loading.png")).getImage());
				frame.setSize(400, 350);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						PTB2Engine engine = new PTB2Engine(a, b, c);

						String kq = engine.compute();

						txtkq.setText(kq);
						frame.setVisible(false);
					}
				});
				thread.start();

				btnline.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						new GraphicsWindow(a, b, c);
					}

				});
			}

		});

		Container con = getContentPane();
		con.add(pnBorder);
	}
	public static void main(String[] args) {

		PTB2UI ui = new PTB2UI("Quadratic by Ender Phan");

		ui.doShow();

	}

}
