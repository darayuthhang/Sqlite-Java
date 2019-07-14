package datasource;

import java.sql.*;

public class DataBase {
    private Connection con = null;
    public DataBase(){

    }
    public Connection connection(){
        //create the string connection.
        String CONENECTION_STRING = "jdbc:sqlite:/Users/darayuthhang/Desktop/java/JDBC/student.db";
        String table_Name = "CREATE TABLE IF NOT EXISTS person("
                +"id INTEGER PRIMARY KEY, "
                +"name text NOT NULL, "
                +"sex text NOT NULL"
                +");";
        try{
          con = DriverManager.getConnection(CONENECTION_STRING);
            Statement stmt = con.createStatement();
            stmt.execute(table_Name);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void insertQuery( String name, String sex){
        String sql = "INSERT INTO person(name, sex) VALUES(?, ?)";
        try{
            Connection con = connection();
            PreparedStatement stmt = con.prepareStatement(sql);
            //first parameter
            stmt.setString(1, name);
            //second parameter
            stmt.setString(2, sex);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void displayQuery(){
        String sql = "SELECT * FROM person;";
        try{
            Connection con = connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //loop through the result set
            System.out.println("Display Query");
            while(rs.next()){
                System.out.println( rs.getInt("id")+ " "+
                                    rs.getString("name")+" " +
                                    rs.getString("sex"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteQuery(int id){
        String sql = "DELETE FROM person WHERE id= ?";

        try{
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void UpdateQuery(int id, String name, String sex){
        String sql = "UPDATE person SET name = ?, "
                + "sex = ?"
                + "WHERE id = ?";
        try{
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, sex);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void closeConnection() throws Exception{
        con.close();
    }


}
