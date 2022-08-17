package org.aston.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LogResponseDTO {
    private LocalDate date;
    private String message;
}
