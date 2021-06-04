package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    boolean addCar(Car car);

    List<Car> getCars();

    List<Car> getTrucks();
}
