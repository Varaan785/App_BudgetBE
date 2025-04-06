package org.exampleVaraan.service;



import org.exampleVaraan.entity.Ausgabe;
import org.exampleVaraan.repository.AusgabeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AusgabeService {

    private final AusgabeRepository ausgabeRepository;

    @Autowired
    public AusgabeService(AusgabeRepository ausgabeRepository) {
        this.ausgabeRepository = ausgabeRepository;
    }

    public List<Ausgabe> getAll() {
        return ausgabeRepository.findAll();
    }

    public Ausgabe create(Ausgabe ausgabe) {
        return ausgabeRepository.save(ausgabe);
    }

    public void delete(Long id) {
        ausgabeRepository.deleteById(id);
    }
}