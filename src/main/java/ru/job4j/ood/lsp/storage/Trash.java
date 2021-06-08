package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.time.temporal.ChronoUnit.DAYS;
//
//public class Trash implements Storage {
//    private Queue<Food> queue;
//
//    public Trash() {
//        queue = new PriorityQueue<>(11, Comparator.comparing(food -> food.expiryDate));
//    }
//
//    @Override
//    public boolean accept(Food food) {
//        long diffAllDays = DAYS.between(food.createDate, food.expiryDate);
//        long diffNowDays = DAYS.between(LocalDate.now(), food.expiryDate);
//        long shelfLife = (100 * diffNowDays) / diffAllDays;
//        return shelfLife <= 0;
//    }
//
//    @Override
//    public void add(Food food) {
//        queue.add(food);
//    }
//
//    @Override
//    public Queue<Food> getQueue() {
//        return queue;
//    }
//
//    @Override
//    public void setQueue(Queue<Food> queue) {
//        this.queue = queue;
//    }
//}
