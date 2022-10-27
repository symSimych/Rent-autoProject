package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AutoRentServiceImpl implements AutoRentService{

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public List<Car> carList() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public List<Car> getCar(UUID id) {
        List<Car> car = new ArrayList<>();
        carRepository.findById(id).ifPresent(car::add);
        return car;
    }

    @Override
    public List<Car> getCarSortedBy(String sortBy) {
        List<Car> cars = new ArrayList<>();
        switch (sortBy){
            case "price" -> cars = carRepository.findByOrderByPrice();
            case "fuel consumption" -> cars = carRepository.findByOrderByFuelConsumption();
            case "fuel type" -> cars = carRepository.findByOrderByFuelType();
            case "transmission" -> cars = carRepository.findByOrderByTransmission();
            case "brand" -> cars = carRepository.findByOrderByBrand();
            case "model" -> cars = carRepository.findByOrderByModel();
            case "year" -> cars = carRepository.findByOrderByYear();
        }
        return cars;
    }
}