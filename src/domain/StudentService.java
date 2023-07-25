/*
*  created date: Jul 24, 2023
*  author: cgm
*/
package domain;

import java.util.List;

import domain.model.Student;

public interface StudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    Student getStudentById(int studentId);
    List<Student> getAllStudents();

}
