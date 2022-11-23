package com.nix.alenevskyi.rentauto.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yaml")
@Sql(value = "/db/create_user.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/db/delete_user.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Sql(value = "/db/create_car.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/db/delete_car.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//@WithUserDetails(value = "m@gmail.com")
class MainControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MainController mainController;

    @Test
    public void mainPageTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/index"));
    }

    @Test
    @WithUserDetails(value = "m@gmail.com")
    public void carListTest() throws Exception {
        this.mockMvc.perform(get("/all-cars"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/all-cars"));
    }

    @Test
    @WithUserDetails(value = "m@gmail.com")
    public void carDetailsPageTest() throws Exception {
        this.mockMvc.perform(get("/all-cars/a327a4df-a3ef-4aff-96dc-2f6548a22cd4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(authenticated())
                .andExpect(view().name("/pages/car-details"));
    }

    @Test
    @WithUserDetails(value = "m@gmail.com")
    public void makeOrderTest() throws Exception {
        this.mockMvc.perform(post("/all-cars/a327a4df-a3ef-4aff-96dc-2f6548a22cd4")
                    .param("placeOfFiling", "qweqr")
                    .param("filingTime", "2022-11-23T17:45")
                    .param("placeOfReturn", "qwrffas")
                    .param("returnTime", "2022-11-25T17:45")
                    .param("carId", "a327a4df-a3ef-4aff-96dc-2f6548a22cd4")
                )
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/all-cars"));
    }

    @Test
    public void registrationPageTest() throws Exception {
        this.mockMvc.perform(get("/registration"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/registration"));
    }

    @Test
    public void registerUserTest() throws Exception {
        this.mockMvc.perform(post("/registration")
                                .param("user", "a@gmail.com")
                                .param("firstname", "a")
                                .param("lastname", "b")
                                .param("email", "a@gmail.com")
                                .param("phoneNumber", "564517864")
                                .param("password", "qwe")
                                .param("confirmPassword", "qwe"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void registerUser_userAlreadyExistsTest() throws Exception {
        this.mockMvc.perform(post("/registration")
                        .param("user", "m@gmail.com")
                        .param("firstname", "a")
                        .param("lastname", "b")
                        .param("email", "m@gmail.com")
                        .param("phoneNumber", "564517864")
                        .param("password", "qwe")
                        .param("confirmPassword", "qwe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/registration"));
    }

    @Test
    public void registerUser_badValidateTest() throws Exception {
        this.mockMvc.perform(post("/registration")
                        .param("user", "a@gmail.com")
                        .param("firstname", "")
                        .param("lastname", "")
                        .param("email", "a@gmail.com")
                        .param("phoneNumber", "564517864")
                        .param("password", "qwe")
                        .param("confirmPassword", "qwe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/registration"));
    }

    @Test
    public void registerUser_badValidatePasswordTest() throws Exception {
        this.mockMvc.perform(post("/registration")
                        .param("user", "a@gmail.com")
                        .param("firstname", "a")
                        .param("lastname", "b")
                        .param("email", "a@gmail.com")
                        .param("phoneNumber", "564517864")
                        .param("password", "")
                        .param("confirmPassword", "qe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/registration"));
    }
}