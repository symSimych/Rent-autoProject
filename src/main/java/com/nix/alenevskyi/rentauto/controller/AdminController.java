package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.services.AdminService;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AutoRentService autoRentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add_car")
    public String addCar(@ModelAttribute("model") ModelMap model) {
        List<Car> cars = autoRentService.carList();
        model.addAttribute("carList", cars);
        return "/pages/add_car";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/add_new_car")
    public ModelAndView addNewCustomer(
            @ModelAttribute("model") ModelMap model,
            @RequestParam(name = "brand") String brand,
            @RequestParam(name = "carModel") String carModel,
            @RequestParam(name = "bodyType") String bodyType,
            @RequestParam(name = "transmission") String transmission,
            @RequestParam(name = "year") String year,
            @RequestParam(name = "fuelType") String fuelType,
            @RequestParam(name = "horsePower") String horsePower,
            @RequestParam(name = "engineVolume") String engineVolume,
            @RequestParam(name = "fuelConsumption") String fuelConsumption,
            @RequestParam(name = "tankVolume") String tankVolume,
            @RequestParam(name = "bail") String bail,
            @RequestParam(name = "price") String price
    ) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(carModel);
        car.setBodyType(bodyType);
        car.setTransmission(transmission);
        car.setYear(year);
        car.setFuelType(fuelType);
        car.setHorsePower(Integer.valueOf(horsePower));
        car.setEngineVolume(Double.valueOf(engineVolume));
        car.setFuelConsumption(Double.valueOf(fuelConsumption));
        car.setTankVolume(Integer.valueOf(tankVolume));
        car.setBail(Double.valueOf(bail));
        car.setPrice(Double.valueOf(price));
        car.setIsPremium(false);
        adminService.addNewCar(car);
        List<Car> cars = autoRentService.carList();
        model.addAttribute("carList", cars);
        return new ModelAndView("/pages/add_car", model);
    }
}
