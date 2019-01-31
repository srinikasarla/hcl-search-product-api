package com.hcl.hackathon.fullstack.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private String name;
    private String description;
    private List<String> categories;
    private Double averageRating;
    private Long totalRatings;
    private String imageBytes;
}
