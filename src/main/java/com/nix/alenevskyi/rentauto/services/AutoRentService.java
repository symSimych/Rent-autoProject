package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.dto.UserDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.User;

import java.util.List;
import java.util.UUID;

public interface AutoRentService {
    List<Car> carList();
    List<Car> getCar(UUID id);
    List<Car> getCarSortedBy(String cartBy);
}
