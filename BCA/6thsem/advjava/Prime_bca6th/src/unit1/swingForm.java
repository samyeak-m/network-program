package unit1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Control extends JFrame {

    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3;
    JRadioButton r1,r2;
    JCheckBox c1,c2,c3;
    JComboBox s1;

    JButton b1;

    ButtonGroup bg = new ButtonGroup();


    public void setControls() {
        l1 = new JLabel("Username: ");
        l2 = new JLabel("Password: ");
        l3 = new JLabel("CPassword: ");
        l4 = new JLabel("Gender: ");
        l5 = new JLabel("Course: ");
        l6 = new JLabel("Country: ");
        l7 = new JLabel("Display: ");

        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        t3 = new JPasswordField(20);

        r1 = new JRadioButton("M");
        r2 = new JRadioButton("F");

        c1 = new JCheckBox("C++");
        c2 = new JCheckBox("Java");
        c3 = new JCheckBox("Dotnet");

        String[] countries = { "Nepal", "India", "USA", "China", "Australia" };
        s1 = new JComboBox<>(countries);

        bg.add(r1);
        bg.add(r2);

        b1 = new JButton("Submit: ");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(r1); add(r2);
        add(l5); add(c1); add(c2); add(c3);
        add(l6); add(s1);
        add(b1);
        add(l7);

        setVisible(true);
        setSize(200, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String uname = t1.getText();
                    String password = t2.getText();
                    String cpassword = t3.getText();
                    String gender = r1.isSelected()?"M":r2.isSelected()?"F":"Not";
                    StringBuilder courses = new StringBuilder();
                    if (c1.isSelected()) courses.append("C++ ");
                    if (c2.isSelected()) courses.append("Java ");
                    if (c3.isSelected()) courses.append("Dotnet ");
                    String country = (String) s1.getSelectedItem();

                    if (!password.equals(cpassword)) {
                        l7.setText("Passwords do not match");
                    }
                    if ("Not".equals(gender) || password.isEmpty() || cpassword.isEmpty() || courses.isEmpty() || country.isEmpty()) {
                        l7.setText("cant be empty");

                    } else {
                        l7.setText("<html> <br> Username : " + uname + "<br> Password : " + password + "<br> Cpassword : " + cpassword + "<br> gender : "+gender+"<br> course"
                                +courses+"<br> country"+country+"</html>");

                    }

                } catch (NumberFormatException ex) {
                    l7.setText("empty field");
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
