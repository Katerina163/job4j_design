package ru.job4j.ood.lsp.storage;

import java.util.*;

public class ControlQuality {
    private List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void keep(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.add(food);
            }
            if (!storage.accept(storage.getQueue().peek())) {
                resort(storage);
            }
        }
    }

    private void resort(Storage storage) {
        Queue<Food> queue = new LinkedList<>(storage.getQueue());
        storage.setQueue(new PriorityQueue<>(11, new Comparator<Food>() {
            @Override
            public int compare(Food food1, Food food2) {
                return food1.expiryDate.compareTo(food2.expiryDate);
            }
        }));
        for (Food food : queue) {
            keep(food);
        }
    }

    public List<Storage> getStorage() {
        return storages;
    }
}
