package br.com.project.interfaces.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private Set<RolesDTO> roles;
}
