package com.example.document;

public class Magazine {
    private String name;
    private  String issn;
    private String publisher;
    private String year;
    private int numberOfPages;

    public Magazine(String name, String issn, String publisher, String year, int numberOfPages) {
        this.name = name;
        this.issn = issn;
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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
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
}
