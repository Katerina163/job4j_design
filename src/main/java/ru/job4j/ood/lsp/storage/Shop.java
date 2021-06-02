package ru.job4j.ood.lsp.storage;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Shop implements Storage {
    private Queue<Food> queue;

    public Shop() {
        queue = new PriorityQueue<>(11, new Comparator<Food>() {
            @Override
            public int compare(Food food1, Food food2) {
                return food1.expiryDate.compareTo(food2.expiryDate);
            }
        });
    }

    @Override
    public void add(Food food) {
        queue.add(food);
    }

    @Override
    public Queue<Food> getQueue() {
        return queue;
    }
}
