package com.example.duy_backend.service;

import com.example.duy_backend.dto.request.ProductOfferingCreateReq;
import com.example.duy_backend.dto.request.ProductOfferingFilter;
import com.example.duy_backend.entity.ProductOfferings;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductOfferingService {
    ProductOfferings getById(Long id);

    Page<ProductOfferings> getAll(Integer pageSize, Integer pageNumber);
    List<ProductOfferings> findByColor(String color);
    List<ProductOfferings> findByNameAndPrice(String name, Long price);
    List<ProductOfferings> findByColorAndPrice(String color, Long price);
    List<ProductOfferings> findByName(String name);

    ProductOfferings createProduct(ProductOfferingCreateReq request);
    ProductOfferings updateProduct(Long id,ProductOfferings productOfferings);

    List<ProductOfferings> filter(ProductOfferingFilter productOfferingFilter);

}
