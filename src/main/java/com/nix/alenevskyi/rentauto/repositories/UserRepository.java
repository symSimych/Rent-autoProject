package com.nix.alenevskyi.rentauto.repositories;

import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Transactional
    User findByEmail(String email);
    @Transactional
    User findByPhoneNumberContaining(String phoneNumber);
}
