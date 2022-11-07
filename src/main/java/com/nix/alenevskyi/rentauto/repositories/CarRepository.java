package com.nix.alenevskyi.rentauto.repositories;

import com.nix.alenevskyi.rentauto.entity.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends CrudRepository<Car, UUID> {

    Page<Car> findAll(Pageable pageable);

    Page<Car> findByOrderByPrice(Pageable pageable);

    Page<Car> findByOrderByFuelConsumption(Pageable pageable);

    Page<Car> findByOrderByFuelType(Pageable pageable);

    Page<Car> findByOrderByTransmission(Pageable pageable);

    Page<Car> findByOrderByBrand(Pageable pageable);

    Page<Car> findByOrderByModel(Pageable pageable);

    Page<Car> findByOrderByYear(Pageable pageable);
}
