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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AnimalTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    /**
     * Ein Tier per Name holen können
     */
    public void testGetEndpointAnimal200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/animals/UnitTest")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("UnitTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.species").value("birds"))
                .andExpect(jsonPath("$.links[*].href", containsInAnyOrder("/animals", "/animals/UnitTest")))
                .andExpect(jsonPath("$.links[*].rel", containsInAnyOrder("_all", "_self")))
                .andExpect(jsonPath("$.links[*].type", containsInAnyOrder("GET", "GET")));
    }

    @Test
    public void testGetEndpointAnimal204() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/animals/Any")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
