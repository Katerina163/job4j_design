package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    private int parkingSpaceCar;
    private int parkingSpaceTruck;
    private List<Car> cars = new ArrayList<>();
    private List<Car> trucks = new ArrayList<>();

    public CarParking(int parkingSpaceCar, int parkingSpaceTruck) {
        this.parkingSpaceCar = parkingSpaceCar;
        this.parkingSpaceTruck = parkingSpaceTruck;
    }

    @Override
    public boolean addCar(Car car) {
        if (car.getSize() == 1) {
            if (parkingSpaceCar > 0) {
                parkingSpaceCar--;
                return cars.add(car);
            }
        } else {
            if (parkingSpaceTruck > 0) {
                parkingSpaceTruck--;
                return trucks.add(car);
            } else if (car.getSize() <= parkingSpaceCar) {
                parkingSpaceCar -= car.getSize();
                return cars.add(car);
            }
        }
        return false;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getTrucks() {
        return trucks;
    }
}
