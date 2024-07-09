package com.alura.challenge_literalura.repository;

import com.alura.challenge_literalura.model.Autor;
import com.alura.challenge_literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.birthYear <= :ano AND a.deathYear >= :ano")
    List<Autor> findAutoresVivosEnAno(@Param("ano") int ano);
}
