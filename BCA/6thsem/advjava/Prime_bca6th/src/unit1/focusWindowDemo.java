package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FocusExample extends JFrame{
    JButton b1,b2;
    JLabel l1;

    public void setFocus(){
        b1 = new JButton("button1");
        b2 = new JButton("button 2");
        l1 = new JLabel("Result");

        add(b1);add(b2);add(l1);
        setVisible(true);
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

        b1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                l1.setText("Gained");
            }

            @Override
            public void focusLost(FocusEvent e) {
                l1.setText("Loss");


            }
        });
    }
}


public class focusWindowDemo {

    public static void main(String[] args) {

        FocusExample f1 = new FocusExample();
        f1.setFocus();

    }

}
