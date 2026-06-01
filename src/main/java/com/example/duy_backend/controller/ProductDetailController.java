package com.example.duy_backend.controller;

import com.example.duy_backend.dto.request.ProductDetailCreateReq;
import com.example.duy_backend.entity.ProductDetail;
import com.example.duy_backend.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor// Tự tạo Constructor
@RequestMapping("/api/v1/product-details")
public class ProductDetailController {
    // Container: IoC Container
    // ApplicationContext
    //BeanFactory

    private final ProductDetailService productDetailService;

//    //constructor injection
//    public ProductDetailController(ProductDetailService productDetailService) {
//        this.productDetailService = productDetailService;
//    }

//    setter Constructor
//    @Autowired
//    public void setProductDetailService(ProductDetailService productDetailService) {
//        this.productDetailService = productDetailService;
//    }

    @GetMapping
    public ResponseEntity<List<ProductDetail>> getAll(){
        List<ProductDetail> productDetails = productDetailService.getAll();
        return ResponseEntity.ok(productDetails);
    }

    @PostMapping
    public ResponseEntity<ProductDetail> create(@RequestBody ProductDetailCreateReq request) {
        ProductDetail productDetail = productDetailService.create(request);
        return ResponseEntity.ok(productDetail);
    }
}
