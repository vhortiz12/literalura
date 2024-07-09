package com.alura.challenge_literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorRecord(String name,
                          int birth_year,
                          int death_year) {
}
