package br.com.project.application.service.user;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import br.com.project.application.service.UserService;
import br.com.project.domain.user.model.Users;
import br.com.project.infrastructure.repository.UserJpaRepository;

@Service
public class UsersServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);
    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UsersServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        try {
            return userJpaRepository.findByUsername(username);
        } catch (DataAccessException e) {
            logger.error("Error finding user by username: {}", username, e);
            throw new RuntimeException("Failed to find user by username", e);
        }
    }

    @Override
    public Users saveUser(Users user) {
        try {
            return userJpaRepository.save(user);
        } catch (DataAccessException e) {
            logger.error("Error saving user: {}", user, e);
            throw new RuntimeException("Failed to save user", e);
        }
    }
}
