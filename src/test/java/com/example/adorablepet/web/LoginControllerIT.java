package com.example.adorablepet.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoginPageShown() throws Exception {
        mockMvc.perform(get("/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void testFailedLogin() throws Exception {
        String email = "testUser@test.com";
        mockMvc.perform(post("/users/login-error")
                        .param(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, email))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("users/login"));
//                .andExpect(flash().attribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, email))
//                .andExpect(flash().attribute("bad_credentials", true));

    }

      @Test
           public void testLoginSuccessfully() throws Exception {

        mockMvc.perform(post("/users/login")
                        .param("username", "testUser@test.com")
                        .param("password", "test1234")
                        .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/"));

    }

}
