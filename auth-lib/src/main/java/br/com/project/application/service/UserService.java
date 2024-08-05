package br.com.project.application.service;

import java.util.Optional;

import br.com.project.domain.user.model.Users;

public interface UserService {
    Optional<Users> findByUsername(String username);
    Users saveUser(Users user);
}
