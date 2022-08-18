package org.aston.service.impl;

import org.aston.model.Student;
import org.aston.repository.StudentRepository;
import org.aston.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.studentRepository = repository;
    }

    @Override
    public Student getStudent(Long id) {
        Student student = studentRepository.getById(id);
        return student != null ? student : new Student();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student student = studentRepository.getById(id);
        return student != null ? studentRepository.deleteById(id) : new Student();
    }

}
