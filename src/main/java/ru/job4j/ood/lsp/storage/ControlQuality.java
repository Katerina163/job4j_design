package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {
    private Storage storage;

    public void keep(Food food) {
        long diffAllDays = DAYS.between(food.createDate, food.expiryDate);
        long diffNowDays = DAYS.between(LocalDate.now(), food.expiryDate);
        long shelfLife = (100 * diffNowDays) / diffAllDays;
        if (shelfLife <= 0) {
            if (storage == null || storage.getClass() != Trash.class) {
                storage = new Trash();
            }
            storage.add(food);
        } else if (shelfLife < 75) {
             if (shelfLife < 25) {
                 food.setDiscount(Math.round(food.getPrice() * 0.5));
             }
            if (storage == null || storage.getClass() != Shop.class) {
                storage = new Shop();
            }
            storage.add(food);
        } else {
            if (storage == null || storage.getClass() != Warehouse.class) {
                storage = new Warehouse();
            }
            storage.add(food);
        }
    }

    public Storage getStorage() {
        return storage;
    }
}
