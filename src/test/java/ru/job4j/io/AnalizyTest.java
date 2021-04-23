package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void test() {
        Analizy analiz = new Analizy();
        analiz.unavailable(".\\data\\analiz.txt", ".\\data\\analiz_result.txt");
        List<String> result = new ArrayList<>();
        result.add("500 10:57:01;10:58:00");
        result.add("400 10:58:01;10:58:59");
        result.add("500 11:01:02;10:59:59");
        result.add("500 10:57:01;23:59:59");
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(".\\data\\analiz_result.txt"))) {
            list = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(list.get(0), is(result.get(0)));
        assertThat(list.get(1), is(result.get(1)));
        assertThat(list.get(2), is(result.get(2)));
        assertThat(list.get(3), is(result.get(3)));
    }
}