/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Student;
import pesistence.*;


public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    public StudentServiceImpl() {
        // Initialize the StudentDAO (Data Access Layer)
        studentDAO = new StudentDAOImpl(new StudentJdbcGateway());
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}



