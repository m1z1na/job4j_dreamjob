package ru.job4j.dreamjob.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.repository.CityRepository;
import ru.job4j.dreamjob.repository.MemoryCandidateRepository;
import ru.job4j.dreamjob.repository.CandidateRepository;

import java.util.Collection;
import java.util.Optional;
@Service
@ThreadSafe
public class SimpleCandidateService implements CandidateService {

    private final CandidateRepository candidateRepository;

    public SimpleCandidateService(CandidateRepository sql2oCandidateRepository) {
        this.candidateRepository = sql2oCandidateRepository;
    }

    @Override
    public Candidate save(Candidate vacancy) {
        return candidateRepository.save(vacancy);
    }

    @Override
    public boolean deleteById(int id) {
        return candidateRepository.deleteById(id);
    }

    @Override
    public boolean update(Candidate vacancy) {
        return candidateRepository.update(vacancy);
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Collection<Candidate> findAll() {
        return candidateRepository.findAll();
    }

}
