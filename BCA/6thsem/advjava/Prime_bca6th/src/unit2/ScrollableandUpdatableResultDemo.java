package unit2;

import java.sql.*;

class ScrollUpdating {
    Connection conn;
    public void setScroll(){
        try {

            Connection conn = DBConnection.ConnectDb();

            String disQuery = "Select * from tbl_std";

            int scroll = ResultSet.TYPE_SCROLL_SENSITIVE;
            int updateable = ResultSet.CONCUR_UPDATABLE;
            int readonly = ResultSet.CONCUR_READ_ONLY;

//            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            OR
            Statement st = conn.createStatement(scroll,updateable);

            ResultSet rs = st.executeQuery(disQuery);

            rs.absolute(1);

            System.out.println("id : "+rs.getInt("id")+",\tname : "+rs.getString("username")+",\tgender : "+rs.getString("gender")
                    +",\tfaculty : "+rs.getString("faculty")+",\tfee : "+rs.getString("fee"));

            rs.first();
            rs.updateString("fee","100k");
            rs.updateString("faculty","bim");
            rs.updateRow();

            System.out.println("id : "+rs.getInt("id")+",\tname : "+rs.getString("username")+",\tgender : "+rs.getString("gender")
                    +",\tfaculty : "+rs.getString("faculty")+",\tfee : "+rs.getString("fee"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


public class ScrollableandUpdatableResultDemo {

    public static void main(String[] args) {
        ScrollUpdating su = new ScrollUpdating();
        su.setScroll();
    }

}
