package br.com.project.interfaces.controller.noauth.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.application.usecase.authentication.AuthenticateUserUseCase;
import br.com.project.interfaces.controller.noauth.AbstractPublicController;
import br.com.project.interfaces.dto.authentication.AuthenticationRequestDTO;
import br.com.project.interfaces.dto.authentication.AuthenticationResponseDTO;

@RestController
public class AuthController extends AbstractPublicController {

    private AuthenticateUserUseCase authenticateUserUseCase;

    @Autowired
    public AuthController(AuthenticateUserUseCase authenticateUserUseCase) {
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDTO request) throws Exception {
        AuthenticationResponseDTO response = authenticateUserUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
