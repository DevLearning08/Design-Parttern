/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Student;

public class StudentDAOImpl implements StudentDAO {
    private StudentGateway studentGateway;

    public StudentDAOImpl(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @Override
    public void addStudent(Student student) {
        studentGateway.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentGateway.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentGateway.deleteStudent(studentId);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentGateway.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentGateway.getAllStudents();
    }
}



