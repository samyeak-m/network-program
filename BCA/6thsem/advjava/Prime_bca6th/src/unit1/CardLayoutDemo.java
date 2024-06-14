package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CardEg extends JFrame{
    JButton b1,b2,b3,b4,b5;
    JPanel p1;
    public void setCards(){
        b1 = new JButton("Button1");
        b2= new JButton("Button2");
        b3= new JButton("Button3");
        b4= new JButton("Button4");
        b5= new JButton("Button5");

        p1 = new JPanel();
//        p1.add(b1);p1.add(b2);p1.add(b3);p1.add(b4);

        CardLayout cl = new CardLayout();

        p1.setLayout(cl);
        p1.add(b1,"but1");
        p1.add(b2,"but2");
        p1.add(b3,"but3");
        p1.add(b4,"but4");
        p1.add(b5,"but5");

        add(p1);

        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.next(p1);

            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(p1,"but3");


            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.last(p1);

            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.first(p1);

            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.previous(p1);
            }
        });


    }
}

public class CardLayoutDemo {
    public static void main(String[] args) {
        CardEg ce = new CardEg();
        ce.setCards();
    }
}
