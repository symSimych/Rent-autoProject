package com.nix.alenevskyi.rentauto.repositories;

import com.nix.alenevskyi.rentauto.entity.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface CarRepository extends CrudRepository<Car, UUID> {

    @Transactional
    Page<Car> findAll(Pageable pageable);
    @Transactional
    Page<Car> findByAvailable(Pageable pageable, Boolean isAvailable);

    @Transactional
    Page<Car> findByOrderByPrice(Pageable pageable);

    @Transactional
    Page<Car> findByOrderByFuelConsumption(Pageable pageable);

    @Transactional
    Page<Car> findByOrderByFuelType(Pageable pageable);

    @Transactional
    Page<Car> findByOrderByTransmission(Pageable pageable);

    @Transactional
    Page<Car> findByOrderByBrand(Pageable pageable);

    @Transactional
    Page<Car> findByOrderByModel(Pageable pageable);

    @Transactional
    Page<Car> findByOrderByYear(Pageable pageable);
}
