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

    String tblQuery="CREATE TABLE IF NOT EXISTS tbl_std(id int primary key,username varchar(50),gender varchar(50),faculty varchar(50),fee varchar(10))";
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

            String insQuery="insert into tbl_std values (3,'birina','female','bca','99k')";

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

    public void displayData(){

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

            String disQuery="select * from tbl_std";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(disQuery);

            while(rs.next()){
                System.out.println("id : "+rs.getInt("id")+",\tname : "+rs.getString("username")+",\tgender : "+rs.getString("gender")
                        +",\tfaculty : "+rs.getString("faculty")+",\tfee : "+rs.getString("fee"));
            }

            conn.close();
        }
        catch (ClassNotFoundException c){
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateData(){

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

            String upQuery="update tbl_std set username='hari', gender='male' where id = '2'";

            Statement st = conn.createStatement();

            int res1 = st.executeUpdate(upQuery);

            if (res1>0){
                System.out.println(res1+" data updated");
            }

            conn.close();
        }
        catch (ClassNotFoundException c){
            System.out.println(c);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteData(){

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

            String deQuery="delete from tbl_std where id = '3'";

            Statement st = conn.createStatement();

            int res1 = st.executeUpdate(deQuery);

            if (res1>0){
                System.out.println(res1+" data deleted");
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
        j.createTable();
        j.displayData();
        j.instertData();
        j.displayData();
        j.updateData();
        j.displayData();
//        j.deleteData();
//        j.displayData();

    }
}
