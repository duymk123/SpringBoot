package com.example.duy_backend.service;

import com.example.duy_backend.dto.request.AssignProductDetailReq;
import com.example.duy_backend.entity.ProductOfferings;

public interface ProductOfferingDetailService {
    ProductOfferings AssignProductDetail(AssignProductDetailReq request);
}
