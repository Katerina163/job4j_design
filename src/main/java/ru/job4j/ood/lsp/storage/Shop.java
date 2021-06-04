package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.time.temporal.ChronoUnit.DAYS;

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
    public boolean accept(Food food) {
        long diffAllDays = DAYS.between(food.createDate, food.expiryDate);
        long diffNowDays = DAYS.between(LocalDate.now(), food.expiryDate);
        long shelfLife = (100 * diffNowDays) / diffAllDays;
        if (shelfLife > 0 && shelfLife < 75) {
            if (shelfLife < 25) {
                food.setDiscount(Math.round(food.getPrice() * 0.5));
            }
            return true;
        }
        return false;
    }

    @Override
    public void add(Food food) {
        queue.add(food);
    }

    @Override
    public Queue<Food> getQueue() {
        return queue;
    }

    @Override
    public void setQueue(Queue<Food> queue) {
        this.queue = queue;
    }
}
