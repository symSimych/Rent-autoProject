package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import com.nix.alenevskyi.rentauto.repositories.OrderRepository;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AutoRentServiceImpl implements AutoRentService{

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public Page<Car> carList(Pageable pageable) {
        return (Page<Car>) carRepository.findAll(pageable);
    }

    @Override
    public Car getCar(UUID id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Page<Car> getCarSortedBy(String sortBy, Pageable pageable) {
        Page<Car> cars;
        if(sortBy == null)return carRepository.findAll(pageable);
        if(sortBy.equals("price"))cars = carRepository.findByOrderByPrice(pageable);
        else if(sortBy.equals("fuel consumption"))cars = carRepository.findByOrderByFuelConsumption(pageable);
        else if(sortBy.equals("fuel type"))cars = carRepository.findByOrderByFuelType(pageable);
        else if(sortBy.equals("transmission"))cars = carRepository.findByOrderByTransmission(pageable);
        else if(sortBy.equals("brand"))cars = carRepository.findByOrderByBrand(pageable);
        else if(sortBy.equals("model"))cars = carRepository.findByOrderByModel(pageable);
        else if(sortBy.equals("year"))cars = carRepository.findByOrderByYear(pageable);
        else cars = carRepository.findAll(pageable);
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