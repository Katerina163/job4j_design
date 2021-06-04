package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
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
                break;
            }
        }
    }

    public void resort() {
        Queue<Food> queue = new LinkedList<>();
        for (Storage storage : storages) {
            queue.addAll(storage.getQueue());
            storage.setQueue(new PriorityQueue<>(11, new Comparator<Food>() {
                @Override
                public int compare(Food food1, Food food2) {
                    return food1.expiryDate.compareTo(food2.expiryDate);
                }
            }));
        }
    }

    public List<Storage> getStorage() {
        return storages;
    }
}
