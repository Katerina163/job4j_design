package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> set = new HashSet<>();
    private List<Path> listDouble = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(
                new File(file.getFileName().toString()).length(),
                         file.getFileName().toString()
        );
        if (!set.contains(fileProperty)) {
            set.add(fileProperty);
        } else {
            listDouble.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public void getDouble() {
        for (var v : listDouble) {
            System.out.println(v.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), duplicatesVisitor);
        duplicatesVisitor.getDouble();
    }
}
