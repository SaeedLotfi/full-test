package com.saeed.full.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello_withoutName_returnsDefault() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    void sum_withParameters_returnsTotal() throws Exception {
        mockMvc.perform(get("/api/sum")
                        .param("a", "10")
                        .param("b", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("30"));

    }
}
