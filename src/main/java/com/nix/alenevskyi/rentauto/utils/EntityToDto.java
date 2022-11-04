package com.nix.alenevskyi.rentauto.utils;

import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class EntityToDto {

    public static OrderDto orderToOrderDto(Order order){
        return OrderDto.builder()
                .placeOfFiling(order.getPlaceOfFiling())
                .placeOfReturn(order.getPlaceOfReturn())
                .filingTime(order.getFilingTime())
                .returnTime(order.getReturnTime())
                .user(order.getUser())
                .car(order.getCar())
                .build();
    }
}
