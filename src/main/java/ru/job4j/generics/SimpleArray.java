package ru.job4j.generics;

import org.hamcrest.internal.ArrayIterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private T[] array;

    public SimpleArray(Class<T> t, int i) {
        @SuppressWarnings("unchecked")
        final T[] array = (T[]) Array.newInstance(t, i);
        this.array = array;
    }

    public void add(T model) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = model;
                break;
            }
        }
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, array.length);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, array.length);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }

    public T get(int index) {
        Objects.checkIndex(index, array.length);
        return array[index];
    }

    @Override
    public Iterator iterator() {
        return Arrays.asList(array).iterator();
    }
}
