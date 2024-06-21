package unit2;

//to connect with external data source like sql server, xml file etc.
//we need jar file to connect with sql database JDBC driver is required which is provided by jar file.
//following steps are required to connect database
//step 1: initialize JDBC driver using class. forName()
//step 2: create required variable to connect with database it includes URL, usename and password.
//step 3: connect with database using Connection class using object of statement
//step 5: close the connection

import java.sql.*;

class JDBCExample{
    Connection conn;
    public void createTable(){
try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/primebcasix";

    String user="root";
    String pass="";
    conn = DriverManager.getConnection(url,user,pass);

    if (conn!=null){
        System.out.println("Connected");
    }
    else{
        System.err.println("not connected");
    }

    String tblQuery="Create table tbl_std(id int primary key,username varchar(50),gender varchar(50),faculty varchar(50),fee varchar(50))";

    Statement st = conn.createStatement();
    st.execute(tblQuery);
    System.out.println("table created.");

    conn.close();


}
catch (ClassNotFoundException c){
    System.out.println(c);
} catch (SQLException e) {
    System.out.println(e);
}
    }


    public void instertData(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/primebcasix";

            String user="root";
            String pass="";
            conn = DriverManager.getConnection(url,user,pass);

            if (conn!=null){
                System.out.println("Connected");
            }
            else{
                System.err.println("not connected");
            }

            String insQuery="insert into tbl_std values (2,'ram','male','bim','99k')";

            Statement st = conn.createStatement();
            int res = st.executeUpdate(insQuery);
            if(res>0) {
                System.out.println(res+" row instered");
            }
            else {
                System.err.println("Data instered fail.");

            }

            conn.close();
        }
        catch (ClassNotFoundException c){
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

public class JDBCDemo {
    public static void main(String[] args) {
        JDBCExample j = new JDBCExample();
//        j.createTable();
        j.instertData();
    }
}
