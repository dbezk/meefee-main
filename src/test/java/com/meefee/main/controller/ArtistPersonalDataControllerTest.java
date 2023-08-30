package com.meefee.main.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
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
public class ArtistPersonalDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String accessToken;

    @BeforeEach
    void loginAsArtist() throws Exception {
        String loginResponse = mockMvc.perform(MockMvcRequestBuilders.get("/api/login")
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .param("email", "artist@artist.com")
                        .param("password", "Password123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        accessToken = JsonPath.parse(loginResponse).read("$.accessToken");
    }

    @Test
    @Order(2)
    void getArtistFullPersonalData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/artist/personal")
                        .header("Authorization", "Bearer " + accessToken))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").isNotEmpty());
    }

}
