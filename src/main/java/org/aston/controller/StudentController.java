package org.aston.controller;

import org.aston.dto.request.StudentRequestDTO;
import org.aston.dto.response.StudentResponseDTO;
import org.aston.model.Student;
import org.aston.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public StudentResponseDTO getStudent(@PathVariable Long studentId) {
        Student currentStudent = studentService.getStudent(studentId);
        return convertToDTO(currentStudent);
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @PostMapping
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setFirstName(studentRequestDTO.getFirstName());
        student.setLastName(studentRequestDTO.getLastName());
        student.setUserRole(studentRequestDTO.getRole());
        student.setPassword(studentRequestDTO.getPassword());

        Student persistedStudent = studentService.addStudent(student);
        return convertToDTO(persistedStudent);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponseDTO deleteStudent(@PathVariable Long studentId) {
        Student deletedStudent = studentService.deleteStudent(studentId);
        return convertToDTO(deletedStudent);
    }

    private StudentResponseDTO convertToDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getLog());
    }
}
