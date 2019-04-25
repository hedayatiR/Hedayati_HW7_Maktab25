package myapp.model.dao;

import myapp.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDAO {

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/university";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123";

    private static Connection conn;
    private static Statement statement;

    // ---------------------------------------------------------------------
    @Override
    public Long insert(Teacher teacher) throws SQLException {
        Long out;
        initConn();

        String query = "INSERT INTO `teachers` (`name`, `teacherCode`) VALUES ('" + teacher.getName() + "', " + teacher.getCode() + "); ";
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
    @Override
    public void update(Teacher teacher) throws SQLException {
        initConn();
        String query = "UPDATE `Teachers` SET name='" + teacher.getName() + "', teacherCode=" + teacher.getCode() + " WHERE id=" + teacher.getId();
        statement.executeUpdate(query);
        closeConn();
    }
    // ---------------------------------------------------------------------
    @Override
    public void delete(Teacher teacher) throws SQLException {
        initConn();
        String query = "DELETE FROM `teachers` Where id=" + teacher.getId();
        statement.executeUpdate(query);
        closeConn();
    }
    // ---------------------------------------------------------------------
    @Override
    public List<Teacher> findAll() throws SQLException {
        ArrayList<Teacher> list = new ArrayList<>();
        initConn();

        String query = "SELECT * FROM `Teachers`";

        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Teacher tch = new Teacher(rs.getString("name"), rs.getInt("teacherCode"));
            tch.setId(rs.getLong("id"));

            list.add(tch);
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
