package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.entity.Order;
import com.nix.alenevskyi.rentauto.entity.Role;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    String firstname;
    @NotBlank(message = "Lastname cannot be empty")
    String lastname;
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    String email;
    @NotBlank(message = "Phone number cannot be empty")
    String phoneNumber;
    @NotBlank(message = "Password cannot be empty")
    String password;
    @NotBlank(message = "Password confirmation cannot be empty")
    String confirmPassword;
    private Set<Role> roles = new HashSet<>();
    private Set<Order> orders = new HashSet<>();
}
