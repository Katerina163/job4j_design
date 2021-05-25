package ru.job4j.serialization;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 22000; i++) {
            new User(i, String.valueOf(i));
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", id, name);
    }
}
