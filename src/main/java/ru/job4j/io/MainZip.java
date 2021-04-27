package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainZip {
    private ArgsName argsName = new ArgsName();

    public void toZip(String[] args) throws IOException {
        this.argsName = ArgsName.of(args);
        if (argsName.get("d") == null
                || argsName.get("e") == null
                || argsName.get("o") == null) {
            throw new IllegalArgumentException();
        }
        List<Path> list = Search.search(Path.of(argsName.get("d")),
                s -> s.toFile().getName().endsWith(argsName.get("e")));
        Zip.packFiles(list, new File(argsName.get("o")));
    }
}
