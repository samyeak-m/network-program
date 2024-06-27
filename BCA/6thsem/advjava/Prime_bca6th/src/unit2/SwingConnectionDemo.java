package unit2;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingForm extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1;
    JPasswordField p1,p2;
    JRadioButton r1,r2;
    JCheckBox c1,c2,c3;
    JComboBox cb1;
    JButton b1;

    public void setSwingForm(){
        l1 = new JLabel("Username : ");
        l2 = new JLabel("Password : ");
        l3 = new JLabel("Repassword : ");
        l4 = new JLabel("Gender : ");
        l5 = new JLabel("Course : ");
        l6 = new JLabel("Country : ");
        l7 = new JLabel("Result : ");

        t1=new JTextField(20);

        p1=new JPasswordField(20);
        p2=new JPasswordField(20);

        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);bg.add(r2);

        c1 = new JCheckBox("Python");
        c2 = new JCheckBox("Java");
        c3 = new JCheckBox("Dotnet");

        String []item={"Nepal","USA","India","Other"};
        cb1 = new JComboBox(item);

        b1= new JButton("Submit");
        add(l1);add(t1);
        add(l2);add(p1);
        add(l3);add(p2);
        add(l4);add(r1);add(r2);
        add(l5);add(c1);add(c2);add(c3);
        add(l6);add(cb1);
        add(b1);add(l7);

        setVisible(true);
        setLayout(new FlowLayout());
        setSize(500,500);
        setDefaultCloseOperation(3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t1.getText();
                String pass = p1.getText();
                String repass = p2.getText();
                String gender = "";

                if(r1.isSelected()){
                    gender=r1.getText();
                }else{
                    gender=r2.getText();
                }

                String course = "";

                if(c1.isSelected()){
                    course+=c1.getText()+" ";
                }
                if(c2.isSelected()){
                    course+=c2.getText()+" ";
                }
                if(c3.isSelected()){
                    course+=c3.getText()+" ";
                }

                String country = (String)cb1.getSelectedItem();

                try {
                    if(uname.isEmpty()==true||pass.isEmpty()==true||repass.isEmpty()==true){
                        l7.setFont(new Font("serif",Font.BOLD,14));
                        l7.setForeground(Color.red);
                        l7.setText("fill the form");
                    }
                    else{
                        l7.setForeground(Color.black);
                        l7.setText("");
                        Connection conn;
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        String url = "jdbc:mysql://localhost:3306/primebcasix";
                        String user = "root";
                        String password="";

                        conn = DriverManager.getConnection(url,user,password);

                        if (conn!=null){
                            System.out.println("Connected");
                        }
                        else{
                            System.err.println("not connected");
                        }

                        String insQuery = "insert into tbl_reg (username,password,repassword,gender,course,country) values(?,?,?,?,?,?)";

                        PreparedStatement ps =conn.prepareStatement(insQuery);
                        ps.setString(1,uname);
                        ps.setString(2,pass);
                        ps.setString(3,repass);
                        ps.setString(4,gender);
                        ps.setString(5,course);
                        ps.setString(6,country);

                        int res = ps.executeUpdate();

                        if (res>0){
                            l7.setForeground(Color.GREEN);
                            l7.setText(res+" data insetred.");
                        }

                    }

                }
                catch (ClassNotFoundException c){
                    System.out.println(c);
                }
                catch (SQLException s){
                    System.out.println(s);
                }
            }
        });

    }

}

public class SwingConnectionDemo {

    public static void main(String[] args) {
        SwingForm sf = new SwingForm();
        sf.setSwingForm();
    }

}
