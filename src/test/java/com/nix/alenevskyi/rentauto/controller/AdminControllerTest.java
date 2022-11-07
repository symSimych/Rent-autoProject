package com.nix.alenevskyi.rentauto.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails(value = "maks@gmail.com")
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Test
    public void adminPage() throws Exception {
        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]/a[1]").string("Add Car"));
    }

    @Test
    public void adminAddCarPage() throws Exception{
        this.mockMvc.perform(get("/admin/add_car"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]/fieldset/legend").string("Add Car"));
    }

    @Test
    public void adminEditUsersPage() throws Exception {
        this.mockMvc.perform(get("/admin/edit_user"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]").nodeCount(1));
    }

    @Test
    public void adminEditUserPage() throws Exception {
        this.mockMvc.perform(get("/admin/edit_user/{user}", "name@gmail.com"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]/h1").string("Edit user name@gmail.com"));
    }

    @Test
    public void adminAddCarTest() throws Exception {
        this.mockMvc.perform(post("/add_new_car")
                        .param("brand", "Volkswagen")
                        .param("carModel", "Golf")
                        .param("bodyType", "hatchback")
                        .param("transmission", "automatic")
                        .param("year", "2014")
                        .param("fuelType", "gasoline")
                        .param("horsePower", "180")
                        .param("engineVolume", "1.8")
                        .param("fuelConsumption", "6")
                        .param("tankVolume", "45")
                        .param("bail", "500")
                        .param("price", "45"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk());
    }
}