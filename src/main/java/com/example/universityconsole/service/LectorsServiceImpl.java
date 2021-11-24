package com.example.universityconsole.service;

import com.example.universityconsole.model.Lector;
import com.example.universityconsole.repository.LectorRepository;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class LectorsServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public LectorsServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public void getLectorsByCriteria(String criteria) {
        lectorRepository.findByNameContaining(criteria).stream()
                .map(Lector::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
