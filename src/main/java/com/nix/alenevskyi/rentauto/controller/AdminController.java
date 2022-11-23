package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.entity.Car;
import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.services.AdminService;
import com.nix.alenevskyi.rentauto.services.AutoRentService;
import com.nix.alenevskyi.rentauto.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String admin(@ModelAttribute("model") ModelMap model) {
        List<User> users = adminService.getAllUsers();
        model.addAttribute("userList", users);
        return "/pages/admin";
    }

    @GetMapping("/admin/edit-user")
    public String users(@ModelAttribute("model") ModelMap model) {
        List<User> users = adminService.getAllUsers();
        model.addAttribute("userList", users);
        return "/pages/users";
    }

    @GetMapping("/admin/edit-user/{user}")
    public ModelAndView editUser(@PathVariable("user") User user,
                           @ModelAttribute("model") ModelMap model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return new ModelAndView("/pages/edit-user", model);
    }

    @PostMapping("/admin/edit-user")
    public String editUser(@RequestParam("user") User user,
                           @RequestParam Map<String, String> form
    ) {
        adminService.changeUserRole(user, form);
        return "redirect:/admin";
    }
}
