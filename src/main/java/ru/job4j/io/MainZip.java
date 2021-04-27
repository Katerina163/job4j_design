package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainZip {

    public void toZip(ArgsName argsName) throws IOException {
        List<Path> list = Search.search(Path.of(argsName.get("d")),
                s -> s.toFile().getName().endsWith(argsName.get("e")));
        Zip.packFiles(list, new File(argsName.get("o")));
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException();
        }
        MainZip main = new MainZip();
        ArgsName arg = ArgsName.of(args);
        main.toZip(arg);
    }
}
