package ru.job4j.mail;

import java.util.Set;

public class User {
    private String name;
    private Set<String> mails;

    public User() {
    }

    public User(String name, Set<String> mails) {
        this.name = name;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public Set<String> getMails() {
        return mails;
    }

    public void addMail(String mail) {
        mails.add(mail);
    }
}
