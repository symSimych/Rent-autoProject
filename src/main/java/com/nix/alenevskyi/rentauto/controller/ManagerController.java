package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.dto.OrderDto;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
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
                               @RequestParam(name = "orderId", required = false) Order order,
                               @RequestParam(name = "phone_number", required = false) String phoneNumber
    ) {
        if(car != null){
            car.setAvailable(false);
            order.setConfirmed(true);
            autoRentService.saveCar(car);
            autoRentService.saveOrder(order);
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
        return new ModelAndView("/pages/change-order", model);
    }

    @PostMapping("/manager/order/{order}")
    public String confirmOrder(
            @ModelAttribute("model") ModelMap model,
            @PathVariable("order") Order order,
            @RequestParam(name = "placeOfFiling") String placeOfFiling,
            @RequestParam(name = "filingTime") String filingTime,
            @RequestParam(name = "placeOfReturn") String placeOfReturn,
            @RequestParam(name = "returnTime") String returnTime
            ) {
        OrderDto orderDto = OrderDto.builder()
                .placeOfFiling(placeOfFiling.toLowerCase(Locale.ROOT).replaceAll(" ", ""))
                .filingTime(LocalDateTime.parse(filingTime))
                .placeOfReturn(placeOfReturn.toLowerCase(Locale.ROOT).replaceAll(" ", ""))
                .returnTime(LocalDateTime.parse(returnTime))
                .user(order.getUser())
                .confirmed(order.getConfirmed())
                .car(order.getCar())
                .id(order.getId())
                .build();
        autoRentService.updateOrder(orderDto);

        model.addAttribute("orderList", autoRentService.getOrders());
        return "/pages/manager";
    }

    @GetMapping("/manager/car-manage")
    public String carManage(Model model,
                            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ){
        Page<Car> cars = autoRentService.carList(pageable);
        model.addAttribute("url", "/manager/car-manage");
        model.addAttribute("page", cars);
        return "/pages/car-manage";
    }

    @GetMapping("/manager/car-manage/{car}")
    public String editCar(@ModelAttribute("model") ModelMap model,
                          @PathVariable("car") Car car
    ) {
        model.addAttribute("car", car);
        return "/pages/edit-car";
    }

    @PostMapping("/manager/car-manage/{car}")
    public String editCar(@ModelAttribute(name = "model") ModelMap model,
                          @PathVariable(name = "car") Car car,
                          @RequestParam(name = "brand") String brand,
                          @RequestParam(name = "carModel") String carModel,
                          @RequestParam(name = "bodyType") String bodyType,
                          @RequestParam(name = "bail") Double bail,
                          @RequestParam(name = "price") Double price,
                          @RequestParam(name = "year") String year,
                          @RequestParam(name = "transmission") String transmission,
                          @RequestParam(name = "horsePower") Integer horsePower,
                          @RequestParam(name = "engineVolume") Double engineVolume,
                          @RequestParam(name = "fuelType") String fuelType,
                          @RequestParam(name = "tankVolume") Integer tankVolume,
                          @RequestParam(name = "fuelConsumption") Double fuelConsumption,
                          @RequestParam(name = "status") String status,
                          @RequestParam(name = "files") MultipartFile[] files
    ) {
        List<MultipartFile> multipartFiles = List.of(files);
        CarDto carDto = CarDto.builder()
                .id(car.getId())
                .brand(brand)
                .model(carModel)
                .bodyType(bodyType)
                .bail(bail)
                .price(price)
                .year(year)
                .transmission(transmission)
                .horsePower(horsePower)
                .engineVolume(engineVolume)
                .fuelType(fuelType)
                .tankVolume(tankVolume)
                .fuelConsumption(fuelConsumption)
                .available(car.getAvailable())
                .images(car.getImages())
                .orders(car.getOrders())
                .previewImageId(car.getPreviewImageId())
                .build();
        autoRentService.updateCar(carDto, multipartFiles, status);
        model.addAttribute("car", car);
        return "/pages/edit-car";
    }

    @GetMapping("/manager/add-car")
    public String addCar(@ModelAttribute("model") ModelMap model) {
        return "/pages/add-car";
    }

    @PostMapping("/add-new-car")
    public ModelAndView addNewCar(
            @ModelAttribute(name = "car") Car car,
            @ModelAttribute("model") ModelMap model,
//            @RequestParam(name = "brand") String brand,
//            @RequestParam(name = "carModel") String carModel,
//            @RequestParam(name = "bodyType") String bodyType,
//            @RequestParam(name = "transmission") String transmission,
//            @RequestParam(name = "year") String year,
//            @RequestParam(name = "fuelType") String fuelType,
//            @RequestParam(name = "horsePower") String horsePower,
//            @RequestParam(name = "engineVolume") String engineVolume,
//            @RequestParam(name = "fuelConsumption") String fuelConsumption,
//            @RequestParam(name = "tankVolume") String tankVolume,
//            @RequestParam(name = "bail") String bail,
//            @RequestParam(name = "price") String price,
            @RequestParam(name = "files") MultipartFile[] files
    ) {
        List<MultipartFile> multipartFiles = List.of(files);
//        Car car = Car.builder()
//                .brand(brand)
//                .model(carModel)
//                .bodyType(bodyType)
//                .transmission(transmission)
//                .year(year)
//                .fuelType(fuelType)
//                .horsePower(Integer.valueOf(horsePower))
//                .engineVolume(Double.valueOf(engineVolume))
//                .fuelConsumption(Double.valueOf(fuelConsumption))
//                .tankVolume(Integer.valueOf(tankVolume))
//                .bail(Double.valueOf(bail))
//                .price(Double.valueOf(price))
//                .build();
        autoRentService.addNewCar(car, multipartFiles);
        return new ModelAndView("/pages/add-car", model);
    }
}
