package br.com.project.interfaces.dto.authentication;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Data Transfer Object for user authentication request.
 */
@Data
public class AuthenticationRequestDTO {
    @NotEmpty(message = "Username is required.")
    private String username;

    @NotEmpty(message = "Password is required.")
    private String password;
}
