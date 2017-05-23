package databaselogin.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

    Connection con=null;
    PreparedStatement stmt=null;
    
    public void open() throws SQLException{
        String url = "jdbc:derby://localhost:1527/Users";
        String username = "root";
        String password = "root";
        con = DriverManager.getConnection(url, username, password);
    }
    
    
    
    public void close() throws SQLException{
        if(con!=null){
            con.close();
        }
    }
    //if error check here
    public PreparedStatement initStatement(String sql) throws SQLException{
        return stmt= con.prepareStatement(sql);
        
    }
    
    public ResultSet executeQuery() throws SQLException{
        return stmt.executeQuery();
    }
    
}
