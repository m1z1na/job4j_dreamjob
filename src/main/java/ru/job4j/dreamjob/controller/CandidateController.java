package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.dreamjob.Repository.CandidateRepository;
import ru.job4j.dreamjob.Repository.MemoryCandidateRepository;
import ru.job4j.dreamjob.Repository.MemoryVacancyRepository;
import ru.job4j.dreamjob.Repository.VacancyRepository;


@Controller
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateRepository  candidateRepository = MemoryCandidateRepository.getInstance();

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("candidates",candidateRepository.findAll());
        return "/candidates/list";
    }

}