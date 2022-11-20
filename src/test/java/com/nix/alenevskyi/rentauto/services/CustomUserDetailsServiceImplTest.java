package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomUserDetailsServiceImplTest {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void addUserTest() {
        User user = User.builder()
                .email("mail@mail.com")
                .build();
        boolean isCreate = customUserDetailsService.addNewUser(user);

        assertTrue(isCreate);
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Set.of(Role.ROLE_ADMIN)));

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void addUserFailTest() {
        User user = User.builder()
                .email("mail@mail.com")
                .build();

        Mockito.doReturn(new User())
                .when(userRepository)
                .findByEmail("mail@mail.com");

        boolean isCreate = customUserDetailsService.addNewUser(user);
        assertFalse(isCreate);
        Mockito.verify(userRepository, Mockito.times(0)).save(user);
    }


    @Test
    public void loadUserByEmailTest() {
        UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class, () ->{
            String email = "tom@gmail.com";
            User user = (User) customUserDetailsService.loadUserByUsername(email);
        });
        assertTrue(thrown.getMessage().contains("Username was not found!"));
    }

}