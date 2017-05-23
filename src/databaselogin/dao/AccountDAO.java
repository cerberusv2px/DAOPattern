package databaselogin.dao;

import databaselogin.entity.Account;
import java.sql.SQLException;


public interface AccountDAO {
    Account getByName(String name) throws SQLException,ClassNotFoundException;
    
}
