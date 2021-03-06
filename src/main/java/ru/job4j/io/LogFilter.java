package ru.job4j.io;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {

    public static List<String> filter(String file) {
        try (BufferedReader buff = new BufferedReader(new FileReader(file))) {
            return buff.lines().filter(s -> s.contains("404")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
