package org.aston.controller;

import org.aston.model.Student;
import org.aston.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public List<Student> getStudents() {
        return null;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeStudent(@PathVariable Long id) {
        return null;
    }

}
