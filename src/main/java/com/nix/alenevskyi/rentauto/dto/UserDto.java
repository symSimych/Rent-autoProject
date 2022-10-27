package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {

    String firstname;
    String lastname;
    String email;
    String phoneNumber;
    List<RoleDto> roles;
}
