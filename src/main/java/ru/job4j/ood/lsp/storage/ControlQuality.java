package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.util.List;

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

    public List<Storage> getStorage() {
        return storages;
    }
}
