package com.nix.alenevskyi.rentauto.repositories;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ImageRepository extends CrudRepository<Image, UUID> {

    List<Image> findByCar(Car car);
}
