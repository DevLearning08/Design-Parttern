/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package pesistence;

import java.util.List;

import domain.model.Student;

public interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();
}




