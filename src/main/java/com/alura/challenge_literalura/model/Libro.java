package com.alura.challenge_literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "libro_autor",joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> authors;

    @ElementCollection
    private List<String> languages;

    private Double download_count;

    public Libro(){}

    public Libro(String title, List<Autor> authors, List<String> languages, Double download_count) {
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.download_count = download_count;
    }

    // Getters y setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Double getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Double download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Título:'" + title + '\'' +
                ", Autor(es):" + authors +
                ", Idiomas:" + languages +
                ", Número de descargas:" + download_count +
                '}';
    }
}
