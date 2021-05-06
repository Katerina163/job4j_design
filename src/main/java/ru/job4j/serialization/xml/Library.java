package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;

public class Library {
    @XmlAttribute
    private int books;

    public Library() {
    }

    public Library(int books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" + "books=" + books
                + '\'' + '}';
    }
}
