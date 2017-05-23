package dbstudent.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {
    
    Connection conn=null;
    PreparedStatement stmt=null;
    
    public void open() throws SQLException{
        String url = "jdbc:derby://localhost:1527/Students";
        String username = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, username, password);
    }
    
    public PreparedStatement initStatement(String sql) throws SQLException{
        stmt = conn.prepareStatement(sql);
        return stmt;
    }
    
    public ResultSet executeQuery() throws SQLException{
        return stmt.executeQuery();
    }
    
    public void close() throws SQLException{
        if(conn!=null){
            conn.close();
            conn=null;
        }
    }

}
