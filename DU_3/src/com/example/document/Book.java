package com.example.document;

import com.example.catalog.Searchable;

public class Book implements Searchable  {
    private String name;
    private String isbn;
    private String publisher;
    private String year;
    private int numberOfPages;

    public Book(String name, String isbn, String publisher, String year, int numberOfPages) {
        this.name = name;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String getDisplayName() {
        return this.name;
    }

    @Override
    public String prepareSearchableString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
