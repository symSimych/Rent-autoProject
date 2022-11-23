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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
@Sql(value = "/db/create_order.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/db/delete_order.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithUserDetails(value = "m@gmail.com")
class ManagerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ManagerController managerController;

    @Test
    public void managerMainPageTest() throws Exception {
        this.mockMvc.perform(get("/manager"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/manager"));
    }

    @Test
    public void orderDetailsPageList() throws Exception {
        this.mockMvc.perform(get("/manager/order/be135665-3923-4c6f-af04-698d45ac36b9"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/change-order"));
    }

    @Test
    public void carManagePageTest() throws Exception {
        this.mockMvc.perform(get("/manager/car-manage/a327a4df-a3ef-4aff-96dc-2f6548a22cd4"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/edit-car"));
    }

    @Test
    public void listCarPageTest() throws Exception {
        this.mockMvc.perform(get("/manager/car-manage"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/car-manage"));
    }

    @Test
    public void addCarPageTest() throws Exception {
        this.mockMvc.perform(get("/manager/add-car"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/add-car"));
    }

    @Test
    public void addCarTest() throws Exception {
        MockHttpServletRequestBuilder multipart = multipart("/add-new-car")
                .file("files", "123".getBytes())
                .param("brand", "qweqr")
                .param("model", "assaf")
                .param("bodyType", "sdf")
                .param("year", "645")
                .param("transmission", "gfdass")
                .param("fuelType", "gsfasd")
                .param("engineVolume", "1.9")
                .param("horsePower", "190")
                .param("tankVolume", "50")
                .param("fuelConsumption", "5.5")
                .param("bail", "300")
                .param("price", "45");

        this.mockMvc.perform(multipart)
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/add-car"));
    }

    @Test
    public void manageCarTest() throws Exception {
        MockHttpServletRequestBuilder multipart = multipart("/manager/car-manage/a327a4df-a3ef-4aff-96dc-2f6548a22cd4")
                .file("files", "123".getBytes())
                .param("brand", "qweqr")
                .param("carModel", "assaf")
                .param("bodyType", "sdf")
                .param("year", "5123")
                .param("transmission", "sda")
                .param("fuelType", "gsfasd")
                .param("engineVolume", "1.8")
                .param("horsePower", "180")
                .param("tankVolume", "50")
                .param("fuelConsumption", "5")
                .param("bail", "300")
                .param("price", "45")
                .param("status", "true")
                .param("car", "a327a4df-a3ef-4aff-96dc-2f6548a22cd4");

        this.mockMvc.perform(multipart)
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/edit-car"));
    }

    @Test
    public void changeOrderTest() throws Exception {
        this.mockMvc.perform(post("/manager/order/be135665-3923-4c6f-af04-698d45ac36b9")
                        .param("order", "be135665-3923-4c6f-af04-698d45ac36b9")
                        .param("placeOfFiling", "wfdDAS")
                        .param("filingTime", "2022-11-23T20:45")
                        .param("placeOfReturn", "GESAD")
                        .param("returnTime", "2022-11-27T20:45")
                )
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/manager"));
    }

    @Test
    public void confirmOrderTest() throws Exception {
        this.mockMvc.perform(post("/manager")
                        .param("carId", "a327a4df-a3ef-4aff-96dc-2f6548a22cd4")
                        .param("orderId", "be135665-3923-4c6f-af04-698d45ac36b9")
                ).andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/manager"));
    }

    @Test
    public void findByPhoneTest() throws Exception {
        this.mockMvc.perform(post("/manager")
                        .param("phoneNumber", "05651")
                ).andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/manager"));
    }

    @Test
    public void findByEmptyPhoneTest() throws Exception {
        this.mockMvc.perform(post("/manager")
                        .param("phoneNumber", "")
                ).andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isOk())
                .andExpect(view().name("/pages/manager"));
    }
}