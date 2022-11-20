package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.dto.CarDto;
import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Image;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.CarRepository;
import com.nix.alenevskyi.rentauto.repositories.ImageRepository;
import com.nix.alenevskyi.rentauto.repositories.OrderRepository;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import com.nix.alenevskyi.rentauto.utils.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.nix.alenevskyi.rentauto.utils.DtoToEntity.carDtoToCar;
import static com.nix.alenevskyi.rentauto.utils.DtoToEntity.orderDtoToOrder;

@RequiredArgsConstructor
@Service
@Slf4j
public class AutoRentServiceImpl implements AutoRentService{

    private static final String PRICE = "price";
    private static final String FUEL_CONSUMPTION = "fuel consumption";
    private static final String FUEL_TYPE = "fuel type";
    private static final String TRANSMISSION = "transmission";
    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String YEAR = "year";

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ImageRepository imageRepository;

    @Override
    public Page<Car> carList(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Page<Car> getCarSortedBy(String sortBy, Pageable pageable) {

        Map<String, Supplier<Page<Car>>> strategyMap = new HashMap<>();
        strategyMap.put(PRICE, () -> carRepository.findByOrderByPrice(pageable));
        strategyMap.put(FUEL_CONSUMPTION, () -> carRepository.findByOrderByFuelConsumption(pageable));
        strategyMap.put(FUEL_TYPE, () -> carRepository.findByOrderByFuelType(pageable));
        strategyMap.put(TRANSMISSION, () -> carRepository.findByOrderByTransmission(pageable));
        strategyMap.put(BRAND, () -> carRepository.findByOrderByBrand(pageable));
        strategyMap.put(MODEL, () -> carRepository.findByOrderByModel(pageable));
        strategyMap.put(YEAR, () -> carRepository.findByOrderByYear(pageable));
        return Optional.ofNullable(strategyMap.get(sortBy)).orElse(() -> carRepository.findByAvailable(pageable, true)).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        Order order = orderDtoToOrder(orderDto);
        orderRepository.save(order);
        log.info("Order {} update", order.getId());
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
        log.info("Order {} save in table", order.getId());
    }

    @Override
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
        log.info("Car {} save in table", car.getId());
    }

    @Override
    public List<Order> getOrderByUserPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumberContaining(phoneNumber);
        return orderRepository.findByUser(user);
    }

    @Override
    public void updateCar(CarDto carDto, List<MultipartFile> files, String status) {
        Car car = carDtoToCar(carDto);
        if(status != null & !Objects.equals(status, "")){
            status = status.replaceAll(",", "");
            car.setAvailable(Boolean.valueOf(status));
        }
        if(files.get(0).getSize() != 0){
            List<Image> images = files.stream()
                    .map(Util::toImageEntity).toList();
            for (Image image:images) {
                image.setCar(car);
                imageRepository.save(image);
                log.info("Images {} save in table", image.getFileName());
                car.getImages().add(image);
            }
            car.setPreviewImageId(car.getImages().get(0).getId());
        }
        carRepository.save(car);
        log.info("Car {} update", car.getId());
    }

    @Override
    public void addNewCar(Car car, List<MultipartFile> files) {
        List<Image> images = files.stream()
                .map(Util::toImageEntity)
                .collect(Collectors.toList());
        for (Image image:images) {
            image.setCar(car);
            imageRepository.save(image);
            log.info("Images {} save in table", image.getFileName());
        }
        car.setImages(images);
        car.setPreviewImageId(car.getImages().get(0).getId());
        carRepository.save(car);
        log.info("Car {} save in table", car.getId());
    }


    @Override
    public void delete() {
        orderRepository.deleteAll();
    }

}