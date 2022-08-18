package org.aston.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aston.dto.request.StudentRequestDTO;
import org.aston.dto.response.StudentResponseDTO;
import org.aston.model.Log;
import org.aston.model.Student;
import org.aston.service.StudentService;
import org.aston.util.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "StudentController", description = "Everything about students")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    private final StudentMapper mapper;

    @Autowired
    public StudentController(StudentService service, StudentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Find student by student ID", responses =
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "result of successful find",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Student.class))
                    )
            })
    @GetMapping("/{id}")
    public StudentResponseDTO getStudent(@Parameter(description = "ID of student to find", example = "1")
                                         @PathVariable Long id) {
        return mapper.toDto(service.getStudent(id));
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
                    )
            })
    @GetMapping
    public List<StudentResponseDTO> getStudents() {
        return service.getAllStudents().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
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
                                    responseCode = "403",
                                    description = "Invalid authorization",
                                    content = @Content(schema = @Schema(hidden = true))
                            )
                    })
    @PostMapping
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO studentDto) {
        return mapper.toDto(service.addStudent(mapper.toStudent(studentDto)));
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
                                    responseCode = "403",
                                    description = "Invalid authorization",
                                    content = @Content(schema = @Schema(hidden = true))
                            )
                    })
    @DeleteMapping("/{id}")
    public StudentResponseDTO removeStudent(@Parameter(description = "ID of student for delete", example = "1")
                                            @PathVariable Long id) {
        return mapper.toDto(service.deleteStudent(id));
    }

}
