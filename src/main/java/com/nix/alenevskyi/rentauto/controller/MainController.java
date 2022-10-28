package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.dto.UserDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import com.nix.alenevskyi.rentauto.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private AutoRentService autoRentService;
    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @GetMapping("/registration")
    public String registration(){
        return "/pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam("firstname") String firstname,
                          @RequestParam("lastname") String lastname,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("phone_number") String phoneNumber) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole(Role.USER.getRoleName());
        userService.addNewUser(user);
        return "index";
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
