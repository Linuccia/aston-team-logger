package org.aston.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aston.dto.response.LogResponseDTO;
import org.aston.model.Log;
import org.aston.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Tag(name = "LogController", description = "Everything about logs")
@RestController
@RequestMapping("/students/{studentId}/logs")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @Operation(summary = "Find log by log ID", responses =
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Result of successful find",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Log.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid ID supplied",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Log not found",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            })
    @GetMapping("/{logId}")
    public LogResponseDTO getLog(@Parameter(description = "ID of log to find", example = "1")
                          @PathVariable Long logId, @PathVariable Long studentId) {
        Log currentLog = logService.getLog(logId, studentId);
        return convertToDTO(currentLog);
    }

    @Operation(summary = "Find logs by student ID", responses =
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
                            responseCode = "400",
                            description = "Invalid ID supplied",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Log not found",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            })
    @GetMapping
    public List<LogResponseDTO> getLogs(@Parameter(description = "ID of student to find logs", example = "1")
                                        @PathVariable Long studentId) {
        return logService.getLogsByStudentId(studentId)
                .stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Operation(summary = "Add new log by student ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Log object that needs to be added"
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
                                    responseCode = "400",
                                    description = "Invalid student ID supplied",
                                    content = @Content(schema = @Schema(hidden = true))
                            ),
                            @ApiResponse(
                                    responseCode = "404",
                                    description = "Student not found",
                                    content = @Content(schema = @Schema(hidden = true))
                            ),
                            @ApiResponse(
                                    responseCode = "405",
                                    description = "Invalid input",
                                    content = @Content(schema = @Schema(hidden = true))
                            )
                    })
    @PostMapping
    public LogResponseDTO addLog(@Parameter(description = "ID of student to add log", example = "1")
                                 @PathVariable Long studentId, @RequestBody Log log) {
        Log logToAdd = new Log();
        logToAdd.setMessage(log.getMessage());
        Log persistedLog = logService.addLog(studentId, logToAdd);
        return convertToDTO(persistedLog);
    }

    @Operation(summary = "Update log by log ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Log object that needs to be update"
            ),
            responses =
                    {
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "Result of successful update",
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
                                    description = "Log not found",
                                    content = @Content(schema = @Schema(hidden = true))
                            ),
                            @ApiResponse(
                                    responseCode = "405",
                                    description = "Invalid input",
                                    content = @Content(schema = @Schema(hidden = true))
                            )
                    })
    @PutMapping("/{logId}")
    public LogResponseDTO updateLog(@Parameter(description = "ID of log for update", example = "1")
                                    @PathVariable Long studentId, @PathVariable Long logId, @RequestBody Log log) {
        Log updatedLog = logService.updateLog(studentId, logId, log);
        return convertToDTO(updatedLog);
    }

    @DeleteMapping("/{logId}")
    public LogResponseDTO deleteLog(@PathVariable Long logId, @PathVariable String studentId) {
        Log deletedLog = logService.deleteLog(logId);
        return convertToDTO(deletedLog);
    }

    private LogResponseDTO convertToDTO(Log log) {
        return new LogResponseDTO(
                log.getDate(),
                log.getMessage());
    }
}
