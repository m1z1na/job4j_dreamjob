package ru.job4j.dreamjob.repository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.configuration.DatasourceConfiguration;
import ru.job4j.dreamjob.model.User;
import java.util.Properties;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Sql2oUserRepositoryTest {

    private static Sql2oUserRepository sql2oUserRepository;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oUserRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");
        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oUserRepository = new Sql2oUserRepository(sql2o);

    }

    @AfterEach
    public void clearUsers() {
        sql2oUserRepository.deleteAll();
    }

    @Test
    public void whenSaveWithSameEmail() {

        var user1 = sql2oUserRepository.save(new User(0, "email3", "name3", "password"));
        assertThat(user1).isNotEmpty();
        Throwable exception = assertThrows(Exception.class, () -> {
            sql2oUserRepository.save(user1.get());
        });
        assertThat(exception.getMessage()).containsIgnoringCase("Unique index or primary key violation");
    }

    @Test
    public void whenSaveThenGetSame() {
        var user = sql2oUserRepository.save(new User(0, "email1", "name1", "password"));
        var savedUser = sql2oUserRepository.findByEmailAndPassword(user.get().getEmail(), user.get().getPassword()).get();
        assertThat(savedUser.getEmail()).isEqualTo((user.get().getEmail()));
    }


    @Test
    public void whenDontSaveThenNothingFound() {
        assertThat(sql2oUserRepository.findByEmailAndPassword("email2", "password")).isEmpty();
    }

}