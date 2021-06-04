package ru.job4j.ood.lsp.parking;

public class Service {
    private Parking parking;

    public Service(Parking parking) {
        this.parking = parking;
    }

    public boolean parkCar(Car car) {
        return parking.addCar(car);
    }

    public Parking getParking() {
        return parking;
    }
}