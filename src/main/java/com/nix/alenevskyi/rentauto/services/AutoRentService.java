package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface AutoRentService {
    Page<Car> carList(Pageable pageable);
    Page<Car> getCarSortedBy(String sortBy, Pageable pageable);
    User getUserByUsername(String username);
    void updateOrder(Order order);
    void saveOrder(Order order);
    List<Order> getOrders();
    void saveCar(Car car);
    List<Order> getOrderByUserPhoneNumber(String phoneNumber);
    void updateCar(Car car, List<MultipartFile> files, String status);
    void addNewCar(Car car, List<MultipartFile> files);
    void delete();
}
