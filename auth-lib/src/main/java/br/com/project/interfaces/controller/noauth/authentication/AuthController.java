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
import jakarta.validation.Valid;

/**
 * Controller responsible for managing user authentication.
 * This controller provides an endpoint for user login and authentication.
 */
@RestController
public class AuthController extends AbstractPublicController {
    private final AuthenticateUserUseCase authenticateUserUseCase;

    /**
     * Constructor that initializes the {@link AuthenticateUserUseCase} dependency.
     *
     * @param authenticateUserUseCase Use case for authenticating users.
     */
    @Autowired
    public AuthController(AuthenticateUserUseCase authenticateUserUseCase) {
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    /**
     * Endpoint to authenticate a user and return a JWT token.
     *
     * @param request User authentication data.
     * @return A {@link ResponseEntity} containing the authentication token.
     */
    @PostMapping("/auth/login")
    public ResponseEntity<AuthenticationResponseDTO> createAuthenticationToken(
            @Valid @RequestBody AuthenticationRequestDTO request) {
        AuthenticationResponseDTO response = authenticateUserUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
