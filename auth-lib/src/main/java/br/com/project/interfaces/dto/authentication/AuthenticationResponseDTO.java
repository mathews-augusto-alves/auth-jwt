package br.com.project.interfaces.dto.authentication;

public class AuthenticationResponseDTO {

    private final String jwt;

    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
