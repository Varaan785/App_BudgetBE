package org.exampleVaraan.repository;



import org.exampleVaraan.entity.Ausgabe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AusgabeRepository extends JpaRepository<Ausgabe, Long> {
    // Spring JPA gibt dir automatisch alle CRUD-Methoden
}