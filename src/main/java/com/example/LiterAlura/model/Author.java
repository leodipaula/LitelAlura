package com.example.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private Integer death;
    private Integer birth;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> book;

    public Author() {}

    public Author(AuthorData authorData) {
        this.author = authorData.name();
        this.death = authorData.death();
        this.birth = authorData.birth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getBirth() {
        return birth;
    }

    public Integer getDeath() {
        return death;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        book.forEach(b -> b.setAuthor(this));
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author='" + author + '\'' +
                ", death=" + death +
                ", birth=" + birth +
                '}';
    }
}
