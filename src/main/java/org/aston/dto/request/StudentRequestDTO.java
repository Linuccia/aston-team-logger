package org.aston.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aston.model.UserRole;

@Data
@AllArgsConstructor
public class StudentRequestDTO {
    private String firstName;
    private String lastName;
    private UserRole role;
    private String password;
    private String confirmPassword;
}
