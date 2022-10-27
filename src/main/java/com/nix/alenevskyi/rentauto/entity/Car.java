package com.nix.alenevskyi.rentauto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue
    @Column(name = "id")
    UUID id;

    @Column(name = "brand")
    String brand;

    @Column(name = "model")
    String model;

    @Column(name = "body_type")
    String bodyType;

    @Column(name = "year")
    String year;

    @Column(name = "transmission")
    String transmission;

    @Column(name = "fuel_type")
    String fuelType;

    @Column(name = "engine_volume")
    Double engineVolume;

    @Column(name = "horse_power")
    Integer horsePower;

    @Column(name = "tank_volume")
    Integer tankVolume;

    @Column(name = "fuel_consumption")
    Double fuelConsumption;

    @Column(name = "bail")
    Double bail;

    @Column(name = "price")
    Double price;

    @Column(name = "is_premium")
    Boolean isPremium;
}
