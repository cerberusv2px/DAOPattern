package dbstudent.dao;

import dbstudent.entity.Student;
import java.sql.SQLException;
import java.util.ArrayList;


public interface StudentDAO{
    public ArrayList<Student> getByAddress(String address)  throws SQLException, ClassNotFoundException;

}
