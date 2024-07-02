package unit2;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class DisplayExample extends JFrame{
    JTable jt;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;

    public void setDisplay(){
        jt = new JTable();

        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l3=new JLabel("Repassword");
        l4=new JLabel("Gender");
        l5=new JLabel("Course");
        l6=new JLabel("Country");
        l7=new JLabel("Result : ");

        t1 = new JTextField(20);
        t2 = new JTextField(20);
        t3 = new JTextField(20);
        t4 = new JTextField(20);
        t4 = new JTextField(20);
        t5 = new JTextField(20);
        t6 = new JTextField(20);

        b1 = new JButton("Update");
        b2 = new JButton("Delete");

        jt.setPreferredScrollableViewportSize(new Dimension(750,50));

        JScrollPane js = new JScrollPane(jt);

        DefaultTableModel df = (DefaultTableModel) jt.getModel();

        df.addColumn("id");
        df.addColumn("username");
        df.addColumn("password");
        df.addColumn("repassword");
        df.addColumn("gender");
        df.addColumn("Course");
        df.addColumn("Country");

        try{

            Connection conn = DBConnection.ConnectDb();

            String disQuery = "select * from tbl_reg";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(disQuery);

            while (rs.next()){
                int id = rs.getInt("id");
                String un = rs.getString("username");
                String ps = rs.getString("password");
                String rps = rs.getString("repassword");
                String gd = rs.getString("gender");
                String co = rs.getString("course");
                String cu = rs.getString("country");

                df.addRow(new Object[]{id,un,ps,rps,gd,co,cu});
            }

            add(js);

            add(l1);add(t1);
            add(l2);add(t2);
            add(l3);add(t3);
            add(l4);add(t4);
            add(l5);add(t5);
            add(l6);add(t6);
            add(b1);add(b2);
            add(l7);

            setVisible(true);
            setSize(800,800);
            setLayout(new FlowLayout());
            setDefaultCloseOperation(3);

            jt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = jt.getSelectedRow();
                    int id = Integer.parseInt(df.getValueAt(row,0).toString());
                    String un = df.getValueAt(row,1).toString();
                    String ps = df.getValueAt(row,2).toString();
                    String rps = df.getValueAt(row,3).toString();
                    String gd = df.getValueAt(row,4).toString();
                    String co = df.getValueAt(row,5).toString();
                    String cu = df.getValueAt(row,6).toString();

                    t1.setText(un);
                    t2.setText(ps);
                    t3.setText(rps);
                    t4.setText(gd);
                    t5.setText(co);
                    t6.setText(cu);

                    b1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String upun = t1.getText();
                            String upps = t2.getText();
                            String uprps = t3.getText();
                            String upgd = t4.getText();
                            String upco = t5.getText();
                            String upcu = t6.getText();

                            String upQuery="update tbl_reg set username=?,password=?,repassword=?,gender=?,course=?,country=? where id = ?";

                            try {
                                PreparedStatement ps2 = conn.prepareStatement(upQuery);

                                ps2.setString(1,upun);
                                ps2.setString(2,upps);
                                ps2.setString(3,uprps);
                                ps2.setString(4,upgd);
                                ps2.setString(5,upco);
                                ps2.setString(6,upcu);
                                ps2.setInt(7,id);

                                int res1 = ps2.executeUpdate();

                                if (res1>0){
                                    System.out.println(res1+" data updated");
                                    l7.setForeground(Color.GREEN);
                                    l7.setText(res1+" data updated");
                                   

                                }

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                    });

                    b2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String upquery="delete from tbl_reg where id=?";

                            PreparedStatement ps3= null;
                            try {
                                ps3 = conn.prepareStatement(upquery);
                                ps3.setInt(1,id);

                                int res1 = ps3.executeUpdate();

                                if (res1>0){
                                    System.out.println(res1+" data deleted");
                                    l7.setForeground(Color.GREEN);
                                    l7.setText(res1+" data deleted");
                                }
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });

                    System.out.println(id + " " +un+" "+ps+" "+rps+" "+gd+" "+co+" "+cu);
                }
            });

        }
        catch (SQLException s){
            System.err.println(s);
        }
    }
}

public class SwingDisplayDemo {
    public static void main(String[] args) {
        DisplayExample de = new DisplayExample();
        de.setDisplay();
    }
}
