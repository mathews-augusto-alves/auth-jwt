package br.com.project.domain.roles.repository;

import java.util.List;
import java.util.Optional;

import br.com.project.domain.roles.model.Roles;


public interface RolesRepository {
    Optional<Roles> findByName(String name);
    Roles save(Roles Roles);
    List<Roles> findAll();
}
