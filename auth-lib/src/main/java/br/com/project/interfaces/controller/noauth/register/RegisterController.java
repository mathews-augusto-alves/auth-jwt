package br.com.project.interfaces.controller.noauth.register;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.application.usecase.register.RegisterUserUseCase;
import br.com.project.interfaces.controller.noauth.AbstractPublicController;
import br.com.project.interfaces.dto.UserDTO;
import br.com.project.interfaces.dto.register.RegisterUserRequestDTO;
import br.com.project.interfaces.dto.register.RegisterUserResponseDTO;

@RestController
public class RegisterController extends AbstractPublicController {

    private RegisterUserUseCase registerUserUseCase;
    private ModelMapper modelMapper;

    @Autowired
    public RegisterController(RegisterUserUseCase registerUserUseCase, ModelMapper modelMapper) {
        this.registerUserUseCase = registerUserUseCase;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDTO> registerUser(@RequestBody UserDTO userDTO) {
        RegisterUserRequestDTO registerRequest = modelMapper.map(userDTO, RegisterUserRequestDTO.class);
        RegisterUserResponseDTO response = registerUserUseCase.execute(registerRequest);
        return ResponseEntity.ok(response);
    }
}
