package org.exampleVaraan.service;

import org.exampleVaraan.entity.Ausgabe;
import org.exampleVaraan.repository.AusgabeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AusgabeService {

    private final AusgabeRepository repository;

    public AusgabeService(AusgabeRepository repository) {
        this.repository = repository;
    }

    public Ausgabe save(Ausgabe ausgabe) {
        return repository.save(ausgabe);
    }

    public List<Ausgabe> getAll() {
        return repository.findAll();
    }
}
