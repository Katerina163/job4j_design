package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] array;
    private int point;

    public EvenIterator(int[] numbers) {
        array = numbers;
        point = 0;
    }

    @Override
    public boolean hasNext() {
        if (point == array.length) {
            return false;
        }
        while (array[point] % 2 != 0) {
            point++;
            if (point == array.length) {
                return false;
            }
        }
        return point < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[point++];
    }
}
