package ru.job4j.serialization.json;

public class Library {
    private int books;

    public Library(int books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" + "books=" + books
                + '\'' + '}';
    }

    public int getBooks() {
        return books;
    }
}
