package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.dto.UserDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.UUID;

public interface AutoRentService {
    List<Car> carList();
    Car getCar(UUID id);
    List<Car> getCarSortedBy(String cartBy);
    User getUserByUsername(String username);
    void saveOrder(Order order);
    Order getOrderByUserId(User user);
    void delete();
    List<Order> getOrders();
    void saveCar(Car car);
    List<Order> getOrderByUserPhoneNumber(String phoneNumber);
}
