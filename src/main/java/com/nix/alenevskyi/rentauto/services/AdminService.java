package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.entity.Car;

import java.util.UUID;

public interface AdminService {
    void addNewCar(CarDto carDto);
    void removeCar(Car car);
}
