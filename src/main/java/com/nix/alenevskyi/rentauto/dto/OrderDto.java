package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderDto {

    String placeOfFiling;
    String placeOfReturn;
    LocalDateTime filingTime;
    LocalDateTime returnTime;
    User user;
    Car car;
}
