package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, p -> p.toFile().getName().endsWith("js")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static class SearchFiles extends SimpleFileVisitor<Path> {
        List<Path> list = new ArrayList<>();
        Predicate<Path> condition;

        public SearchFiles(Predicate<Path> condition) {
            this.condition = condition;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (this.condition.test(file)) {
                list.add(file);
            }
            return CONTINUE;
        }

        public List<Path> getPaths() {
            return list;
        }
    }
}
