package com.example.document;

import com.example.catalog.Searchable;

public class Document implements Searchable {
    private String serialNumber;
    private String subject;
    private String contents;

    public Document(String serialNumber, String subject, String contents) {
        this.serialNumber = serialNumber;
        this.subject = subject;
        this.contents = contents;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String getDisplayName() {
        return this.serialNumber;
    }


    @Override
    public String prepareSearchableString() {
        return "Document{" +
                "serialNumber='" + serialNumber + '\'' +
                ", subject='" + subject + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
