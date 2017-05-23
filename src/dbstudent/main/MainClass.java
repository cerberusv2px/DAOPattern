package dbstudent.main;

import dbstudent.dao.StudentDAO;
import dbstudent.dao.impl.StudentDAOImpl;
import dbstudent.entity.Student;
import java.sql.SQLException;
import java.util.ArrayList;


public class MainClass {

    static StudentDAO studentDAO = new StudentDAOImpl();
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<Student> stdList  = studentDAO.getByAddress("Kathmandu");
        for(Student s : stdList){
            System.out.println(s);
        }
              
    }
}
