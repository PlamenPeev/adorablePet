package com.example.adorablepet.web;

import com.example.adorablepet.models.dtos.ManipulationEntityDTO;
import com.example.adorablepet.models.dtos.TypeOfManipulationDTO;
import com.example.adorablepet.service.TypeOfManipulationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceListControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TypeOfManipulationService mockTypeOfManipulationService;


    @MockBean
    private ManipulationEntityDTO mockManipulationEntityDTO;

    @Test
    void testGetAllType() throws Exception {
        TypeOfManipulationDTO type1 = new TypeOfManipulationDTO()
                .setId(1L)
                .setType(mockManipulationEntityDTO.setName("Type 1"))
                .setTitle("INJECTIONS")
                .setPrice(new BigDecimal(10));

        TypeOfManipulationDTO type2 = new TypeOfManipulationDTO()
                .setId(2L)
                .setType(mockManipulationEntityDTO.setName("Type 2"))
                .setTitle("EXAMINATIONS")
                .setPrice(new BigDecimal(15));
        List<TypeOfManipulationDTO> types = Arrays.asList(type1, type2);

        given(mockTypeOfManipulationService.getAllTypes()).willReturn(types);

        mockMvc.perform(get("/api/manipulations"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{\"id\":1,\"title\":\"INJECTIONS\"}," +
                                         "{\"id\":2,\"title\":\"EXAMINATIONS\"}]"));
    }

    @Test
    void testGetTypeOfManipulationById() throws Exception {
        TypeOfManipulationDTO type1 = new TypeOfManipulationDTO()
                .setId(1L)
                .setType(mockManipulationEntityDTO.setName("Type 1"))
                .setTitle("INJECTIONS")
                .setPrice(new BigDecimal(10));

        given(mockTypeOfManipulationService.findTypeOfManipulationById(1L)).willReturn(Optional.of(type1));

        mockMvc.perform(get("/api/manipulations/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"title\":\"INJECTIONS\"}"));
    }

    @Test
    void testGetTypeOfManipulationByIdNotFound() throws Exception {
        given(mockTypeOfManipulationService
                .findTypeOfManipulationById(1L)).willReturn(Optional.empty());

        mockMvc.perform(get("/api/manipulations/1"))
                .andExpect(status().isNotFound());
    }

//    @Test
//   // @WithMockUser(username="admin",roles={"USER","ADMIN"})
//    void testCreateType() throws Exception {
//        TypeOfManipulationDTO newType = new TypeOfManipulationDTO()
//                .setId(null)
//                .setPrice(new BigDecimal(13))
//                .setTitle("New_Type");
//
//
//        given(mockTypeOfManipulationService.createTypeOfManipulation(newType)).willReturn(3L);
//
//        mockMvc.perform(post("/api/manipulations")
//                        //.contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"New Type\"}"))
//                .andExpect(status().isCreated())
//                .andExpect(header().string("Location", "/api/manipulations/3"));
//    }

    @Test
    void testGetManipulationById() throws Exception {
        mockMvc.perform(get("/api/manipulations/api/manipulations/1"))
                .andExpect(status().isNotFound());
    }
}
