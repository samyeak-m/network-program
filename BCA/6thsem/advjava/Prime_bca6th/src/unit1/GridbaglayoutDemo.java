package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GridBagExample extends JFrame{

    JButton b1,b2,b3,b4;

    public void setGridBag(){
        b1 = new JButton("Button1");
        b2 = new JButton("Button2");
        b3 = new JButton("Button3");
        b4 = new JButton("Button4");

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);


        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.fill = GridBagConstraints.VERTICAL;

        add(b1,gbc);

        gbc.gridx=1;
        gbc.gridy=0;

//        gbc.gridwidth=2;

        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.fill = GridBagConstraints.VERTICAL;

        add(b2,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=2;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b3,gbc);

        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridwidth=3;
        gbc.gridheight=2;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b4,gbc);

        setVisible(true);

        setSize(500,500);
        setDefaultCloseOperation(3);
    }
}

public class GridbaglayoutDemo {

    public static void main(String[] args) {
        GridBagExample ge = new GridBagExample();
        ge.setGridBag();
    }

}
