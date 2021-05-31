package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void testInt() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(1, 2, 3, 4);
        assertThat(maxMin.max(list, Comparator.naturalOrder()), is(4));
        assertThat(maxMin.min(list, Comparator.naturalOrder()), is(1));
    }

    @Test
    public void testString() {
        MaxMin maxMin = new MaxMin();
        List<String> list = List.of("a", "b", "c", "d");
        assertThat(maxMin.max(list, Comparator.naturalOrder()), is("d"));
        assertThat(maxMin.min(list, Comparator.naturalOrder()), is("a"));
    }
}