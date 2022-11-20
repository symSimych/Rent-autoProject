package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import com.nix.alenevskyi.rentauto.repositories.OrderRepository;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AutoRentServiceImplTest {

    @Autowired
    private AutoRentService autoRentService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void saveCarTest() {
        Car car = new Car();

        autoRentService.saveCar(car);

        Mockito.verify(carRepository, Mockito.times(1)).save(car);
    }

    @Test
    public void saveOrderTest() {
        Order order = new Order();

        autoRentService.saveOrder(order);

        Mockito.verify(orderRepository, Mockito.times(1)).save(order);
    }

    @Test
    public void getCarsTest(){
        Pageable pageable = null;
        Page<Car> cars = autoRentService.carList(pageable);

        Mockito.verify(carRepository, Mockito.times(1)).findByAvailable(pageable, true);
    }

    @Test
    public void getOrdersTest(){
        List<Order> orders = autoRentService.getOrders();

        Mockito.verify(orderRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void getCarsSortedByNullTest(){
        String sortBy = null;
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByAvailable(pageable, true);
    }

    @Test
    public void getCarsSortedByPriceTest(){
        String sortBy = "price";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByPrice(pageable);
    }

    @Test
    public void getCarsSortedByFuelConsumptionTest(){
        String sortBy = "fuel consumption";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByFuelConsumption(pageable);
    }

    @Test
    public void getCarsSortedByFuelTypeTest(){
        String sortBy = "fuel type";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByFuelType(pageable);
    }

    @Test
    public void getCarsSortedByTransmissionTest(){
        String sortBy = "transmission";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByTransmission(pageable);
    }

    @Test
    public void getCarsSortedByBrandTest(){
        String sortBy = "brand";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByBrand(pageable);
    }

    @Test
    public void getCarsSortedByModelTest(){
        String sortBy = "model";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByModel(pageable);
    }

    @Test
    public void getCarsSortedByYearTest(){
        String sortBy = "year";
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(sortBy, pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByOrderByYear(pageable);
    }

    @Test
    public void getCarsSortedByTest(){
        Pageable pageable = null;
        Page<Car> cars = autoRentService.getCarSortedBy(ArgumentMatchers.anyString(), pageable);
        Mockito.verify(carRepository, Mockito.times(1)).findByAvailable(pageable, true);
    }

    @Test
    public void getOrderByUserPhoneTest() {
        String phone ="1864";
        List<Order> orders = autoRentService.getOrderByUserPhoneNumber(phone);
        Mockito.verify(userRepository, Mockito.times(1)).findByPhoneNumberContaining(ArgumentMatchers.anyString());
        Mockito.verify(orderRepository, Mockito.times(1)).findByUser(userRepository.findByPhoneNumberContaining(ArgumentMatchers.anyString()));
    }

    @Test
    public void gteUserByUsernameTest() {
        String email = "adwad@AW.d";
        User user = autoRentService.getUserByUsername(email);
        Mockito.verify(userRepository, Mockito.times(1)).findByEmail(ArgumentMatchers.anyString());
    }
}