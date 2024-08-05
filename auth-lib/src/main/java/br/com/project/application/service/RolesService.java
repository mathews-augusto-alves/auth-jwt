package br.com.project.application.service;

import java.util.List;

import br.com.project.domain.roles.model.Roles;

public interface RolesService {

    Roles saveRole(Roles role);
    List<Roles> getAll();
}
