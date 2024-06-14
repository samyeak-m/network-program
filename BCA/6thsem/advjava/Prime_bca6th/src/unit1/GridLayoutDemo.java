package unit1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class GridEg extends JFrame{
    JButton b1,b2,b3,b4,b5,b6;

    public void setGrids(){

        b1 =new JButton("button1");
        b2 =new JButton("button2");
        b3 =new JButton("button3");
        b4 =new JButton("button4");
        b5 =new JButton("button5");
        b6 =new JButton("button6");

        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);

        setVisible(true);
        setSize(500,500);
        setLayout(new GridLayout(2,3,10,10));
        setDefaultCloseOperation(3);

    }

}

public class GridLayoutDemo {
    public static void main(String[] args) {
        GridEg ge =new GridEg();
        ge.setGrids();
    }
}
