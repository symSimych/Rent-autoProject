package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//@NoArgsConstructor
@RequiredArgsConstructor
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean addNewUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setRoles(Set.of(Role.ROLE_USER));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void changeUserRole(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key:form.keySet()) {
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByEmail(username))
                .orElseThrow(() -> new UsernameNotFoundException("Username was not found!"));
    }
}
