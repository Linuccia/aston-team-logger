package org.aston.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LogRequestDTO {
    private String message;
    private Long studentId;
}
