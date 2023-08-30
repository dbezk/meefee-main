package com.meefee.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meefee.main.dto.NewAccountDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @Order(1)
    void registerUser() throws Exception {
        NewAccountDTO newAccountDTO = new NewAccountDTO();
        newAccountDTO.setEmail("user@user.com");
        newAccountDTO.setPassword("Password123");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/register/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newAccountDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @Order(2)
    void registerArtist() throws Exception {
        NewAccountDTO newAccountDTO = new NewAccountDTO();
        newAccountDTO.setEmail("artist@artist.com");
        newAccountDTO.setPassword("Password123");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/register/artist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newAccountDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
