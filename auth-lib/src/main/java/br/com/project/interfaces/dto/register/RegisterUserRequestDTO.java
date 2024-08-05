package br.com.project.interfaces.dto.register;

import java.util.Set;

import br.com.project.interfaces.dto.RolesDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String username;
    private String password;
    private Set<RolesDTO> roles;
}
