package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//using deligation event , we have to use all the pre-defind methods
//but using adapter class  we can implement any predefined methods that is
//if event contains five methods then we can have choice like 1, 2, or all  mehtods
//example on MouseAdapter , here we will handle anu two out of five

class MouseAdapterEg extends JFrame{
    JTextArea t1;
    JLabel l1;

    public void setMouseAdapter(){
        t1 = new JTextArea(20,20);
        l1 = new JLabel("Result");

        add(t1);add(l1);

        setVisible(true);
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

//        handling mouseevent in t1

        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                l1.setText("clicked");
            }

            @Override
            public void mouseExited(MouseEvent e){
                l1.setText("exit");
            }
        });
    }
}

public class mouseAdapter {
    public static void main(String[] args) {
        MouseAdapterEg m1 =new MouseAdapterEg();
        m1.setMouseAdapter();
    }
}
