package com.alura.challenge_literalura.repository;

import com.alura.challenge_literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    Libro findByTitle(String title);
    Optional<Libro> findByTitleContainsIgnoreCase(String title);

    @Query("SELECT l FROM Libro l WHERE :language MEMBER OF l.languages")
    List<Libro> findByLanguage(@Param("language") String language);
}
