package com.nix.alenevskyi.rentauto.services;

import com.nix.alenevskyi.rentauto.entity.Role;
import com.nix.alenevskyi.rentauto.entity.User;
import com.nix.alenevskyi.rentauto.repositories.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    private AdminService adminService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUsersTest() {
        List<User> user = adminService.getAllUsers();
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void changeUserRoleTest(){
        Set<Role> set = new HashSet<>();
        set.add(Role.ROLE_USER);
        User user = User.builder()
                .email("mail@mail.com")
                .roles(set)
                .build();
        Map<String, String> rolesMap = new HashMap<>();
        rolesMap.put(Role.ROLE_ADMIN.getRoleName(), "ROLE_ADMIN");
        adminService.changeUserRole(user, rolesMap);

        assertTrue(CoreMatchers.is(user.getRoles()).matches(Set.of(Role.ROLE_ADMIN)));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}