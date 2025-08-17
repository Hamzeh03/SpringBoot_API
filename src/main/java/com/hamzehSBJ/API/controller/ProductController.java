package com.hamzehSBJ.API.controller;

import com.hamzehSBJ.API.model.Product;
import com.hamzehSBJ.API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Map<String, Object> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit,
            @RequestParam(required = false) String category) {

        Page<Product> productsPage = service.getProducts(category, page, limit);

        Map<String, Object> response = new HashMap<>();
        response.put("products", productsPage.getContent());

        Map<String, Object> pagination = new HashMap<>();
        pagination.put("page", page);
        pagination.put("totalPages", productsPage.getTotalPages());

        response.put("pagination", pagination);

        return response;
    }
}
