package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.dto.UserDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import com.nix.alenevskyi.rentauto.repositories.OrderRepository;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.nix.alenevskyi.rentauto.utils.DtoToEntity.orderDtoToEntity;
import static com.nix.alenevskyi.rentauto.utils.EntityToDto.orderToOrderDto;

@RequiredArgsConstructor
@Service
public class AutoRentServiceImpl implements AutoRentService{

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<Car> carList() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car getCar(UUID id) {
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> getCarSortedBy(String sortBy) {
        List<Car> cars;
        if(sortBy == null)return (List<Car>) carRepository.findAll();
        if(sortBy.equals("price"))cars = carRepository.findByOrderByPrice();
        else if(sortBy.equals("fuel consumption"))cars = carRepository.findByOrderByFuelConsumption();
        else if(sortBy.equals("fuel type"))cars = carRepository.findByOrderByFuelType();
        else if(sortBy.equals("transmission"))cars = carRepository.findByOrderByTransmission();
        else if(sortBy.equals("brand"))cars = carRepository.findByOrderByBrand();
        else if(sortBy.equals("model"))cars = carRepository.findByOrderByModel();
        else if(sortBy.equals("year"))cars = carRepository.findByOrderByYear();
        else cars = (List<Car>) carRepository.findAll();
        return cars;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrderByUserId(User user) {
        return orderRepository.findFirstByUserAndReturnTimeGreaterThan(user, LocalDateTime.now());
    }

    @Override
    public void delete() {
        orderRepository.deleteAll();
    }

    @Override
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Order> getOrderByUserPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumberContaining(phoneNumber);
        return orderRepository.findByUser(user);
    }
}