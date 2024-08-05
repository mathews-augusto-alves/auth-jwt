package br.com.project.application.usecase.roles;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.project.application.service.RolesService;
import br.com.project.application.usecase.UseCase;
import br.com.project.infrastructure.adapter.mapper.MapConverter;
import br.com.project.interfaces.dto.RolesDTO;

@Service
public class RolesGetAllUseCase implements UseCase<Object, Set<RolesDTO>>{

    private final RolesService rolesService;
    private final MapConverter mapConverter;

    public RolesGetAllUseCase(RolesService rolesService, MapConverter mapConverter) {
        this.rolesService = rolesService;   
        this.mapConverter = mapConverter;
    }

    @Override
    public Set<RolesDTO> execute(Object request) {
        return mapConverter.convertSetToSet(rolesService.getAll(), RolesDTO.class);
    }

}
