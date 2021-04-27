package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            boolean status = true;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.equals("")) {
                    line = in.readLine();
                }
                String[] parts = line.split(" ");
                if (status && (parts[0].startsWith("4") || parts[0].startsWith("5"))) {
                    out.print(parts[0] + " " + parts[1]);
                    status = false;
                } else if (!status && (parts[0].startsWith("2") || parts[0].startsWith("3"))) {
                    out.println(";" + parts[1]);
                    status = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analiz = new Analizy();
        analiz.unavailable(".\\data\\analiz.txt", ".\\data\\analiz_result.txt");
    }
}
