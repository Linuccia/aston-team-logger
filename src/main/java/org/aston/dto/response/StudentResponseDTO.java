package org.aston.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aston.model.Log;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Log> log;
}
