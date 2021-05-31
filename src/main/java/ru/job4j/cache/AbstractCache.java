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
        V result = cache.getOrDefault(key, new SoftReference<V>(null)).get();
        if (result == null) {
            result = load(key);
            cache.put(key, new SoftReference<>(result));
        }
        return result;
    }

    protected abstract V load(K key);
}
