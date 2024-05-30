package unit1;

import  javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

class MouseMotion extends JFrame {

    JTextArea t1;
    JTextField tf1;
    JLabel l1,l2;

    public void setMouseMotion() {

        t1 = new JTextArea(20, 20);
        l1 = new JLabel("Result motion: ");
        tf1 = new JTextField(20);
        l2 = new JLabel("Result for wheel: ");
        add(t1); add(l1);
        add(tf1);add(l2);

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

//        handing mouse wheel event in tf1
//        this event is triggered when whell
        tf1.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                l2.setText("mouse scroll at "+e.getX()+", "+e.getY());

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
