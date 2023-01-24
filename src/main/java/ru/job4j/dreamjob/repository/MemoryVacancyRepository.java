package ru.job4j.dreamjob.repository;

import ru.job4j.dreamjob.model.Vacancy;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryVacancyRepository implements VacancyRepository {

    private static final MemoryVacancyRepository INSTANCE = new MemoryVacancyRepository();

    private int nextId = 1;

    private final Map<Integer, Vacancy> vacancies = new HashMap<>();

    public MemoryVacancyRepository() {
        save(new Vacancy(0, "Intern Java Developer", "Intern Java Developer", LocalDateTime.of(2023,
                Month.JANUARY, 01, 15, 30, 00)));
        save(new Vacancy(0, "Junior Java Developer", "Junior Java Developer", LocalDateTime.of(2023,
                Month.JANUARY, 01, 15, 30, 00)));
        save(new Vacancy(0, "Junior+ Java Developer", "Junior+ Java Developer", LocalDateTime.of(2023,
                Month.JANUARY, 01, 15, 30, 00)));
        save(new Vacancy(0, "Middle Java Developer", "Middle Java Developer", LocalDateTime.of(2023,
                Month.JANUARY, 01, 15, 30, 00)));
        save(new Vacancy(0, "Middle+ Java Developer", "Middle+ Java Developer", LocalDateTime.of(2023,
                Month.JANUARY, 01, 15, 30, 00)));
        save(new Vacancy(0, "Senior Java Developer", "Senior Java Developer", LocalDateTime.of(2023,
                Month.JANUARY, 01, 15, 30, 00)));
    }

    public static MemoryVacancyRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Vacancy save(Vacancy vacancy) {
        vacancy.setId(nextId++);
        vacancies.put(vacancy.getId(), vacancy);
        return vacancy;
    }

    @Override
    public boolean deleteById(int id) {
        return vacancies.remove(id) != null;
    }

    @Override
    public boolean update(Vacancy vacancy) {
        return vacancies.computeIfPresent(vacancy.getId(), (id, oldVacancy) -> new Vacancy(oldVacancy.getId(), vacancy.getTitle(), vacancy.getDescription(), vacancy.getCreationDate())) != null;
    }

    @Override
    public Optional<Vacancy> findById(int id) {
        return Optional.ofNullable(vacancies.get(id));
    }

    @Override
    public Collection<Vacancy> findAll() {
        return vacancies.values();
    }

}