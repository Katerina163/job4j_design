package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Analizy {
    private List<String> list = new ArrayList<>();

    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            list = in.lines()
                    .filter(s -> s.contains("00"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (int i = 0; i < list.size(); i++) {
                StringBuilder sb = new StringBuilder();
                if (list.get(i).startsWith("4") || list.get(i).startsWith("5")) {
                    sb.append(list.get(i));
                    sb.append(";");
                    String[] array = list.get(i + 1)
                            .substring(4)
                            .split(":");
                    if (!array[2].equals("00")) {
                        int integer = Integer.parseInt(array[2]) - 1;
                        sb.append(array[0]);
                        sb.append(":");
                        sb.append(array[1]);
                        sb.append(":");
                        fill(sb, integer);
                    } else if (!array[1].equals("00")) {
                        int integer = Integer.parseInt(array[1]) - 1;
                        sb.append(array[0]);
                        sb.append(":");
                        fill(sb, integer);
                        sb.append(":");
                        sb.append("59");
                    } else if (!array[0].equals("00")) {
                        int integer = Integer.parseInt(array[0]) - 1;
                        fill(sb, integer);
                        sb.append(":");
                        sb.append("59");
                        sb.append(":");
                        sb.append("59");
                    } else {
                        sb.append("23:59:59");
                    }
                }
                if (sb.length() != 0) {
                    out.println(sb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fill(StringBuilder sb, int integer) {
        if (integer >= 10) {
            sb.append(integer);
        } else {
            sb.append("0");
            sb.append(integer);
        }
    }
}
