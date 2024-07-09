package com.alura.challenge_literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroRecord(String title,
                          List<AutorRecord> authors,
                          List<String> languages,
                          Double download_count) {
}
