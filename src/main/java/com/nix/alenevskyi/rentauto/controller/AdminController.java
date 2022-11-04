package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.services.AdminService;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import com.nix.alenevskyi.rentauto.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AutoRentService autoRentService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/admin")
    public String admin(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("carList", autoRentService.carList());
        return "/pages/admin";
    }

    @GetMapping("/admin/add_car")
    public String addCar(@ModelAttribute("model") ModelMap model) {
        List<Car> cars = autoRentService.carList();
        model.addAttribute("carList", cars);
        return "/pages/add_car";
    }

    @GetMapping("/admin/edit_user")
    public String users(@ModelAttribute("model") ModelMap model) {
        List<User> users = customUserDetailsService.getAllUsers();
        model.addAttribute("userList", users);
        return "/pages/users";
    }

    @GetMapping("/admin/edit_user/{user}")
    public ModelAndView editUser(@PathVariable("user") User user,
                           @ModelAttribute("model") ModelMap model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return new ModelAndView("/pages/edit_user", model);
    }

    @PostMapping("/admin/edit_user")
    public String editUser(@RequestParam("email") User user,
                           @RequestParam Map<String, String> form
    ) {
        customUserDetailsService.changeUserRole(user, form);
        return "redirect:/admin";
    }

    @PostMapping("/add_new_car")
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
        CarDto carDto = CarDto.builder()
                .brand(brand)
                .model(carModel)
                .bodyType(bodyType)
                .transmission(transmission)
                .year(year)
                .fuelType(fuelType)
                .horsePower(Integer.valueOf(horsePower))
                .engineVolume(Double.valueOf(engineVolume))
                .fuelConsumption(Double.valueOf(fuelConsumption))
                .tankVolume(Integer.valueOf(tankVolume))
                .bail(Double.valueOf(bail))
                .price(Double.valueOf(price))
                .build();
        adminService.addNewCar(carDto);
        List<Car> cars = autoRentService.carList();
        model.addAttribute("carList", cars);
        return new ModelAndView("/pages/add_car", model);
    }
}
