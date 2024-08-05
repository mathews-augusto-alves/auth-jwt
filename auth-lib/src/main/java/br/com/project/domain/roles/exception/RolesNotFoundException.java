package br.com.project.domain.roles.exception;

public class RolesNotFoundException extends RuntimeException {
    public RolesNotFoundException(String message) {
        super(message);
    }
}
