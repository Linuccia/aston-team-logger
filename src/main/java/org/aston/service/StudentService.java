package org.aston.service;

import org.aston.model.Student;

import java.util.List;

public interface StudentService {

    Student getStudent(Long id);

    List<Student> getAllStudents();

    Student addStudent(Student student);

    Student deleteStudent(Long id);

}
