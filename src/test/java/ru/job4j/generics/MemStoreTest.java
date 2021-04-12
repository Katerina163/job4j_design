package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void replace() {
        User u = new User("user");
        User u2 = new User("user");
        MemStore<User> mem = new MemStore<>();
        mem.add(u);
        mem.replace("user", u2);
        assertThat(mem.findById("user"), is(u2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete() {
        User u = new User("user");
        MemStore<User> mem = new MemStore<>();
        mem.add(u);
        mem.delete("user");
        mem.findById("user");
    }

    @Test
    public void findById() {
        User u = new User("user");
        MemStore<User> mem = new MemStore<>();
        mem.add(u);
        assertThat(mem.findById("user"), is(u));
    }
}