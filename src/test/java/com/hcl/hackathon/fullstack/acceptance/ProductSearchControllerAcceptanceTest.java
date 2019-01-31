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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
                .andExpect(content().json("[\n" +
                    "  {\n" +
                    "    \"name\": \"LG\",\n" +
                    "    \"description\": \"LG Golden eye television\",\n" +
                    "    \"categories\": [\n" +
                    "      \"smart phone\",\n" +
                    "      \"electronics\",\n" +
                    "      \"video\",\n" +
                    "      \"tv\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 3.7,\n" +
                    "    \"totalRatings\": 10.0\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Samsung 3d\",\n" +
                    "    \"description\": \"Samsung three dimensional television\",\n" +
                    "    \"categories\": [\n" +
                    "      \"smart phone\",\n" +
                    "      \"electronics\",\n" +
                    "      \"video\",\n" +
                    "      \"tv\",\n" +
                    "      \"3d\"\n" +
                    "    ],\n" +
                    "    \"averageRating\": 4.7,\n" +
                    "    \"totalRatings\": 209.0\n" +
                    "  }\n" +
                    "]"));
    }
}
