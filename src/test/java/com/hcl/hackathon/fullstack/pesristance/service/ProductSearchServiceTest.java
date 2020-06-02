package com.hcl.hackathon.fullstack.service;

import com.google.common.collect.Lists;
import com.hcl.hackathon.fullstack.models.ProductResponse;
import com.hcl.hackathon.fullstack.pesristance.ProductRepository;
import com.hcl.hackathon.fullstack.pesristance.entities.Category;
import com.hcl.hackathon.fullstack.pesristance.entities.Product;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductSearchServiceTest {

    private ProductSearchService subject;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ImageService imageService;
    private Random random = new Random();

    @Before
    public void setUp() {
        subject = new ProductSearchService(productRepository, imageService);
    }

    @Test
    public void search_callsProductRepository() {
        String search = "somerandomtext" + random.nextLong();
        subject.search(search);
        verify(productRepository).findByGivenSearch(search);
        verify(imageService, never()).populateImageBytes(any());
    }

    @Test
    public void search_populatesProductResponses() {
        Product product = Product.builder()
            .categories(Lists.newArrayList(Category.builder()
                .name("category1" + random.nextLong())
                .build(), Category.builder()
                .name("category2" + random.nextLong())
                .build()))
            .name("someName" + random.nextLong())
            .averageRating(random.nextDouble())
            .totalRatings(random.nextLong())
            .imagePath("path" + random.nextInt(99))
            .description("some description" + random.nextLong())
            .build();
        when(productRepository.findByGivenSearch(anyString()))
            .thenReturn(Lists.newArrayList(product));
        String imageBytes = "imageBytes" + random.nextLong();
        when(imageService.populateImageBytes(product.getImagePath())).thenReturn(imageBytes);
        List<ProductResponse> actualResponse = subject.search("sometext");

        verify(imageService).populateImageBytes(product.getImagePath());
        assertEquals(actualResponse.size(), 1);
        ProductResponse productResponse = actualResponse.get(0);
        assertEquals(productResponse.getName(), product.getName());
        assertEquals(productResponse.getAverageRating(), product.getAverageRating());
        assertEquals(productResponse.getTotalRatings(), product.getTotalRatings());
        assertEquals(productResponse.getDescription(), product.getDescription());
        assertEquals(productResponse.getImageBytes(), imageBytes);
        assertEquals(productResponse.getCategories().get(0), product.getCategories().get(0).getName());
        assertEquals(productResponse.getCategories().get(1), product.getCategories().get(1).getName());
    }
}
