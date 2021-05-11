package ru.job4j.io;

import java.util.Stack;

public class Shell {
    private Stack<String> add = new Stack<>();

    public void cd(String path) {
        String[] s = path.split("/");
        if (add.empty()) {
            absolute(s);
        } else {
            if (s[0].equals("..")) {
                s[0] = "";
                absolute(s);
            } else {
                if (s.length == 1) {
                    add.push(s[0]);
                } else {
                    absolute(s);
                }
            }
        }
    }

    private void absolute(String[] s) {
        add = new Stack<>();
        for (String string : s) {
            if (!string.isEmpty()) {
                add.push(string);
            }
        }
    }

    public String pwd() {
        StringBuilder sb = new StringBuilder();
        for (String s : add) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() != 0 ? sb.toString() : "/";
    }
}
