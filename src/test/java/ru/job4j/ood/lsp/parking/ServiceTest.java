package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ServiceTest {
    @Test
    public void parking() {
        Service service = new Service(new CarParking(1, 2));
        Car car = new PassengerCar();
        service.parkCar(car);
        Car truck = new Truck(2);
        service.parkCar(truck);
        assertThat(service.getParking().getCars().get(0), is(car));
        assertThat(service.getParking().getTrucks().get(0), is(truck));
    }

    @Test
    public void parkingManyTrucks() {
        Service service = new Service(new CarParking(2, 10));
        Car car1 = new Truck(5);
        Car car2 = new Truck(5);
        Car car3 = new Truck(2);
        Car car4 = new Truck(3);
        service.parkCar(car1);
        service.parkCar(car2);
        service.parkCar(car3);
        service.parkCar(car4);
        assertThat(service.getParking().getCars().get(0), is(car3));
        assertThat(service.getParking().getTrucks(), is(List.of(car1, car2)));
    }

    @Test
    public void parkingManyPassCar() {
        Service service = new Service(new CarParking(2, 1));
        Car car1 = new PassengerCar();
        Car car2 = new PassengerCar();
        Car car3 = new PassengerCar();
        service.parkCar(car1);
        service.parkCar(car2);
        service.parkCar(car3);
        assertThat(service.getParking().getCars().size(), is(2));
        assertThat(service.getParking().getTrucks().size(), is(0));
    }

}