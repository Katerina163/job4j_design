package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable {
    private MapEntry<K, V> table;

    public SimpleHashMap() {
        this.table = new MapEntry();
    }

    public boolean insert(K key, V value) {
        return table.insert(key, value);
    }

    public V get(K key) {
        return table.get(key);
    }

    public boolean delete(K key) {
        return table.delete(key);
    }

    @Override
    public Iterator<V> iterator() {
        return table.iterator();
    }

    private static class MapEntry<K, V> implements Map<K, V>, Iterable<V> {
        private static final double LOAD_FACTOR = 0.75;
        private Object[] container;
        private Object[] keyContainer;
        private int count = 0;
        private int modCount = 0;

        public MapEntry() {
            this.container = new Object[2];
            this.keyContainer = new Object[2];
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
        public boolean insert(K key, V value) {
            if (count == container.length * LOAD_FACTOR) {
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

        @Override
        public V get(K key) {
            if (key == null) {
                return (V) container[0];
            }
            int i = key.hashCode() & (container.length - 1);
            if (keyContainer[i] == null || !keyContainer[i].equals(key)) {
                return null;
            }
            return (V) container[i];
        }

        @Override
        public boolean delete(K key) {
            if (key == null) {
                container[0] = null;
                count--;
                modCount++;
                return true;
            }
            int i = key.hashCode() & (container.length - 1);
            if (!keyContainer[i].equals(key)) {
                return false;
            }
            container[i] = null;
            keyContainer[i] = null;
            count--;
            modCount++;
            return true;
        }

        @Override
        public Iterator<V> iterator() {
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
    }
}
