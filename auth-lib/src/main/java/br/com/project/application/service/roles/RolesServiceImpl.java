package br.com.project.application.service.roles;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import br.com.project.application.service.RolesService;
import br.com.project.domain.roles.model.Roles;
import br.com.project.domain.roles.repository.RolesRepository;

/**
 * Implementation of the RolesService interface.
 * Provides methods for managing roles.
 */
@Service
public class RolesServiceImpl implements RolesService {

    private static final Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);

    private final RolesRepository rolesRepository;

    /**
     * Constructs a RolesServiceImpl with the specified RolesRepository.
     *
     * @param rolesRepository the repository used for accessing role data
     */
    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    /**
     * Saves a role to the repository.
     *
     * @param role the role to save
     * @return the saved role
     */
    @Override
    public Roles saveRole(Roles role) {
        try {
            return rolesRepository.save(role);
        } catch (DataAccessException e) {
            logger.error("Error saving role: {}", role, e);
            throw new RuntimeException("Failed to save role", e);
        }
    }

    /**
     * Retrieves all roles from the repository.
     *
     * @return a list of all roles
     */
    @Override
    public List<Roles> getAll() {
        try {
            return rolesRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("Error retrieving roles", e);
            throw new RuntimeException("Failed to retrieve roles", e);
        }
    }
}
