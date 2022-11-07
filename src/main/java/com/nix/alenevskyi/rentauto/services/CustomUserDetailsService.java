package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

public interface CustomUserDetailsService extends UserDetailsService {
    boolean addNewUser(User user);
    List<User> getAllUsers();
    void changeUserRole(User user, Map<String, String> form);
}
