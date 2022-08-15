package org.aston.service.impl;

import org.aston.model.Student;
import org.aston.repository.StudentRepository;
import org.aston.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.studentRepository = repository;
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(Long id) {
        return null;
    }

}
