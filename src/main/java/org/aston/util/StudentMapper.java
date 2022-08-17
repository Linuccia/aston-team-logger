package org.aston.util;

import org.aston.dto.request.StudentRequestDTO;
import org.aston.dto.response.StudentResponseDTO;
import org.aston.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponseDTO toDto(Student student) {
        return new StudentResponseDTO(student.getId(), student.getFirstName(), student.getLastName(), student.getLog());
    }

    public Student toStudent(StudentRequestDTO studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setUserRole(studentDto.getRole());
        student.setPassword(studentDto.getPassword());
        return student;
    }

}
