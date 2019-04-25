package myapp.model.dao;

import myapp.model.Student;
import myapp.model.Teacher;
import myapp.model.TeacherStudent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherStudentDAOImpl implements TeacherStudentDAO {
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/university";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123";

    private static Connection conn;
    private static Statement statement;

    // ---------------------------------------------------------------------
    @Override
    public void insert(TeacherStudent teacherStudent) throws SQLException {
        initConn();

        String query = "INSERT INTO `teacher_student` (`fk_teacher`, `fk_student`) VALUES ('" + teacherStudent.getIdTeacher() + "', " + teacherStudent.getIdStudent() + "); ";
        statement.executeUpdate(query);

        closeConn();
    }

    // ---------------------------------------------------------------------
    @Override
    public void delete(TeacherStudent teacherStudent) throws SQLException {
        initConn();
        String query = "DELETE FROM `teacher_student` WHERE fk_teacher=" + teacherStudent.getIdTeacher() + " AND fk_student=" + teacherStudent.getIdStudent() + ";";
        statement.executeUpdate(query);
        closeConn();
    }

    // ---------------------------------------------------------------------
    @Override
    public List<TeacherStudent> findAll() throws SQLException {
        ArrayList<TeacherStudent> list = new ArrayList<>();
        initConn();

        String query = "SELECT * FROM `teacher_student`";

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            TeacherStudent teacherStudent = new TeacherStudent(rs.getLong("fk_student"), rs.getLong("fk_teacher"));
            list.add(teacherStudent);
        }

        rs.close();
        closeConn();

        return list;
    }

    // ---------------------------------------------------------------------
    @Override
    public List<Teacher> findTeachersOfStudent(Student student) throws SQLException {
        ArrayList<Teacher> list = new ArrayList<>();
        initConn();

        String query = "SELECT * FROM `teacher_student` INNER JOIN `teachers` ON teacher_student.fk_teacher=teachers.id WHERE teacher_student.fk_student="
                + String.valueOf(student.getId());

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Teacher teacher = new Teacher(rs.getString("name"), rs.getInt("teacherCode"));
            teacher.setId(rs.getLong("id"));
            list.add(teacher);
        }

        rs.close();
        closeConn();

        return list;
    }
    // ---------------------------------------------------------------------

    @Override
    public List<Student> findStudentsOfTeacher(Teacher teacher) throws SQLException {
        ArrayList<Student> list = new ArrayList<>();
        initConn();

        String query = "SELECT * FROM `teacher_student` INNER JOIN `students` ON teacher_student.fk_student=students.id WHERE teacher_student.fk_teacher="
                + String.valueOf(teacher.getId());

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            Student student = new Student(rs.getString("name"), rs.getInt("studentID"));
            student.setId(rs.getLong("id"));
            list.add(student);
        }

        rs.close();
        closeConn();

        return list;
    }

    // ---------------------------------------------------------------------
    private void initConn() throws SQLException {

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = conn.createStatement();
    }

    // ---------------------------------------------------------------------
    private void closeConn() throws SQLException {

        statement.close();
        conn.close();
    }
    // ---------------------------------------------------------------------
}
