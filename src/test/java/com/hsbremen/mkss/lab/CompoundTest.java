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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CompoundTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    /**
     * Alle Gehege holen können
     */
    public void testGetEndpointAllCompounds200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/compounds")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    /**
     * Ein Gehege per Name holen können
     */
    public void testGetEndpointOneCompounds200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/compounds/birds")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

}
