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
        if (!cache.containsKey(key) || cache.get(key).get() == null) {
            V value = load(key);
            cache.put(key, new SoftReference<>(value));
        }
        V result = cache.get(key).get();
        return result;
    }

    protected abstract V load(K key);
}
