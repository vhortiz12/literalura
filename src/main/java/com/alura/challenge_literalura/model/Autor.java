package com.alura.challenge_literalura.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int birthYear;
    private int deathYear;

    @ManyToMany(mappedBy = "authors")
    private List<Libro> libros;

    public Autor(){}

    public Autor(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }
    // Getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "Nombre:'" + name + '\'' +
                ", Año de nacimiento:" + birthYear +
                ", Año de fallecimiento:" + deathYear +
                '}';
    }
}
