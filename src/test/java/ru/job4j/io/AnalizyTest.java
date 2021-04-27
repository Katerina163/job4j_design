package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        Analizy analiz = new Analizy();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator() + System.lineSeparator()
                      + "500 10:57:01" + System.lineSeparator() + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator() + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator() + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator() + System.lineSeparator()
                    + "200 11:02:02" + System.lineSeparator() + System.lineSeparator()
            );
        }
        analiz.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(target))) {
            list = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(list.get(0), is("500 10:57:01;10:59:01"));
        assertThat(list.get(1), is("500 11:01:02;11:02:02"));
    }
}