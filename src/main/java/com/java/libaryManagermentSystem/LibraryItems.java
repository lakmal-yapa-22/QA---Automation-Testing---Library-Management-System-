package com.java.libaryManagermentSystem;

import java.io.Serializable;

public abstract class LibraryItems implements Serializable {
    String title;
    String author;
    String serialNumber;
    protected boolean isBorrowed;

    public LibraryItems(String title, String author, String serialNumber) {
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.isBorrowed = false;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public abstract void borrowItem(User user);
}
