package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;

public interface AdminService {
    void addNewCar(Car carD);
    void removeCar(Car car);
}
