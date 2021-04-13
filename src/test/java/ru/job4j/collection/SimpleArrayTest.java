package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}