package br.com.project.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.domain.roles.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, UUID>, br.com.project.domain.roles.repository.RolesRepository {

}
