package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarServiece {
    void add(Car car);

    List<Car> listCars();

    User getUserByCar(String model, int series);
}
