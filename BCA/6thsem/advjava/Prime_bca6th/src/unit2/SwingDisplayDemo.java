package unit2;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class DisplayExample extends JFrame{
    JTable jt;

    public void setDisplay(){
        jt = new JTable();

        jt.setPreferredScrollableViewportSize(new Dimension(400,400));

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
            setVisible(true);
            setSize(400,400);
            setLayout(new FlowLayout());
            setDefaultCloseOperation(3);

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
