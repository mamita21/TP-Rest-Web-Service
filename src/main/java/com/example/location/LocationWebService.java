package com.example.location;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationWebService {

    private List<Car> cars = new ArrayList<>();

    public LocationWebService() {
        cars.add(new Car("AA11BB", "Ferrari", 100));
        cars.add(new Car("CC22DD", "Renault", 50));
        cars.add(new Car("EE33FF", "Peugeot", 60));
    }

    @GetMapping("/")
    public String hello() {
        return "hello Coumba";
    }

    @GetMapping("/cars")
    public List<Car> listOfCars()
     {
        return cars;
    }

    @GetMapping("/cars/{plateNumber}")
public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {

    for (Car car : cars) {
        if (car.getPlateNumber().equals(plateNumber)) {
            return car;
        }
    }

    throw new Exception("Car not found");
}
}
