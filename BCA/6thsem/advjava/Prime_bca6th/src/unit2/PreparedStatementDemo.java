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

    public void displayInsert(){
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
            System.out.println("enter a id to display.");

            int did = sc.nextInt();

            String dquery="select * from tbl_std where id = ?";

            PreparedStatement ps1=conn.prepareStatement(dquery);
            ps1.setInt(1,did);

            ResultSet rs = ps1.executeQuery();

            while (rs.next()){
                System.out.println("id : "+rs.getInt("id")+",\tname : "+rs.getString("username")+",\tgender : "+rs.getString("gender")
                        +",\tfaculty : "+rs.getString("faculty")+",\tfee : "+rs.getString("fee"));
            }

            conn.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateInsert(){
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
            System.out.println("enter a id to user which you want to update record.");

            int uid = sc.nextInt();

            System.out.println("enter a update name.");
            String unames = sc.next();
            System.out.println("enter a update gender.");
            String ugender = sc.next();
            System.out.println("enter a update faculty.");
            String ufaculty = sc.next();


            String upquery="update tbl_std set username=?, gender=?, faculty=? where id=?";

            PreparedStatement ps2=conn.prepareStatement(upquery);
            ps2.setString(1,unames);
            ps2.setString(2,ugender);
            ps2.setString(3,ufaculty);
            ps2.setInt(4,uid);

            int res1 = ps2.executeUpdate();

            if (res1>0){
                System.out.println(res1+"data updated");
            }

            conn.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteInsert(){
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
            System.out.println("enter a id you want to delete.");

            int uid = sc.nextInt();



            String upquery="delete from tbl_std where id=?";

            PreparedStatement ps3=conn.prepareStatement(upquery);
            ps3.setInt(1,uid);

            int res1 = ps3.executeUpdate();

            if (res1>0){
                System.out.println(res1+" data deleted");
            }

            conn.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletebgInsert(){
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
            System.out.println("enter a gender you want to delete.");

            String ugender = sc.next();



            String upquery="delete from tbl_std where gender=?";

            PreparedStatement ps3=conn.prepareStatement(upquery);
            ps3.setString(1,ugender);

            int res1 = ps3.executeUpdate();

            if (res1>0){
                System.out.println(res1+" data deleted");
            }

            conn.close();

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
        p.displayInsert();
        p.updateInsert();
        p.displayInsert();
        p.deleteInsert();
        p.displayInsert();
        p.deletebgInsert();
        p.displayInsert();

    }
}
