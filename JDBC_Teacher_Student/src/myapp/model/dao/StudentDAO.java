package myapp.model.dao;

import myapp.model.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    Long insert(Student student) throws SQLException;

    void update(Student student) throws SQLException;

    void delete(Student student) throws SQLException;

    List<Student> findAll() throws SQLException;

}
