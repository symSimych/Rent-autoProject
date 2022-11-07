package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Controller
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerController {

    @Autowired
    private AutoRentService autoRentService;

    @GetMapping("/manager")
    public String manager(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("orderList", autoRentService.getOrders());
        return "/pages/manager";
    }

    @PostMapping("/manager")
    public String confirmOrder(@ModelAttribute("model") ModelMap model,
                               @RequestParam(name = "carId", required = false) Car car,
                               @RequestParam(name = "phone_number", required = false) String phoneNumber
    ) {
        if(car != null){
            car.setAvailable(false);
            autoRentService.saveCar(car);
        }
        List<Order> orders;
        if(phoneNumber != null & !Objects.equals(phoneNumber, "")){
           orders = autoRentService.getOrderByUserPhoneNumber(phoneNumber);
        }else {
           orders = autoRentService.getOrders();
        }

        model.addAttribute("orderList", orders);
        return "/pages/manager";
    }

    @GetMapping("/manager/order/{order}")
    public ModelAndView changeOrder(@ModelAttribute("model") ModelMap model,
                                    @PathVariable("order") Order order
    ) {
        model.addAttribute("order", order);
        return new ModelAndView("/pages/change_order", model);
    }

    @PostMapping("/manager/order/{order}")
    public String changeOrder(
            @ModelAttribute("model") ModelMap model,
            @PathVariable("order") Order order,
            @RequestParam(name = "placeOfFiling") String placeOfFiling,
            @RequestParam(name = "filingTime") String filingTime,
            @RequestParam(name = "placeOfReturn") String placeOfReturn,
            @RequestParam(name = "returnTime") String returnTime
    ) {
        order.setPlaceOfFiling(placeOfFiling);
        order.setFilingTime(LocalDateTime.parse(filingTime));
        order.setPlaceOfReturn(placeOfReturn);
        order.setReturnTime(LocalDateTime.parse(returnTime));
        autoRentService.saveOrder(order);

        model.addAttribute("orderList", autoRentService.getOrders());
        return "/pages/manager";
    }

    @GetMapping("/manager/car_manage")
    public String carManage(Model model,
                            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        Page<Car> cars = autoRentService.carList(pageable);
        model.addAttribute("url", "/manager/car_manage");
        model.addAttribute("page", cars);
        return "/pages/car_manage";
    }

    @GetMapping("/manager/car_manage/{car}")
    public String editCar(@ModelAttribute("model") ModelMap model,
                          @PathVariable("car") Car car
    ) {
        model.addAttribute("car", car);
        return "/pages/edit_car";
    }

    @PostMapping("/manager/car_manage/{car}")
    public String editCar(@ModelAttribute("model") ModelMap model,
                          @PathVariable("car") Car car,
                          @RequestParam(name = "brand") String brand,
                          @RequestParam(name = "carModel") String carModel,
                          @RequestParam(name = "bodyType") String bodyType,
                          @RequestParam(name = "transmission") String transmission,
                          @RequestParam(name = "year") String year,
                          @RequestParam(name = "fuelType") String fuelType,
                          @RequestParam(name = "horsePower") Integer horsePower,
                          @RequestParam(name = "engineVolume") Double engineVolume,
                          @RequestParam(name = "fuelConsumption") Double fuelConsumption,
                          @RequestParam(name = "tankVolume") Integer tankVolume,
                          @RequestParam(name = "bail") Double bail,
                          @RequestParam(name = "price") Double price,
                          @RequestParam(name = "status") String status
    ) {
        car.setBrand(brand);
        car.setModel(carModel);
        car.setBodyType(bodyType);
        car.setTransmission(transmission);
        car.setYear(year);
        car.setFuelType(fuelType);
        car.setHorsePower(horsePower);
        car.setEngineVolume(engineVolume);
        car.setFuelConsumption(fuelConsumption);
        car.setTankVolume(tankVolume);
        car.setBail(bail);
        car.setPrice(price);
        if(status != null & !Objects.equals(status, "")){
            status = status.replaceAll(",", "");
            car.setAvailable(Boolean.valueOf(status));
        }
        autoRentService.saveCar(car);
        model.addAttribute("car", car);
        return "/pages/edit_car";
    }
}
