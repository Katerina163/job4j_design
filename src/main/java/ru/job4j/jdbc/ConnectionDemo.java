package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectionDemo {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        readFile();
        try (Connection connection = DriverManager.getConnection(list.get(0), list.get(1), list.get(2))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    private static void readFile() {
        Path file = Paths.get("./data/app.properties");
        try (BufferedReader in = new BufferedReader(new FileReader(file.toString()))) {
            list = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
