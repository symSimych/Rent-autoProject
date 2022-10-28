package com.nix.alenevskyi.rentauto.dto;

import com.nix.alenevskyi.rentauto.annotation.PasswordMatches;
import com.nix.alenevskyi.rentauto.entity.Role;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    String firstname;

    @NotNull
    @NotEmpty
    String lastname;

    @NotNull
    @NotEmpty
    String email;

    @NotNull
    @NotEmpty
    String phoneNumber;

    @NotNull
    @NotEmpty
    String password;
    String matchingPassword;
}
