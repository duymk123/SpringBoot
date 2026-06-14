package com.example.duy_backend.service.impl;

import com.example.duy_backend.dto.request.ProductDetailCreateReq;
import com.example.duy_backend.entity.ProductDetail;
import com.example.duy_backend.repository.ProductDetailRepo;
import com.example.duy_backend.service.ProductDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {
//    @Autowired
    private final ProductDetailRepo productDetailRepo;


    @Override
    public List<ProductDetail> getAll() {
        return productDetailRepo.findAll();
    }

    @Transactional
    @Override
    public ProductDetail create(ProductDetailCreateReq request) {
        if(request.getWeight() == null || request.getFeature() == null || request.getPower() == null){
            throw new RuntimeException("Khong duoc bo trong");
        }
        ProductDetail productDetail = new ProductDetail();
        productDetail.setWeight(request.getWeight());
        productDetail.setFeature(request.getFeature());
        productDetail.setPower(request.getPower());
        productDetail.setBrand(request.getBrand());
        productDetail.setImage(request.getImage());
        productDetail.setVideo(request.getVideo());
        return productDetailRepo.save(productDetail);
    }


}
