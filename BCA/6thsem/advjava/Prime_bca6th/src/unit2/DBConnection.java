package unit2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection ConnectDb(){
        try {
            Connection conn;
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/primebcasix";
            String user = "root";
            String password="";

            conn = DriverManager.getConnection(url,user,password);

            if (conn!=null){
                System.out.println("Connected");
                return conn;
            }
            else{
                System.err.println("not connected");
            }
        }
        catch (ClassNotFoundException c){
            System.err.println(c);
        }
        catch(SQLException s){
            System.err.println(s);
        }
        return null;
    }

}
