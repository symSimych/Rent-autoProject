package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

    private final CarRepository carRepository;

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void removeCar(Car car) {
        carRepository.delete(car);
    }
}
