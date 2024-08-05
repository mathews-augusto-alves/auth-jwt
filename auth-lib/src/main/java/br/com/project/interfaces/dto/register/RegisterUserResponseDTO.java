package br.com.project.interfaces.dto.register;

import lombok.Getter;

@Getter
public class RegisterUserResponseDTO {
    private String message;

    public RegisterUserResponseDTO(String message) {
        this.message = message;
    }
}
