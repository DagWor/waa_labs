package edu.miu.lab.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
    @NotNull
    private String isbn;
    @NotNull
    @Size(min = 2, max = 20)
    private String author;
    @NotNull
    @Size(min = 1, max = 50)
    private String title;
    @NotNull
    private double price;

    public Book(String isbn, String author, String title, double price) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
