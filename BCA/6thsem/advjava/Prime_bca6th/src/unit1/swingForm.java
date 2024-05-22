package unit1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Control extends JFrame {

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3;
    JButton b1;

    public void setControls() {
        l1 = new JLabel("Username: ");
        l2 = new JLabel("Password: ");
        l3 = new JLabel("CPassword: ");
        l4 = new JLabel("Display: ");
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        t3 = new JPasswordField(20);
        b1 = new JButton("Submit: ");

        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(b1);
        add(l4);

        setVisible(true);
        setSize(200, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String uname = t1.getText();
                    String password = t2.getText();
                    String cpassword = t3.getText();

                    if (!password.equals(cpassword)) {
                        l4.setText("Passwords do not match");
                    } else {
                        l4.setText("<html> Username : " + uname + "<br> Password" + password + "<br> Cpassword" + cpassword + "</html>");

                    }

                } catch (NumberFormatException ex) {
                    l4.setText("enter number");
                    throw new RuntimeException(ex);

                }
            }
        });
    }
}

public class swingForm {
    public static void main(String[] args) {
        Control c2 = new Control();
        c2.setControls();
    }
}
