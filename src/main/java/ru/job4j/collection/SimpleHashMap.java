package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Map<K, V> {
    private Object[] container;
    private Object[] keyContainer;
    private int count = 0;
    private int modCount = 0;

    public SimpleHashMap() {
        this.container = new Object[2];
        this.keyContainer = new Object[2];
    }

    @Override
    public boolean insert(K key, V value) {
        if (count == container.length) {
            increase();
        }
        if (key == null) {
            if (container[0] != null && container[0] != value) {
                return false;
            }
            container[0] = value;
        } else {
            int i = key.hashCode() & (container.length - 1);
            if (container[i] != null && container[i] != value) {
                return false;
            }
            container[i] = value;
            keyContainer[i] = key;
        }
        count++;
        modCount++;
        return true;
    }

    private void increase() {
        Object[] array = new Object[container.length * 2];
        Object[] keyArray = new Object[keyContainer.length * 2];
        if (keyContainer[0] != null) {
            array[0] = container[0];
        }
        for (int index = 1; index < keyContainer.length; index++) {
            if (keyContainer[index] != null) {
                int i = keyContainer[index].hashCode() & (array.length - 1);
                array[i] = container[index];
                keyArray[i] = keyContainer[index];
            }
        }
        container = array;
        keyContainer = keyArray;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return (V) container[0];
        }
        int i = key.hashCode() & (container.length - 1);
        return (V) container[i];
    }

    @Override
    public boolean delete(K key) {
        count--;
        modCount++;
        if (key == null) {
            container[0] = null;
            return true;
        }
        int i = key.hashCode() & (container.length - 1);
        container[i] = null;
        keyContainer[i] = null;
        return true;
    }

    public Iterator<V> iteratorValue() {
        return new Iterator<V>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (V) container[point++];
            }
        };
    }

    public Iterator<K> iteratorKey() {
        return new Iterator<K>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (K) keyContainer[point++];
            }
        };
    }
}
