package com.meefee.main.security;

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
public class LoginTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testUserLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/login")
                .content(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("email", "user@user.com")
                .param("password", "Password123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accessToken").exists());
    }

    @Test
    void testArtistLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/login")
                        .content(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .param("email", "artist@artist.com")
                        .param("password", "Password123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accessToken").exists());
    }

}
