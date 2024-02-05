package com.example.libraryproject.books.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class BookDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private int pages;
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;

    public BookDTO() {
    }

    public BookDTO(String ISBN, String title, String author, int publicationYear,int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", pages=" + pages +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
