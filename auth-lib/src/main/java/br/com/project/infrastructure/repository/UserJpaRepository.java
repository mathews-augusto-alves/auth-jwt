package br.com.project.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.domain.user.model.Users;
import br.com.project.domain.user.repository.UsersRepository;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, UUID>, UsersRepository {
}
