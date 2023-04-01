package com.example.adorablepet.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class PagesControllerIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testDepartmentsPageShown() throws Exception {
        mockMvc.perform(get("/pages/departments")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/departments"));
    }


    @Test
    public void testDepartmentsMoreInfoPageShown() throws Exception {
        mockMvc.perform(get("/pages/departments-more-info")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/departments-more-info"));
    }


    @Test
    public void testOurTeamPageShown() throws Exception {
        mockMvc.perform(get("/pages/our-team")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/our-team"));
    }


    @Test
    public void testInformationPageShown() throws Exception {
        mockMvc.perform(get("/pages/information")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/information"));
    }


    @Test
    public void testPriceListPageShown() throws Exception {
        mockMvc.perform(get("/pages/price-list")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/price-list"));
    }


    @Test
    public void testClinicServicePageShown() throws Exception {
        mockMvc.perform(get("/pages/clinic-services")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/clinic-services"));
    }


    @Test
    public void testGoodHeartPageShown() throws Exception {
        mockMvc.perform(get("/pages/good-heart")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/good-heart"));
    }


    @Test
    public void testProjectsPageShown() throws Exception {
        mockMvc.perform(get("/pages/projects")).
                andExpect(status().isOk()).
                andExpect(view().name("pages/projects"));
    }

}
