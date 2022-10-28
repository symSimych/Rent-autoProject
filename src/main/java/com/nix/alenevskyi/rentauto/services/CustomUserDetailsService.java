package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
    void addNewUser(User user);
}
