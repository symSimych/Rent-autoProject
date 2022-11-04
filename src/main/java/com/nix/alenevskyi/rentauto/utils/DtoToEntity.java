package com.nix.alenevskyi.rentauto.utils;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.dto.UserDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;

public class DtoToEntity {

    public static Car carDtoToEntity(CarDto carDto) {
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .year(carDto.getYear())
                .bodyType(carDto.getBodyType())
                .transmission(carDto.getTransmission())
                .fuelType(carDto.getFuelType())
                .engineVolume(carDto.getEngineVolume())
                .horsePower(carDto.getHorsePower())
                .tankVolume(carDto.getTankVolume())
                .fuelConsumption(carDto.getFuelConsumption())
                .bail(carDto.getBail())
                .price(carDto.getPrice())
                .isPremium(carDto.getIsPremium())
                .build();
    }

    public static User userDtoToEntity(UserDto userDto) {
        return User.builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .roles(userDto.getRoles())
                .build();
    }

    public static Order orderDtoToEntity(OrderDto orderDto){
        return Order.builder()
                .placeOfFiling(orderDto.getPlaceOfFiling())
                .placeOfReturn(orderDto.getPlaceOfReturn())
                .filingTime(orderDto.getFilingTime())
                .returnTime(orderDto.getReturnTime())
                .user(orderDto.getUser())
                .car(orderDto.getCar())
                .build();
    }
}
