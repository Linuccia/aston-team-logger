package org.aston.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aston.model.Log;
import org.aston.dto.request.StudentRequestDTO;
import org.aston.dto.response.StudentResponseDTO;
import org.aston.model.Student;
import org.aston.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "StudentController", description = "Everything about students")
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Find student by student ID", responses =
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "result of successful find",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Student.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid ID supplied",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Student not found",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            })
    @GetMapping("/{studentId}")
    public Student getStudent(@Parameter(description = "ID of student to find", example = "1")
                              @PathVariable Long studentId) {
        Student currentStudent = studentService.getStudent(studentId);
        return convertToDTO(currentStudent);
    }

    @Operation(summary = "Get all students", responses =
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Result of successful find",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Log.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Students not found",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            })
    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Operation(summary = "Add new student",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Student object that needs to be added"
            ),
            responses =
                    {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "Result of successful addition",
                                    content = @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Log.class)
                                    )
                            ),
                            @ApiResponse(
                                    responseCode = "405",
                                    description = "Invalid input",
                                    content = @Content(schema = @Schema(hidden = true))
                            )
                    })
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

    @Operation(summary = "Delete student by student ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Log object that needs to be added to the logs"
            ),
            responses =
                    {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "Result of successful delete",
                                    content = @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = Log.class))
                                    )
                            ),
                            @ApiResponse(
                                    responseCode = "400",
                                    description = "Invalid ID supplied",
                                    content = @Content(schema = @Schema(hidden = true))
                            ),
                            @ApiResponse(
                                    responseCode = "404",
                                    description = "Student not found",
                                    content = @Content(schema = @Schema(hidden = true))
                            )
                    })
    @DeleteMapping("/{studentId}")
    public ResponseEntity<HttpStatus> removeStudent(@Parameter(description = "ID of student for update", example = "1")
                                                    @PathVariable Long studentId) {
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
