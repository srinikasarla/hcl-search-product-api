package com.hcl.hackathon.fullstack.controller;

import com.hcl.hackathon.fullstack.models.ProductResponse;
import com.hcl.hackathon.fullstack.service.ProductSearchService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductSearchController {

    private ProductSearchService productSearchService;

    @GetMapping
    @SneakyThrows
    public List<ProductResponse> searchProducts(@RequestParam(defaultValue = "") String search) {
        return productSearchService.search(search);
    }
}
