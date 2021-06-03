package ru.job4j.ood.lsp.parking;

public class Service {
    private Parking parking;

    public Service(Parking parking) {
        this.parking = parking;
    }

    public boolean parkCar(Car car) {
        if (car.getSize() == 1 && parking.getParkingSpaceCar() > 0) {
            parking.setParkingSpaceCar(parking.getParkingSpaceCar() - 1);
        } else if (parking.getParkingSpaceTruck() >= car.getSize()) {
            parking.setParkingSpaceTruck(parking.getParkingSpaceTruck() - car.getSize());
        } else if (parking.getParkingSpaceCar() >= car.getSize()) {
            parking.setParkingSpaceCar(parking.getParkingSpaceCar() - car.getSize());
        } else {
            return false;
        }
        return true;
    }
}