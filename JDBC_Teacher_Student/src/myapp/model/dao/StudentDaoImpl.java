// Implementation for mySQL

package myapp.model.dao;

import myapp.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDAO {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/university";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123";

    private static Connection conn;
    private static Statement statement;

    // --------------`-------------------------------------------------------
    @Override
    public Long insert(Student student) throws SQLException {
        Long out;
        initConn();

        String query = "INSERT INTO `students` (`name`, `studentID`) VALUES ('" + student.getName() + "', " + student.getCode() + "); ";

        statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {

            if (generatedKeys.next()) {
                out = generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating failed, no ID obtained.");
            }
        }
        closeConn();
        return out;
    }

    // ---------------------------------------------------------------------
//    @Override
//    public Student findById(int id) throws SQLException {
//        initConn();
//
//        String query = "SELECT * FROM `students`";
//
//        ResultSet rs = statement.executeQuery(query);
//
//        Student stu = null;
//
//        if (rs.next()) {
//            stu = new Student(rs.getString("name"), rs.getInt("studentID"));
//        }
//
//        rs.close();
//        closeConn();
//
//        return stu;
//    }

    // ---------------------------------------------------------------------
//    @Override
//    public Student findByCode(int code) {
//        return null;
//    }

    // ---------------------------------------------------------------------
    @Override
    public void update(Student student) throws SQLException {
        initConn();
        String query = "UPDATE `students` SET name='" + student.getName() + "', studentID=" + student.getCode() + " WHERE id=" + student.getId();
        statement.executeUpdate(query);
        closeConn();
    }

    // ---------------------------------------------------------------------
    @Override
    public void delete(Student student) throws SQLException {
        initConn();
        String query = "DELETE FROM `students` Where id=" + student.getId();
        statement.executeUpdate(query);
        closeConn();
    }

    // ---------------------------------------------------------------------
    @Override
    public List<Student> findAll() throws SQLException {
        ArrayList<Student> list = new ArrayList<>();
        initConn();

        String query = "SELECT * FROM `students`";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Student stu = new Student(rs.getString("name"), rs.getInt("studentID"));
            stu.setId(rs.getLong("id"));

            list.add(stu);
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
}
