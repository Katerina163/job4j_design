package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void addInt() {
        SimpleHashMap<Integer, Integer> ex = new SimpleHashMap<>();
        ex.insert(1, 1);
        ex.insert(null, null);
        assertNull(ex.get(null));
        assertThat(1, is(ex.get(1)));
    }

    @Test
    public void deleteInt() {
        SimpleHashMap<Integer, Integer> ex = new SimpleHashMap<>();
        ex.insert(1, 1);
        ex.insert(2, 2);
        ex.delete(1);
        assertNull(ex.get(1));
    }

    @Test
    public void whenAddThenIt() {
        SimpleHashMap<Integer, String> ex = new SimpleHashMap<>();
        ex.insert(null, "first");
        String rsl = ex.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<Integer, Integer> ex = new SimpleHashMap<>();
        ex.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleHashMap<Integer, String> ex = new SimpleHashMap<>();
        ex.insert(1, "first");
        Iterator<String> it = ex.iterator();
        ex.insert(2, "second");
        it.next();
    }

}