package ru.job4j.dreamjob.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Vacancy;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository
public class MemoryVacancyRepository implements VacancyRepository {
    @Override
    public Vacancy save(Vacancy vacancy) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return false;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Vacancy> findAll() {
        return null;
    }


}