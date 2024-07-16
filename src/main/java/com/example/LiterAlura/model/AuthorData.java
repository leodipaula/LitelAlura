package com.example.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorData(String name,
                         @JsonAlias("birth_year") int birth,
                         @JsonAlias("death_year") int death) {
}
