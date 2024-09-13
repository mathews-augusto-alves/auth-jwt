package br.com.project.interfaces.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {
    @NotEmpty(message = "{NotEmpty.userDTO.username}")
    private String username;

    @NotEmpty(message = "{NotEmpty.userDTO.password}")
    private String password;

    @NotEmpty(message = "{NotEmpty.userDTO.email}")
    @Email(message = "{Email.userDTO.email}")
    private String email;

}
