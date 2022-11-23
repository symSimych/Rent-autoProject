package com.nix.alenevskyi.rentauto.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
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

    @Column(name = "available")
    Boolean available;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "car")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "car")
    private List<Image> images = new ArrayList<>();

    @Column(name = "preview_image_id")
    UUID previewImageId;

    public void addOrder(Order order) {
        getOrders().add(order);
        order.setCar(this);
    }

    public void removeOrder(Order order) {
        getOrders().remove(order);
        order.setCar(null);
    }

    public void addImage(Image image) {
        getImages().add(image);
        image.setCar(this);
    }

    public void removeImage(Image image) {
        getImages().remove(image);
        image.setCar(null);
    }

    public boolean haveImages() {
        return !images.isEmpty();
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
                ", available=" + available +
                '}';
    }
}
