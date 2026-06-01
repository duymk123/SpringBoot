package com.example.duy_backend.repository;

import com.example.duy_backend.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepo extends JpaRepository<ProductDetail, Long> {
}
