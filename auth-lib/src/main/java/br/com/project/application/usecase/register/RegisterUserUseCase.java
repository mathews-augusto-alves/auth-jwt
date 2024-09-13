package br.com.project.application.usecase.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.project.application.service.UserService;
import br.com.project.application.usecase.UseCase;
import br.com.project.domain.user.model.Users;
import br.com.project.interfaces.dto.register.RegisterUserRequestDTO;
import br.com.project.interfaces.dto.register.RegisterUserResponseDTO;

@Service
public class RegisterUserUseCase implements UseCase<RegisterUserRequestDTO, RegisterUserResponseDTO> {

    private static final Logger logger = LoggerFactory.getLogger(RegisterUserUseCase.class);

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserService userService, 
                               PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterUserResponseDTO execute(RegisterUserRequestDTO request) {
        if (userService.findByUsername(request.getUsername()).isPresent()) {
            logger.warn("Attempt to register with already taken username: {}", request.getUsername());
            throw new IllegalArgumentException("Username is already taken.");
        }

        Users user = createUserFromRequest(request);
        userService.saveUser(user);

        logger.info("User registered successfully: {}", request.getUsername());

        return new RegisterUserResponseDTO("User registered successfully");
    }

    private Users createUserFromRequest(RegisterUserRequestDTO request) {
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        return user;
    }
}
