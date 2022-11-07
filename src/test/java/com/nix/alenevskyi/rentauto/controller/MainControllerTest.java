package com.nix.alenevskyi.rentauto.controller;

import com.nix.alenevskyi.rentauto.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
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
@WithUserDetails(value = "name@gmail.com")
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Test
    public void allCarsPageTest() throws Exception {
        this.mockMvc.perform(get("/all_cars"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='navbarSupportedContent']/div").string("\n" +
                        "        name@gmail.com\n" +
                        "        Logout\n" +
                        "      "));
    }

    @Test
    public void allCarsListTest() throws Exception {
        this.mockMvc.perform(get("/all_cars"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='carList']/div").nodeCount(2));
    }

    @Test
    public void carDetailsTest() throws Exception {
        this.mockMvc.perform(get("/all_cars/{id}", "5b9da910-c3fd-4a49-9465-dcae9eb7c292"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]/div[2]").string("\n" +
                        "        Toyota Camry\n" +
                        "    "));
    }

    @Test
    public void createUserTest() throws Exception {
        this.mockMvc.perform(post("/registration")
                        .param("firstname", "Tom")
                        .param("lastname", "Thomson")
                        .param("email", "tom@gmail.com")
                        .param("phoneNumber", "0997830040")
                        .param("password", "qwerty")
                        .param("confirmPassword", "qwerty"))
                .andDo(print())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void createUserTest_ValidatePassword() throws Exception {
        this.mockMvc.perform(post("/registration")
                        .param("firstname", "Tom")
                        .param("lastname", "Thomson")
                        .param("email", "adg@gmail.com")
                        .param("phoneNumber", "0997830040")
                        .param("password", "qwerty")
                        .param("confirmPassword", "a"))
                .andDo(print())
                .andExpect(xpath("/html/body/div[1]/form/div[5]/div/div").string("\n" +
                        "                        Passwords are different\n" +
                        "                      "));
    }

    @Test
    public void createUserTest_ValidateEmail() throws Exception {
        this.mockMvc.perform(post("/registration")
                        .param("firstname", "Tom")
                        .param("lastname", "Thomson")
                        .param("email", "tom@gmail.com")
                        .param("phoneNumber", "0997830040")
                        .param("password", "qwerty")
                        .param("confirmPassword", "qwerty"))
                .andDo(print())
                .andExpect(xpath("/html/body/div[1]/form/div[4]/div/div").string("\n" +
                        "                        User with tom@gmail.com already exists\n" +
                        "                      "));
    }

    @Test
    public void createOrderTest() throws Exception {
        this.mockMvc.perform(post("/all_cars")
                        .param("placeOfFiling", "Kiyv,Airport-Boryspol")
                        .param("filingTime", "2022-11-11T17:30:00")
                        .param("placeOfReturn", "Kiyv,Airport-Boryspol")
                        .param("returnTime", "2022-11-14T17:30:00")
                        .param("carId", "5b9da910-c3fd-4a49-9465-dcae9eb7c292"))
                .andDo(print())
                .andExpect(xpath("//div[@id='carList']/div").nodeCount(6));
    }
}