package org.aston.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogRequestDTO {
    private String message;
    private String date;
    private Integer studentId;
}
