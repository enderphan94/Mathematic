package listener;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
class Core
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("My frame");
        CheckboxGroup g=new CheckboxGroup();
        Checkbox c1=new Checkbox("Option 1",g,true);
        Checkbox c2=new Checkbox("Option 2",g,false);
        Checkbox c3=new Checkbox("Option 3",g,false);
        MyItemListener listener = new MyItemListener();
        c1.addItemListener(listener);
        c2.addItemListener(listener);
        c3.addItemListener(listener);
        Panel panel=new Panel();
        frame.add(panel);
        panel.add(c1);
        panel.add(c2);
        panel.add(c3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocation(300, 400);
    }
}
class MyItemListener implements ItemListener
{
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
            Object temp=e.getItem();
            String s=(String)temp;
            System.out.println(s);
        }
    }
}