package com.example.LiterAlura.model;

import com.example.LiterAlura.services.ConsumerAPI;
import com.example.LiterAlura.services.ConvertsData;

import java.util.Optional;

public class SearchBookAndAuthor {
    private String title;
    private final ConsumerAPI consumer = new ConsumerAPI();
    private final ConvertsData converter = new ConvertsData();
    private String address;

    public SearchBookAndAuthor(String title) {
        this.title = title;
        this.address = "https://gutendex.com/books?search="
                + title.trim()
                .replace(" ", "%20");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private ResultsData getBookAndAuthorsData() {
        var json = consumer.getData(address);
        return converter.converterData(json, ResultsData.class);
    }

    public Optional<Author> search() {
        ResultsData result = getBookAndAuthorsData();
        return Optional.of(new Author(result));
    }
}