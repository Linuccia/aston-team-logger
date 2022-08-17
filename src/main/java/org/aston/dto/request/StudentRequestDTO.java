package org.aston.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aston.model.UserRole;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO implements Serializable {

    private String firstName;
    private String lastName;
    private UserRole role;
    private String password;
    private String confirmPassword;

}
