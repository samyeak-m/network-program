package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseControls extends JFrame{
    JTextArea t1;
    JLabel l1;

    public void setMouse() {

        t1 = new JTextArea(20, 20);
        l1 = new JLabel("Result: ");
        add(t1);
        add(l1);

        setVisible(true);
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

//        handling mouse event in JTextArea

        t1.addMouseListener(new MouseListener() {
//            contains 5 method  which should be compulsary override

            @Override
            public void mouseClicked(MouseEvent e) {
//                when mouse is clicked and released
                l1.setText("Mouse is clicked");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                when mouse is clicked inside component and released out of component

                l1.setText("mouse is released");

            }

            @Override
            public void mousePressed(MouseEvent e) {
//                whne mouse is ontinously clicked
                l1.setText("mouse pressed");

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                when mouse cursur enter into component

                l1.setText("mouse entered in text area");

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                when mouse cursor exitss from component
                l1.setText("mouse exited from txtarea");
            }

        });

    }
}

public class mouseEventDemo {

    public static void main(String[] args) {
        MouseControls m1 = new MouseControls();
        m1.setMouse();
    }

}
