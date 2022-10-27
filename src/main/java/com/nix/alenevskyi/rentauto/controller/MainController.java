package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private AutoRentService autoRentService;

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }


    @GetMapping("/all_cars")
    public String allCars(@ModelAttribute("model") ModelMap model) {
        List<Car> cars = autoRentService.carList();
        model.addAttribute("carList", cars);
        return "/pages/all_cars";
    }

    @GetMapping("/all_cars_sorted_by")
    public String allCarsSortBy(@RequestParam("sorted_by") String sortBy,
            @ModelAttribute("model") ModelMap model) {
        List<Car> cars = autoRentService.getCarSortedBy(sortBy);
        model.addAttribute("carList", cars);
        return "/pages/all_cars";
    }

    @GetMapping("/all_cars/{id}")
    public ModelAndView carDetails(@PathVariable(value = "id") UUID id ,
                                   @ModelAttribute("model") ModelMap model){
        List<Car> car = autoRentService.getCar(id);
        model.addAttribute("car", car);
        return new ModelAndView("/pages/car_details", model);
    }

//    @GetMapping("/user/{id}")
//    public UserDto showUser(@PathVariable UUID id){
//        return toDTO(autoRentService.getUser(id));
//    }
//
//
//    private UserDto toDTO(User user) {
//        return UserDto.builder()
//                .firstname(user.getFirstname())
//                .lastname(user.getLastName())
//                .email(user.getEmail())
//                .phoneNumber(user.getPhoneNumber())
//                .roles(toDTOs(user.getRoles()))
//                .build();
//    }
//
//    private List<RoleDto> toDTOs(Set<Role> roles){
//        return roles.stream()
//                .map(this::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    private RoleDto toDTO(Role role){
//        return RoleDto.builder()
//                .name(role.getName())
//                .build();
//    }
}
