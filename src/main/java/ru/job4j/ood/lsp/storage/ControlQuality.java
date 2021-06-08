package ru.job4j.ood.lsp.storage;

import java.util.*;
//
//public class ControlQuality {
//    private List<Storage> storages;
//
//    public ControlQuality(List<Storage> storages) {
//        this.storages = storages;
//    }
//
//    public void keep(Food food) {
//        for (Storage storage : storages) {
//            if (storage.accept(food)) {
//                storage.add(food);
//            }
//            if (!storage.accept(storage.getQueue().peek())) {
//                resort();
//            }
//        }
//    }
//
//    public void resort() {
//        Queue<Food> queue = new LinkedList<>();
//        for (Storage storage : storages) {
//            queue.addAll(storage.getQueue());
//            storage.setQueue(new PriorityQueue<>(11, Comparator.comparing(food -> food.expiryDate)));
//        }
//        for (Food f : queue) {
//            keep(f);
//        }
//    }
//
//    public List<Storage> getStorage() {
//        return storages;
//    }
//}
