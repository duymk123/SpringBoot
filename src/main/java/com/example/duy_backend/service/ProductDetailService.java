package com.example.duy_backend.service;

import com.example.duy_backend.dto.request.ProductDetailCreateReq;
import com.example.duy_backend.entity.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> getAll();

    ProductDetail create(ProductDetailCreateReq request);
}
