package myapp.model.dao;

import myapp.model.Teacher;
import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    Long insert(Teacher teacher) throws SQLException;

    void update(Teacher teacher) throws SQLException;

    void delete(Teacher teacher) throws SQLException;

    List<Teacher> findAll() throws SQLException;
}
