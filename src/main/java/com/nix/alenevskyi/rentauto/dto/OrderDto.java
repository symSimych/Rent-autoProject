package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    UUID id;
    String placeOfFiling;
    String placeOfReturn;
    LocalDateTime filingTime;
    LocalDateTime returnTime;
    Boolean confirmed;
    private User user;
    private Car car;
}
