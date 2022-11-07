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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails(value = "name@gmail.com")
class ManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Test
    public void managerPage() throws Exception {
        this.mockMvc.perform(get("/manager"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]").nodeCount(1));
    }

    @Test
    public void changeOrderPageTest()throws Exception {
        this.mockMvc.perform(get("/manager/order/{order}", "5f5af688-4366-4e7a-8a4d-9202e6740103"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]").nodeCount(1));
    }

    @Test
    public void carManagePageTest()throws Exception {
        this.mockMvc.perform(get("/manager/car_manage"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div").nodeCount(2));
    }

    @Test
    public void carPageTest()throws Exception {
        this.mockMvc.perform(get("/manager/car_manage/{car}", "5b9da910-c3fd-4a49-9465-dcae9eb7c292"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("/html/body/div[1]").nodeCount(1));
    }

    @Test
    public void changeCarParameterTest() throws Exception {
        this.mockMvc.perform(post("/manager/car_manage/{car}", "f294f545-ce35-4385-8f1f-07e190aafea9")
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
                        .param("price", "45")
                        .param("status", "true"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk());
    }

    @Test
    public void changeOrderTest() throws Exception {
        this.mockMvc.perform(post("/manager/order/{order}", "5f5af688-4366-4e7a-8a4d-9202e6740103")
                        .param("placeOfFiling", "Kiyv,Airport-Boryspol")
                        .param("filingTime", "2022-11-11T17:30:00")
                        .param("placeOfReturn", "Kiyv,Airport-Boryspol")
                        .param("returnTime", "2022-11-14T17:30:00")
                        .param("carId", "5b9da910-c3fd-4a49-9465-dcae9eb7c292"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}