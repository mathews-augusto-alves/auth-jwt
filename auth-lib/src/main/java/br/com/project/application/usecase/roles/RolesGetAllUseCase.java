package br.com.project.application.usecase.roles;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.project.application.service.RolesService;
import br.com.project.application.usecase.UseCase;
import br.com.project.infrastructure.adapter.mapper.MapConverter;
import br.com.project.interfaces.dto.RolesDTO;

@Service
public class RolesGetAllUseCase implements UseCase<Object, Set<RolesDTO>> {

    private static final Logger logger = LoggerFactory.getLogger(RolesGetAllUseCase.class);

    private final RolesService rolesService;
    private final MapConverter mapConverter;

    public RolesGetAllUseCase(RolesService rolesService, MapConverter mapConverter) {
        this.rolesService = rolesService;
        this.mapConverter = mapConverter;
    }

    @Override
    public Set<RolesDTO> execute(Object request) {
        logger.info("Executing RolesGetAllUseCase with request: {}", request);
        Set<RolesDTO> rolesDTOSet = mapConverter.convertSetToSet(rolesService.getAll(), RolesDTO.class);
        logger.info("RolesGetAllUseCase executed successfully, retrieved {} roles", rolesDTOSet.size());
        return rolesDTOSet;
    }
}
