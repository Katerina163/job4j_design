package ru.job4j.ood.lsp.storage;

import java.util.Queue;

public interface Storage {
    boolean accept(Food food);

    void add(Food food);

    Queue<Food> getQueue();
}