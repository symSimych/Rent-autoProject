package com.nix.alenevskyi.rentauto.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
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

    @Column(name = "available")
    Boolean available;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "car")
    private Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setCar(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCar(null);
    }

    @PrePersist
    public void setAvailable() {
        available = true;
    }

    @Override
    public String toString() {
        return "Car{" +
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
                ", isPremium=" + isPremium +
                ", available=" + available +
//                ", orders=" + orders +
                '}';
    }
}
