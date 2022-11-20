package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.entity.Image;
import com.nix.alenevskyi.rentauto.entity.Order;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    UUID id;
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
    Boolean available;
    private Set<Order> orders = new HashSet<>();
    private List<Image> images = new ArrayList<>();
    UUID previewImageId;

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", year='" + year + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", engineVolume=" + engineVolume +
                ", horsePower=" + horsePower +
                ", tankVolume=" + tankVolume +
                ", fuelConsumption=" + fuelConsumption +
                ", bail=" + bail +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
