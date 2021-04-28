package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte by = 1;
        short s = 12;
        char c = 'c';
        int i = 66;
        long l = 99L;
        float f = 1.2F;
        double d = 1.3D;
        boolean bo = true;
        LOG.debug(
                "byte : {}, short : {}, char : {}, int : {}, long : {}, float : {}, double : {}, boolean : {}",
                by, s, c, i, l, f, d, bo);
    }
}
