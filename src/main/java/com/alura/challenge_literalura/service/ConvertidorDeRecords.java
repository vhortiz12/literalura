package com.alura.challenge_literalura.service;

import com.alura.challenge_literalura.model.Autor;
import com.alura.challenge_literalura.model.AutorRecord;
import com.alura.challenge_literalura.model.Libro;
import com.alura.challenge_literalura.model.LibroRecord;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertidorDeRecords {

    public Libro convertirLibroRecordALibro(LibroRecord libroRecord) {
        List<Autor> autores = libroRecord.authors().stream()
                .map(this::convertirAutorRecordAAutor)
                .collect(Collectors.toList());

        return new Libro(
                libroRecord.title(),
                autores,
                libroRecord.languages(),
                libroRecord.download_count()
        );
    }

    public Autor convertirAutorRecordAAutor(AutorRecord autorRecord) {
        Autor autor = new Autor();
        autor.setName(autorRecord.name());
        autor.setBirthYear(autorRecord.birth_year());
        autor.setDeathYear(autorRecord.death_year());
        return autor;
    }

}
