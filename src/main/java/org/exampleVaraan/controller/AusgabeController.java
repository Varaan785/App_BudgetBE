package org.exampleVaraan.controller;

import org.exampleVaraan.entity.Ausgabe;
import org.exampleVaraan.service.AusgabeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ausgaben")
@CrossOrigin(origins = "*")
public class AusgabeController {

    private final AusgabeService service;

    public AusgabeController(AusgabeService service) {
        this.service = service;
    }

    @PostMapping
    public Ausgabe speichern(@RequestBody Ausgabe ausgabe) {
        return service.save(ausgabe);
    }

    @GetMapping
    public List<Ausgabe> alle() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
