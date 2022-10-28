package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;

import java.util.UUID;

public interface AdminService {
    void addNewCar(Car car);
    void removeCar(Car car);
}
