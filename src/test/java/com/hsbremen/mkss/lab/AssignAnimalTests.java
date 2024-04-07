package com.hsbremen.mkss.lab;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AssignAnimalTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void assertAnimalHasNoCompound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/compounds")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].name", not(hasItem("UnitTest"))));
    }



    @Test
    public void testPutAnimalIntoCompound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/compounds/birds/animals/UnitTest")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    //Assert UnitTest ist in birds
    @Test
    public void testRemoveAnimalFromCompound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/compounds/birds/animals/UnitTest")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testIfUnitTestsIsNotInBirdsCompound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/compounds/birds")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].name", not(hasItem("UnitTest"))));
    }


    @Test
    public void assertAnimalHasNoMoreCompound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/compounds")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].name", not(hasItem("UnitTest"))));
    }
}


