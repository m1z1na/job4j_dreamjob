package ru.job4j.dreamjob.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.dreamjob.model.File;
import ru.job4j.dreamjob.model.User;

import java.util.Optional;
@Slf4j
@Repository
public class Sql2oUserRepository implements UserRepository {

    private final Sql2o sql2o;

    public Sql2oUserRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<User> save(User user) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("INSERT INTO users (email, password, name) VALUES (:email, :password, :name)", true)
                    .addParameter("email", user.getEmail())
                    .addParameter("name", user.getName())
                    .addParameter("password", user.getPassword());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            user.setId(generatedId);
            return Optional.of(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM users WHERE email = :email AND password = :password");
            var user = query.addParameter("email", email).addParameter("password", password).executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);

        }
    }

    @Override
    public void deleteAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("DELETE FROM users");
            query.executeUpdate().getResult();
        }
    }
}