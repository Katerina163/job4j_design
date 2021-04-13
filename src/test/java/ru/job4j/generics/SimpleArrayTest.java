package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void addInt() {
        SimpleArray<Integer> ex = new SimpleArray<>(2);
        ex.add(1);
        ex.add(2);
        assertThat(1, is(ex.get(0)));
        assertThat(2, is(ex.get(1)));
    }

    @Test
    public void addString() {
        SimpleArray<String> ex = new SimpleArray<>(2);
        ex.add("1");
        ex.add("2");
        assertThat("1", is(ex.get(0)));
        assertThat("2", is(ex.get(1)));
    }

    @Test
    public void addNull() {
        SimpleArray<String> ex = new SimpleArray<>(2);
        ex.add(null);
        assertNull(ex.get(0));
    }

    @Test
    public void setInt() {
        SimpleArray<Integer> ex = new SimpleArray<>(2);
        ex.add(1);
        ex.set(0, 2);
        assertThat(2, is(ex.get(0)));
    }

    @Test
    public void removeInt() {
        SimpleArray<Integer> ex = new SimpleArray<>(4);
        ex.add(1);
        ex.add(2);
        ex.add(3);
        ex.add(4);
        ex.remove(1);
        assertThat(3, is(ex.get(1)));
    }
}