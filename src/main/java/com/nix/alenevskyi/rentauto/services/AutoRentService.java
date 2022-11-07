package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface AutoRentService {
    Page<Car> carList(Pageable pageable);
    Car getCar(UUID id);
    Page<Car> getCarSortedBy(String sortBy, Pageable pageable);
    User getUserByUsername(String username);
    void saveOrder(Order order);
    List<Order> getOrders();
    void saveCar(Car car);
    List<Order> getOrderByUserPhoneNumber(String phoneNumber);
}
