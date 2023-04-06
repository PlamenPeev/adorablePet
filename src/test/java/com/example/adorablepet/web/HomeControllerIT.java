package com.example.adorablepet.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "test@test.com",
    password = "test123123")
    public void testMyPetsPageShown() throws Exception {
        mockMvc.perform(get("/pages/my-pets")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/my-pets"));
    }

    @Test
    @WithMockUser(username = "test@test-moderator.com",
            password = "test123123")
    public void testModeratorsPageShown() throws Exception {
        mockMvc.perform(get("/pages/moderators")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/moderators"));
    }

    @Test
    public void testAdminsPageShown() throws Exception {
        mockMvc.perform(get("/pages/admins")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/admins"));
    }


}
