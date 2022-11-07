package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void addCarTest() {
        Car car = new Car();
        adminService.addNewCar(car);
        Mockito.verify(carRepository, Mockito.times(1)).save(car);
    }

    @Test
    public void deleteCarTest() {
        Car car = new Car();
        adminService.removeCar(car);
        Mockito.verify(carRepository, Mockito.times(1)).delete(car);
    }
}