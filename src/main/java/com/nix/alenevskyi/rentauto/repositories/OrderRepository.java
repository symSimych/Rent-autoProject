package com.nix.alenevskyi.rentauto.repositories;

import com.nix.alenevskyi.rentauto.dto.OrderDto;
import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {
    Order findFirstByUserAndReturnTimeGreaterThan(User user, LocalDateTime returnTime);
    List<Order> findByUser(User user);
}
