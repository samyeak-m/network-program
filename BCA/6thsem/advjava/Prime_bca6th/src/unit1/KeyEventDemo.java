package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KeyControls{
    JTextArea t1;
    JLabel l1;
    JFrame f1;

    public void setKey(){
        t1 = new JTextArea(20,20);
        l1 = new JLabel("result");
        f1 = new JFrame();

        f1.add(t1);f1.add(l1);

        f1.setVisible(true);
        f1.setSize(500,500);
        f1.setLayout(new FlowLayout());

        f1.setDefaultCloseOperation(3);

        t1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                l1.setText("primary Key is pressed");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                l1.setText("control key is press");


            }

            @Override
            public void keyReleased(KeyEvent e) {
                l1.setText("Key is released");


            }
        });
    }
}

public class KeyEventDemo {

    public static void main(String[] args) {
        KeyControls k1 = new KeyControls();
        k1.setKey();
    }

}
