package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data[column].length == 0) {
            column++;
            if (column == data.length) {
                return false;
            }
        }
        return column < data.length && row < data[column].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer i = data[column][row];
        if (row == data[column].length - 1) {
            row = 0;
            column++;
        } else {
            row++;
        }
        return i;
    }
}
