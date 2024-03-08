package com.example.document;

import com.example.catalog.Searchable;

public class WebPage implements Searchable {

    private String address;
    private String title;
    private String contents;

    public WebPage(String address, String title, String contents) {
        this.address = address;
        this.contents = contents;
        this.title = title;
    };

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String getDisplayName() {
        return this.address;
    }

    @Override
    public String prepareSearchableString() {
        return "WebPage{" +
                "address='" + address + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
