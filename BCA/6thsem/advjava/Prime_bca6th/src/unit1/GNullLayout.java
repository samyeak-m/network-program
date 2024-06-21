package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GNull extends JFrame{
    JLabel l1,l2;
    JTextField t1,t2,t3;

    JButton b1;

    public void setGNUll(){
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        b1 = new JButton("ADD");
        l1 = new JLabel("Enter First num");
        l2 = new JLabel("Enter Second num");

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(l1,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(t1,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(l2,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(t2,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(b1,gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(t3,gbc);

        setVisible(true);

        setSize(500,500);
        setDefaultCloseOperation(3);

b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        int sum = Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText());
        t3.setText(String.valueOf(sum));

    }
});

    }
}

public class GNullLayout {

    public static void main(String[] args) {
        GNull g = new GNull();
        g.setGNUll();
    }

}
