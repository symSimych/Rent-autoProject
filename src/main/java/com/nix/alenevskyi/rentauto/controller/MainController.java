package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.dto.OrderDto;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.nix.alenevskyi.rentauto.utils.DtoToEntity.orderDtoToEntity;
import static com.nix.alenevskyi.rentauto.utils.Util.getCurrentUsername;

@Controller
public class MainController {

    @Autowired
    private AutoRentService autoRentService;
    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public ModelAndView mainPage(@ModelAttribute("model") ModelMap model){
        User user = autoRentService.getUserByUsername(getCurrentUsername());
        model.addAttribute("user", user);
        return new ModelAndView("/index", model);
    }


    @GetMapping("/all_cars")
    public String allCarsSortBy(@RequestParam(name = "sorted_by", required = false) String sortBy,
            @ModelAttribute("model") ModelMap model) {
        List<Car> cars = autoRentService.getCarSortedBy(sortBy);
        model.addAttribute("carList", cars);
        return "/pages/all_cars";
    }

    @GetMapping("/all_cars/{id}")
    public ModelAndView carDetails(@PathVariable(value = "id") UUID id ,
                                   @ModelAttribute("model") ModelMap model){
        Car car = autoRentService.getCar(id);
        model.addAttribute("car", car);
        return new ModelAndView("/pages/car_details", model);
    }

    @PostMapping(value = "/add_new_order")
    public ModelAndView addNewOrder(
            @ModelAttribute("model") ModelMap model,
            @RequestParam(name = "placeOfFiling") String placeOfFiling,
            @RequestParam(name = "filingTime") String filingTime,
            @RequestParam(name = "placeOfReturn") String placeOfReturn,
            @RequestParam(name = "returnTime") String returnTime,
            @RequestParam(name = "carId") Car car

    ) {
        User user = autoRentService.getUserByUsername(getCurrentUsername());
        OrderDto orderDto = OrderDto.builder()
                .placeOfFiling(placeOfFiling)
                .placeOfReturn(placeOfReturn)
                .filingTime(LocalDateTime.parse(filingTime))
                .returnTime(LocalDateTime.parse(returnTime))
                .user(user)
                .car(car)
                .build();
        autoRentService.saveOrder(orderDtoToEntity(orderDto));

        List<Car> cars = autoRentService.carList();
        model.addAttribute("carList", cars);
        return new ModelAndView("/pages/all_cars", model);
    }

    @GetMapping("/registration")
    public String registration(){
        return "/pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("model") ModelMap model,
                          @RequestParam("firstname") String firstname,
                          @RequestParam("lastname") String lastname,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("phone_number") String phoneNumber) {
        UserDto userDto = UserDto.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .password(bCryptPasswordEncoder.encode(password))
                .phoneNumber(phoneNumber)
                .roles(Set.of(Role.ROLE_USER))
                .build();
        if(!userService.addNewUser(userDto)){
            model.addAttribute("errorMessage", "User with email "
                    + userDto.getEmail()
                    + " already exists");
            return "/pages/registration";
        }
        return "redirect:/login";
    }
}
