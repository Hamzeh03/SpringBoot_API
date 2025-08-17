package com.hamzehSBJ.API.repo;

import com.hamzehSBJ.API.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , Long> {
    Page<Product> findByCategory (String category , Pageable pageable);
}
