package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V result = cache.get(key).get();
        if (result == null) {
            V value = load(key);
            cache.put(key, new SoftReference<>(value));
            result = cache.get(key).get();
        }
        return result;
    }

    protected abstract V load(K key);
}
