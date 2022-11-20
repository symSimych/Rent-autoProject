package com.nix.alenevskyi.rentauto.utils;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Order;

public class DtoToEntity {
    public static Car carDtoToCar(CarDto carDto) {
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .bodyType(carDto.getBodyType())
                .tankVolume(carDto.getTankVolume())
                .fuelConsumption(carDto.getFuelConsumption())
                .fuelType(carDto.getFuelType())
                .bail(carDto.getBail())
                .price(carDto.getPrice())
                .horsePower(carDto.getHorsePower())
                .previewImageId(carDto.getPreviewImageId())
                .engineVolume(carDto.getEngineVolume())
                .transmission(carDto.getTransmission())
                .year(carDto.getYear())
                .id(carDto.getId())
                .available(carDto.getAvailable())
                .images(carDto.getImages())
                .orders(carDto.getOrders())
                .build();
    }

    public static Order orderDtoToOrder(OrderDto orderDto){
        return Order.builder()
                .placeOfFiling(orderDto.getPlaceOfFiling())
                .returnTime(orderDto.getReturnTime())
                .filingTime(orderDto.getFilingTime())
                .placeOfReturn(orderDto.getPlaceOfReturn())
                .car(orderDto.getCar())
                .user(orderDto.getUser())
                .confirmed(orderDto.getConfirmed())
                .id(orderDto.getId())
                .build();
    }
}
