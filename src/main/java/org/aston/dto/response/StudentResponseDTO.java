package org.aston.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aston.model.Log;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Log> log;

}
