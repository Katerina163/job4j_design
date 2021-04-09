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
        int i = point;
        while (array[i] % 2 != 0) {
            i++;
            if (i == array.length) {
                return false;
            }
        }
        return i < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (array[point] % 2 != 0) {
            point++;
        }
        return array[point++];
    }
}
