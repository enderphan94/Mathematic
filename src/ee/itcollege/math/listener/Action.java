package ee.itcollege.math.listener;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
class Action extends JFrame
{
      Container container = getContentPane();
      public Action(String title)
      {
        super(title);
        Button button = new Button("My button");
        EventQuit eventQuit=new EventQuit();
        button.addActionListener(eventQuit);
        container.add(button);
      }
      public static void main(String a[])
      {
             Core exe = new Core();
//             exe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             exe.pack();
//             exe.setVisible(true);
      }
    class EventQuit implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}