package org.aston.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aston.model.Log;
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
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
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
    @GetMapping("/{id}")
    public Student getStudent(@Parameter(description = "ID of student to find", example = "1")
                              @PathVariable Long id) {
        return null;
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
    public List<Student> getStudents() {
        return null;
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
    public Student addStudent(@RequestBody Student student) {
        return null;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeStudent(@Parameter(description = "ID of student for update", example = "1")
                                                    @PathVariable Long id) {
        return null;
    }

}
