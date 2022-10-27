package com.nix.alenevskyi.rentauto.repositories;

import com.nix.alenevskyi.rentauto.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends CrudRepository<Car, UUID> {

    @Query(value = "select car from Car car " +
            " where car.brand like %:brand%")
    List<Car> getCarsByBrand(@Param("brand") String brand);

    List<Car> findByOrderByPrice();

    List<Car> findByOrderByFuelConsumption();

    List<Car> findByOrderByFuelType();

    List<Car> findByOrderByTransmission();

    List<Car> findByOrderByBrand();

    List<Car> findByOrderByModel();

    List<Car> findByOrderByYear();
}
