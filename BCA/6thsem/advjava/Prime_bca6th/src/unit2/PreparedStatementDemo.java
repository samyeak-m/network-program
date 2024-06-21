package unit2;

import java.util.*;
import java.sql.*;

class PreparedExample{
    Connection conn;
    public void preparedInsert(){
        try {
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

            Scanner sc = new Scanner(System.in);
            System.out.println("ID : ");
            int id = sc.nextInt();
            System.out.println("Name : ");
            String name = sc.next();
            System.out.println("gender : ");
            String gender = sc.next();
            System.out.println("faculty : ");
            String faculty = sc.next();
            System.out.println("fee : ");
            String fee = sc.next();

            String insQuery = "insert into tbl_std values(?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(insQuery);
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,gender);
            ps.setString(4,faculty);
            ps.setString(5,fee);

            int res = ps.executeUpdate();

            if (res>0){
                System.out.println(res+" data inserted");
            }
            else {
                System.err.println("data inserted fail.");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}

public class PreparedStatementDemo {
    public static void main(String[] args) {
        PreparedExample p = new PreparedExample();
        p.preparedInsert();
    }
}
