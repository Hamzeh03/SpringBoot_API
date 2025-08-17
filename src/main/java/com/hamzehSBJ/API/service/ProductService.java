package com.hamzehSBJ.API.service;

import com.hamzehSBJ.API.exception.CategoryNotFoundException;
import com.hamzehSBJ.API.model.Product;
import com.hamzehSBJ.API.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repository;

    public Page<Product> getProducts(String category, int page, int limit) {
        if (page < 1) throw new com.hamzehSBJ.API.exception.InvalidPageException(page);
        Page<Product> result;
        if (category != null && !category.isEmpty()) {
            result = repository.findByCategory(category, PageRequest.of(page - 1, limit));
            if (result.isEmpty()) throw new CategoryNotFoundException(category);
        } else {
            result = repository.findAll(PageRequest.of(page - 1, limit));
        }
        return result;
    }
}
