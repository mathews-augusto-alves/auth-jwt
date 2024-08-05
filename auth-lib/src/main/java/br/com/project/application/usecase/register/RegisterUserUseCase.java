package br.com.project.application.usecase.register;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.project.application.service.UserService;
import br.com.project.application.usecase.UseCase;
import br.com.project.domain.roles.model.Roles;
import br.com.project.domain.user.model.Users;
import br.com.project.infrastructure.adapter.mapper.MapConverter;
import br.com.project.interfaces.dto.register.RegisterUserRequestDTO;
import br.com.project.interfaces.dto.register.RegisterUserResponseDTO;

@Service
public class RegisterUserUseCase implements UseCase<RegisterUserRequestDTO, RegisterUserResponseDTO>{

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final MapConverter mapConverter;
    @Autowired
    public RegisterUserUseCase(UserService userService, 
            PasswordEncoder passwordEncoder, 
            MapConverter mapConverter) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.mapConverter = mapConverter;
    }

    @Override
    public RegisterUserResponseDTO execute(RegisterUserRequestDTO request) {
        if (userService.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Set<Roles> roles = mapConverter.convertSetToSet(request.getRoles(), Roles.class);
        user.setRoles(roles);

        userService.saveUser(user);

        return new RegisterUserResponseDTO("User registered successfully");
    }
}
