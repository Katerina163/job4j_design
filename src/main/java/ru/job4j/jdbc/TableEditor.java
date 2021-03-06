package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void makeChanges(String string) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(string);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Path file = Paths.get("./data/app.properties");
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file.toString()))) {
            list = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(list.get(0), list.get(1), list.get(2));
    }

    public void createTable(String tableName) {
        String str = String.format(
                "create table if not exists %s();",
                    tableName
        );
        makeChanges(str);
    }

    public void dropTable(String tableName) {
        String str = String.format(
                "drop table %s;",
                tableName
        );
        makeChanges(str);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String str = String.format(
                    "alter table %s add column %s %s;",
                    tableName, columnName, type
        );
        makeChanges(str);
    }

    public void dropColumn(String tableName, String columnName) {
        String str = String.format(
                "alter table %s drop column %s;",
                tableName, columnName
        );
        makeChanges(str);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String str = String.format(
                "alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName
        );
        makeChanges(str);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
