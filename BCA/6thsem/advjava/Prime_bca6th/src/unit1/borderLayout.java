package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//border layout places the swing controls (content) in term of direction. it divided the window into five parts: top (north), bottom (south),right (east), left (west) and middle (center).

class BorderExample extends JFrame{
    JButton b1,b2,b3,b4;
    JTextArea t1;

    public void setBorders(){
        b1 = new JButton("NorthButton");
        b2= new JButton("SouthButton");
        b3 = new JButton("EastButton");
        b4 = new JButton("WesthButton");
        t1 = new JTextArea(20,20);

        setVisible(true);
        setSize(500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(3);

        add(b1,BorderLayout.NORTH);
        add(b2,BorderLayout.SOUTH);
        add(b3,BorderLayout.EAST);
        add(b4,BorderLayout.WEST);
        add(t1,BorderLayout.CENTER);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText("North");

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText("South");
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText("east");
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText("west");
            }
        });

    }
}

public class borderLayout {
    public static void main(String[] args) {
        BorderExample b = new BorderExample();
        b.setBorders();
    }

}
