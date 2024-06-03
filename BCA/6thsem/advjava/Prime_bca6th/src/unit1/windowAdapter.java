package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WindowAdaptereg {
    JFrame f1;
    public void setWindowadap(){
        f1 = new JFrame();
        f1.setVisible(true);
        f1.setSize(500,500);
        f1.setLayout(new FlowLayout());
        f1.setDefaultCloseOperation(3);

        f1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("window open");
            }
        });
    }
}

public class windowAdapter {
    public static void main(String[] args) {
        WindowAdaptereg w1=new WindowAdaptereg();
        w1.setWindowadap();
    }
}
