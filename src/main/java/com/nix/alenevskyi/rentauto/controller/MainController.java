package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Image;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import com.nix.alenevskyi.rentauto.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

import static com.nix.alenevskyi.rentauto.utils.Util.getCurrentUsername;
import static com.nix.alenevskyi.rentauto.utils.Util.getErrors;

@Controller
public class MainController {

    @Autowired
    private AutoRentService autoRentService;
    @Autowired
    private CustomUserDetailsService userService;

    @GetMapping("/")
    public ModelAndView mainPage(@ModelAttribute("model") ModelMap model){
//        autoRentService.deletePolo();
//        autoRentService.delete();
        User user = autoRentService.getUserByUsername(getCurrentUsername());
        model.addAttribute("user", user);
        return new ModelAndView("/index", model);
    }


    @GetMapping("/all-cars")
    public String allCarsSortBy(@RequestParam(name = "sortBy", required = false) String sortBy,
                                Model model,
                                @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Car> page = autoRentService.getCarSortedBy(sortBy, pageable);
        List<Image> images = new ArrayList<>();
        for (Car car:page) {
            if(!car.getImages().isEmpty()){
                images.add(car.getImages().get(0));
            }
        }
        model.addAttribute("url", "/all-cars");
        model.addAttribute("page", page);
        model.addAttribute("images", images);
        return "/pages/all-cars";
    }

    @GetMapping("/all-cars/{car}")
    public ModelAndView carDetails(@PathVariable(value = "car") Car car,
                                   @ModelAttribute("model") ModelMap model
    ) {
        model.addAttribute("car", car);
        return new ModelAndView("/pages/car-details", model);
    }

    @PostMapping(value = "/all-cars/{car}")
    public String addNewOrder(
            Model model,
            @RequestParam(name = "placeOfFiling") String placeOfFiling,
            @RequestParam(name = "filingTime") String filingTime,
            @RequestParam(name = "placeOfReturn") String placeOfReturn,
            @RequestParam(name = "returnTime") String returnTime,
            @RequestParam(name = "carId") Car car
//            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        User user = autoRentService.getUserByUsername(getCurrentUsername());
        Order order = Order.builder()
                .placeOfFiling(placeOfFiling.toLowerCase(Locale.ROOT).replaceAll(" ", ""))
                .placeOfReturn(placeOfReturn.toLowerCase(Locale.ROOT).replaceAll(" ", ""))
                .filingTime(LocalDateTime.parse(filingTime))
                .returnTime(LocalDateTime.parse(returnTime))
                .user(user)
                .car(car)
                .build();
        autoRentService.saveOrder(order);

//        Page<Car> cars = autoRentService.carList(pageable);
//        model.addAttribute("page", cars);
//        model.addAttribute("url", "all-cars");
        model.addAttribute("car", car);
        return "/pages/car-details";
    }

    @GetMapping("/registration")
    public String registration(){
        return "/pages/registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if(user.getPassword() != null && !user.getPassword().equals("") && !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords are different");
        }
        if(bindingResult.hasErrors()) {
            Map<String, String> errorsMap = getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            return "/pages/registration";
        }
        if(!userService.addNewUser(user)){
            model.addAttribute("emailError", "User with " + user.getEmail() + " already exists");
            return "/pages/registration";
        }
        return "redirect:/login";
    }

//    @GetMapping("/login")
//    public String loginPage(){
//        return "/pages/login";
//    }
}
