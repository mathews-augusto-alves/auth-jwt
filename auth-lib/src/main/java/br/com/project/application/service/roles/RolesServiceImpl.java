package br.com.project.application.service.roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.project.application.service.RolesService;
import br.com.project.domain.roles.model.Roles;
import br.com.project.domain.roles.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Roles saveRole(Roles role) {
        return rolesRepository.save(role);
    }

    @Override
    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

}
