package ru.job4j.dreamjob.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository
public class MemoryCandidateRepository  implements CandidateRepository {
    @Override
    public Candidate save(Candidate candidate) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(Candidate candidate) {
        return false;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Candidate> findAll() {
        return null;
    }


}