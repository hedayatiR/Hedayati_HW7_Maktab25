package myapp.model.dao;

import myapp.model.Student;
import myapp.model.Teacher;
import myapp.model.TeacherStudent;

import java.sql.SQLException;
import java.util.List;

public interface TeacherStudentDAO {
    void insert(TeacherStudent teacherStudent) throws SQLException;

    void delete(TeacherStudent teacherStudent) throws SQLException;

    List<TeacherStudent> findAll() throws SQLException;
    List<Teacher> findTeachersOfStudent(Student student) throws SQLException;
    List<Student> findStudentsOfTeacher(Teacher teacher) throws SQLException;

}