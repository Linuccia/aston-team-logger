package org.aston.repository;

import org.aston.model.Student;

import java.util.List;

public interface StudentRepository {

    Student getById(Long id);

    List<Student> getAll();

    Student save(Student student);

    Student deleteById(Long id);

}
