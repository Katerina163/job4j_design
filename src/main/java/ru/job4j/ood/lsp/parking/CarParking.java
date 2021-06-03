package ru.job4j.ood.lsp.parking;

public class CarParking implements Parking {
    private int parkingSpaceCar;
    private int parkingSpaceTruck;

    public CarParking(int parkingSpaceCar, int parkingSpaceTruck) {
        this.parkingSpaceCar = parkingSpaceCar;
        this.parkingSpaceTruck = parkingSpaceTruck;
    }

    @Override
    public void setParkingSpaceCar(int parkingSpaceCar) {
        this.parkingSpaceCar = parkingSpaceCar;
    }

    @Override
    public void setParkingSpaceTruck(int parkingSpaceTruck) {
        this.parkingSpaceTruck = parkingSpaceTruck;
    }

    @Override
    public int getParkingSpaceCar() {
        return parkingSpaceCar;
    }

    @Override
    public int getParkingSpaceTruck() {
        return parkingSpaceTruck;
    }
}
