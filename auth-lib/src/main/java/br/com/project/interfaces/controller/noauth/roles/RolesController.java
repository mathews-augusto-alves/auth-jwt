package br.com.project.interfaces.controller.noauth.roles;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.application.usecase.roles.RolesGetAllUseCase;
import br.com.project.interfaces.controller.noauth.AbstractPublicController;
import br.com.project.interfaces.dto.RolesDTO;

@RestController
public class RolesController extends AbstractPublicController {

    private final RolesGetAllUseCase getAllUseCase;
    
    public RolesController(RolesGetAllUseCase getAllUseCase) {
        this.getAllUseCase = getAllUseCase;
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getAllRoles() {
        Set<RolesDTO> roles = getAllUseCase.execute(null);
        return ResponseEntity.ok(roles);
    }
}
