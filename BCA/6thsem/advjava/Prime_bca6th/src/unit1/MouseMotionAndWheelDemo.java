package unit1;

import  javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

class MouseMotion extends JFrame {

    JTextArea t1;
    JLabel l1;

    public void setMouseMotion() {

        t1 = new JTextArea(20, 20);
        l1 = new JLabel("Result: ");
        add(t1);
        add(l1);

        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

//        handling mouse motion event in TextArea

        t1.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
//                when mouse is dragged inside component

                l1.setText("mouse dragged at "+e.getX()+", "+e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

                l1.setText("mouse moved at "+e.getX()+", "+e.getY());


            }
        });

    }
}

public class MouseMotionAndWheelDemo {

    public static void main(String[] args) {
        MouseMotion m2 = new MouseMotion();
        m2.setMouseMotion();
    }
}
