package databaselogin.dao.impl;

import databaselogin.dao.AccountDAO;
import databaselogin.dbutil.DBConnection;
import databaselogin.entity.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAOImpl implements AccountDAO {

    DBConnection conn = new DBConnection();
    
    @Override
    public Account getByName(String name) throws SQLException,ClassNotFoundException {
        conn.open();
        String sql = "SELECT * from ACCOUNT where name=?";
        PreparedStatement stmt = conn.initStatement(sql);
        stmt.setString(1, name);
        ResultSet rs = conn.executeQuery();
        Account acc = null;
        while(rs.next()){
            acc = new Account(rs.getInt("id"), rs.getString("name"));
        }
        conn.close();
        return acc;
    }

}
