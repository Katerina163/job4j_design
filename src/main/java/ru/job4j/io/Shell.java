package ru.job4j.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shell {
    private List<String> adress = new ArrayList();

    public void cd(String path) {
        String[] s = path.split("/");
        if (adress.isEmpty()) {
            for (String string : s) {
                if (!string.isEmpty()) {
                    adress.add(string);
                }
            }
        } else {
            if (s[0].equals("..")) {
                adress = new ArrayList<>();
                if (s.length > 1) {
                    adress.addAll(Arrays.asList(s).subList(1, s.length));
                }
            } else {
                boolean b = false;
                for (String string : s) {
                    if (adress.contains(string)) {
                        b = true;
                        break;
                    }
                }
                if (b) {
                    adress = new ArrayList<>();
                    cd(path);
                } else {
                    for (String string : s) {
                        if (!string.isEmpty()) {
                            adress.add(string);
                        }
                    }
                }
            }
        }
    }

    public String pwd() {
        StringBuilder sb = new StringBuilder();
        for (String s : adress) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() != 0 ? sb.toString() : "/";
    }
}
