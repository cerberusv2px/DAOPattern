package dbstudent.dao.impl;

import dbstudent.dao.StudentDAO;
import dbstudent.dbutil.DBConnection;
import dbstudent.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAOImpl implements StudentDAO {

    DBConnection conn = new DBConnection();
    
    @Override
    public ArrayList<Student> getByAddress(String address) throws SQLException,ClassNotFoundException{
        conn.open();
        String sql = "SELECT * FROM tblstudents WHERE district=?";
        PreparedStatement stmt = conn.initStatement(sql);
        stmt.setString(1, address);
        ResultSet rs = conn.executeQuery();
        ArrayList<Student> stdList = new ArrayList<Student>();
        while(rs.next()){
            Student std = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("district"), rs.getInt("age"));
            stdList.add(std);
        }
        conn.close();
        return stdList;
    }

}
