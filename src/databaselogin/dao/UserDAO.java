package databaselogin.dao;

import databaselogin.entity.Users;
import java.sql.SQLException;


public interface UserDAO {

     Users getByUserAndPass(String username, String password, String type) throws SQLException,ClassNotFoundException;

}
