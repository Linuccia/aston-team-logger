package org.aston.repository.impl;

import org.aston.model.Student;
import org.aston.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public Student getById(Long id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student deleteById(Long id) {
        return null;
    }

}
