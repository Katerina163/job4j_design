package ru.job4j.generics;

import org.hamcrest.internal.ArrayIterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private T[] array;
    private int count = 0;

    public SimpleArray(int i) {
        this.array = (T[]) new Object[i];
    }

    public void add(T model) {
        array[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        count--;
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return array[index];
    }

    @Override
    public Iterator iterator() {
        return new Iterator<T>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
    }
}
