package ru.job4j.cache;

public class Emulator {
    private AbstractCache<String, String> cache;

    public Emulator(AbstractCache<String, String> cache) {
        this.cache = cache;
    }

    public void cacheDir(String directory) {
        cache = new DirFileCache(directory);
    }

    public void loadCache(String name) {
        cache.put(name, cache.load(name));
    }

    public String getCache(String name) {
        return cache.get(name);
    }

    public static void main(String[] args) {
        AbstractCache<String, String> ac = new DirFileCache("./data");
        Emulator e = new Emulator(ac);
        e.loadCache("names.txt");
        System.out.println(e.getCache("names.txt"));
        e.cacheDir("./data/new");
        System.out.println(e.getCache("address.txt"));
    }
}