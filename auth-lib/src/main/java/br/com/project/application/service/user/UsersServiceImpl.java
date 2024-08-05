package br.com.project.application.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.application.service.UserService;
import br.com.project.domain.user.model.Users;
import br.com.project.infrastructure.repository.UserJpaRepository;

@Service
public class UsersServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UsersServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        Optional<Users> result = userJpaRepository.findByUsername(username);
        return result;
    }

    @Override
    public Users saveUser(Users user) {
        return userJpaRepository.save(user);
    }
}
