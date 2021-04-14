package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T>{
    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < set.size(); i++) {
            if ((value == null && set.get(i) == null) || set.get(i).equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
