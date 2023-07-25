/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.model.Student;



public class StudentJdbcGateway implements StudentGateway {
    private Connection connection;

    public StudentJdbcGateway() {
        // Initialize the database connection here (replace dbUrl, username, and password with your SQL Server credentials)
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabaseName";
        String username = "YourUsername";
        String password = "YourPassword";
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students (id, name, major, java_mark, html_mark, css_mark) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getMajor());
            statement.setInt(4, student.getJavaMark());
            statement.setInt(5, student.getHtmlMark());
            statement.setInt(6, student.getCssMark());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE Students SET name = ?, major = ?, java_mark = ?, html_mark = ?, css_mark = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getMajor());
            statement.setInt(3, student.getJavaMark());
            statement.setInt(4, student.getHtmlMark());
            statement.setInt(5, student.getCssMark());
            statement.setInt(6, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM Students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM Students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String major = resultSet.getString("major");
                int javaMark = resultSet.getInt("java_mark");
                int htmlMark = resultSet.getInt("html_mark");
                int cssMark = resultSet.getInt("css_mark");
                // Calculate the average mark using the formula provided
                double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

                return new Student(id, name, major, javaMark, htmlMark, cssMark, averageMark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String major = resultSet.getString("major");
                int javaMark = resultSet.getInt("java_mark");
                int htmlMark = resultSet.getInt("html_mark");
                int cssMark = resultSet.getInt("css_mark");
                // Calculate the average mark using the formula provided
                double averageMark = (javaMark * 2.0 + htmlMark + cssMark) / 4.0;

                students.add(new Student(id, name, major, javaMark, htmlMark, cssMark, averageMark));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}



