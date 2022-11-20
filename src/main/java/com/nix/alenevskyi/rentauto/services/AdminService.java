package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<User> getAllUsers();
    void changeUserRole(User user, Map<String, String> form);
}
