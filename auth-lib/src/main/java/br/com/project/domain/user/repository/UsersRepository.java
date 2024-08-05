package br.com.project.domain.user.repository;

import java.util.Optional;

import br.com.project.domain.user.model.Users;

public interface UsersRepository {
    Optional<Users> findByUsername(String username);
    // Users save(Users user);
}
