package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        mem.set(findIndexById(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        mem.remove(findIndexById(id));
        return true;
    }

    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public int findIndexById(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return mem.indexOf(t);
            }
        }
        return -1;
    }
}
