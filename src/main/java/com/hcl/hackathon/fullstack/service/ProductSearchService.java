package com.hcl.hackathon.fullstack.service;

import com.hcl.hackathon.fullstack.models.ProductResponse;
import com.hcl.hackathon.fullstack.pesristance.ProductRepository;
import com.hcl.hackathon.fullstack.pesristance.entities.Product;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductSearchService {

    private ProductRepository productRepository;
    private ImageService imageService;

    public List<ProductResponse> search(String search) {

        List<Product> results = productRepository.findByGivenSearch(search);
        return results
            .stream()
            .map(product -> ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .averageRating(product.getAverageRating())
                .totalRatings(product.getTotalRatings())
                .imageBytes(imageService.populateImageBytes(product.getImagePath()))
                .categories(product.getCategories()
                    .stream()
                    .map(category -> category.getName())
                    .collect(Collectors.toList()))
                .build())
            .collect(Collectors.toList());
    }
}
