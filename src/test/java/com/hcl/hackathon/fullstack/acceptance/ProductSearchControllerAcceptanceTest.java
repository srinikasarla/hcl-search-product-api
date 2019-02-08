package com.hcl.hackathon.fullstack.acceptance;

import com.hcl.hackathon.fullstack.FullStackApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {FullStackApplication.class})
public class ProductSearchControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void search_returnsProducts() throws Exception {

        mockMvc.perform(get("/api/products?search=tv"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$.[0]").exists())
            .andExpect(jsonPath("$.[0].name").value("LG"))
            .andExpect(jsonPath("$.[0].description").value("LG Golden eye television"))
            .andExpect(jsonPath("$.[0].categories[0]").value("electronics"))
            .andExpect(jsonPath("$.[0].categories[1]").value("video"))
            .andExpect(jsonPath("$.[0].categories[2]").value("tv"))
            .andExpect(jsonPath("$.[0].averageRating").value("3.7"))
            .andExpect(jsonPath("$.[0].totalRatings").value("10"))
            .andExpect(jsonPath("$.[0].imageBytes").exists())
            .andExpect(jsonPath("$.[1]").exists())
            .andExpect(jsonPath("$.[1].name").value("Samsung 3d"))
            .andExpect(jsonPath("$.[1].description").value("Samsung three dimensional television"))
            .andExpect(jsonPath("$.[1].categories[0]").value("electronics"))
            .andExpect(jsonPath("$.[1].categories[1]").value("video"))
            .andExpect(jsonPath("$.[1].categories[2]").value("tv"))
            .andExpect(jsonPath("$.[1].categories[3]").value("3d"))
            .andExpect(jsonPath("$.[1].averageRating").value("4.7"))
            .andExpect(jsonPath("$.[1].totalRatings").value("209"))
            .andExpect(jsonPath("$.[1].imageBytes").exists());
    }
}
