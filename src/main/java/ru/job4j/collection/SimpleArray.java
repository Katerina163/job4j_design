package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int count = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = (T[]) new Object[10];
    }

    public SimpleArray(int i) {
        this.container = (T[]) new Object[i];
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        if (count == container.length) {
            increase();
        }
        modCount++;
        container[count++] = model;
    }

    private void increase() {
        Objects[] array = new Objects[count * 2];
        System.arraycopy(container, 0, array, 0, container.length);
        this.container = array;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        container[index] = model;
        modCount++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        count--;
        modCount++;
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[point++];
            }
        };
    }
}
