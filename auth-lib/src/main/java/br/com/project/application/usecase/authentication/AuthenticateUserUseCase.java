package br.com.project.application.usecase.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.project.application.service.user.UsersServiceImpl;
import br.com.project.application.usecase.UseCase;
import br.com.project.domain.user.model.Users;
import br.com.project.infrastructure.security.JwtTokenProvider;
import br.com.project.interfaces.dto.authentication.AuthenticationRequestDTO;
import br.com.project.interfaces.dto.authentication.AuthenticationResponseDTO;

@Service
public class AuthenticateUserUseCase implements UseCase<AuthenticationRequestDTO, AuthenticationResponseDTO> {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateUserUseCase.class);

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsersServiceImpl usersServiceImpl;

    @Autowired
    public AuthenticateUserUseCase(UsersServiceImpl usersServiceImpl, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.usersServiceImpl = usersServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthenticationResponseDTO execute(AuthenticationRequestDTO request) {
        Users user = usersServiceImpl.findByUsername(request.getUsername())
            .orElseThrow(() -> {
                logger.warn("User not found: {}", request.getUsername());
                return new IllegalArgumentException("Invalid username or password.");
            });

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            logger.warn("Invalid password for user: {}", request.getUsername());
            throw new IllegalArgumentException("Invalid username or password.");
        }

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        logger.info("User authenticated: {}", request.getUsername());

        return new AuthenticationResponseDTO(token);
    }
}
