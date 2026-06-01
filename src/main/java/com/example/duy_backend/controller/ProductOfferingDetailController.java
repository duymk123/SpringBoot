package com.example.duy_backend.controller;

import com.example.duy_backend.dto.request.AssignProductDetailReq;
import com.example.duy_backend.entity.ProductOfferingDetail;
import com.example.duy_backend.entity.ProductOfferings;
import com.example.duy_backend.service.ProductOfferingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assign-product-detail")
@RequiredArgsConstructor
public class ProductOfferingDetailController {

    private final ProductOfferingDetailService productOfferingDetailService;

    @PostMapping
    public ResponseEntity<ProductOfferings> assignProductDetail(@RequestBody AssignProductDetailReq request) {
        ProductOfferings productOfferings = productOfferingDetailService.AssignProductDetail(request);
        return ResponseEntity.ok(productOfferings);
    }

}
