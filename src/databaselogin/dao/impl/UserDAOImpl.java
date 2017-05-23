package databaselogin.dao.impl;

import databaselogin.dao.AccountDAO;
import databaselogin.dao.UserDAO;
import databaselogin.dbutil.DBConnection;
import databaselogin.entity.Account;
import databaselogin.entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    DBConnection db = new DBConnection();
    AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public Users getByUserAndPass(String username, String password, String type) throws SQLException, ClassNotFoundException {
        db.open();
        Account ac = accountDAO.getByName(type);
        String sql = "select * from tbluser where username=? and password=? and acc_id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setInt(3, ac.getId());
        ResultSet rs = db.executeQuery();
        //db.close();
        Users user = null;
        while(rs.next()) {
            user = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("password"), ac);
        }
        db.close();
        return user;
    }

}
