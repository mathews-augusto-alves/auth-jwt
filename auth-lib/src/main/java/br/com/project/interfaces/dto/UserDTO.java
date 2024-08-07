package br.com.project.interfaces.dto;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {
    @NotEmpty(message = "Username is required.")
    private String username;

    @NotEmpty(message = "Password is required.")
    private String password;

    @NotEmpty(message = "Roles is required.")
    private Set<RolesDTO> roles;
}
