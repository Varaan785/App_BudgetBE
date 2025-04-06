package org.exampleVaraan.controller;


import org.exampleVaraan.entity.Ausgabe;
import org.exampleVaraan.service.AusgabeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ausgaben")
@CrossOrigin(origins = "*") // Für dein Frontend (z. B. React)
public class AusgabeController {

    @Autowired
    private AusgabeService ausgabeService;

    @GetMapping
    public List<Ausgabe> getAll() {
        return ausgabeService.getAll();
    }

    @PostMapping
    public Ausgabe create(@RequestBody Ausgabe ausgabe) {
        return ausgabeService.create(ausgabe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ausgabeService.delete(id);
    }
}