package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.repository.CityRepository;
import ru.job4j.dreamjob.repository.Sql2oUserRepository;
import ru.job4j.dreamjob.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleUserService implements UserService {


    private final Sql2oUserRepository userRepository;

    public SimpleUserService(Sql2oUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}