package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CarDto {
    String brand;
    String model;
    String bodyType;
    String year;
    String transmission;
    String fuelType;
    Double engineVolume;
    Integer horsePower;
    Integer tankVolume;
    Double fuelConsumption;
    Double bail;
    Double price;
    Boolean isPremium;
    Boolean available;
    List<Order> orders;
}
