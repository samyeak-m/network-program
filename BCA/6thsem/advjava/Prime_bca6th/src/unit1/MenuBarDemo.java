package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuExample extends JFrame{
    public void setMenu(){
        JMenuBar mb = new JMenuBar();

        JMenu m1 = new JMenu("File");

        JMenuItem ma1 = new JMenuItem("NewTab");
        JMenuItem ma2 = new JMenuItem("NewWindow");
        JMenuItem ma3 = new JMenuItem("open");

        m1.add(ma1);m1.add(ma2);m1.add(ma3);

        mb.add(m1);

        JMenu m2 = new JMenu("New");
        JCheckBoxMenuItem c1 = new JCheckBoxMenuItem("copy");
        JCheckBoxMenuItem c2 = new JCheckBoxMenuItem("past");
        JCheckBoxMenuItem c3 = new JCheckBoxMenuItem("cut");

        m2.add(c1);m2.add(c2);m2.add(c3);

        mb.add(m2);

        JMenu m3 = new JMenu("View");
        JRadioButtonMenuItem r1 = new JRadioButtonMenuItem("Zoom");
        JRadioButtonMenuItem r2 = new JRadioButtonMenuItem("Status");

        m3.add(r1);m3.add(r2);
        mb.add(m3);

        add(mb);

        setVisible(true);
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

    }
}

public class MenuBarDemo {

    public static void main(String[] args) {
        MenuExample me = new MenuExample();
        me.setMenu();
    }
}
