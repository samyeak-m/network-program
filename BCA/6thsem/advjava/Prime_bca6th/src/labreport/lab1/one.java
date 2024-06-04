package labreport.lab1;

import javax.swing.*;
import java.awt.event.*;

class clickevent extends JFrame{
    private JButton button;

    public void setclick() {
        button = new JButton("Click Me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked");
            }
        });

        this.add(button);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

public class one {

    public static void main(String[] args) {

        clickevent c1 = new clickevent();
        c1.setclick();

    }

}
