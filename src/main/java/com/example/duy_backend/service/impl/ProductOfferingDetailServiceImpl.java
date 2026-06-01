package com.example.duy_backend.service.impl;

import com.example.duy_backend.dto.request.AssignProductDetailReq;
import com.example.duy_backend.entity.ProductDetail;
import com.example.duy_backend.entity.ProductOfferingDetail;
import com.example.duy_backend.entity.ProductOfferings;
import com.example.duy_backend.repository.ProductDetailRepo;
import com.example.duy_backend.repository.ProductOfferingDetailRepo;
import com.example.duy_backend.repository.ProductOfferingRepo;
import com.example.duy_backend.service.ProductOfferingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductOfferingDetailServiceImpl implements ProductOfferingDetailService {
//    @Autowired
    private final ProductOfferingDetailRepo productOfferingDetailRepo;
//    @Autowired
    private final ProductOfferingRepo productOfferingRepo;
//    @Autowired
    private final ProductDetailRepo productDetailRepo;


    @Override
    public ProductOfferings AssignProductDetail(AssignProductDetailReq request) {
        //validate data
        if(request.getProductOfferingId() == null){
            throw new RuntimeException("productOfferingId is not null");
        }
        if(request.getProductDetailIds() == null || request.getProductDetailIds().isEmpty()){
            throw new RuntimeException("productDetailIds is not null or is empty");
        }
        Optional<ProductOfferings> productOfferingsOptional = productOfferingRepo.findById(request.getProductOfferingId());
        if(productOfferingsOptional.isEmpty()){
            throw new RuntimeException("productOffering not found");
        }
        ProductOfferings productOfferings = productOfferingsOptional.get();
        List<ProductDetail> productDetails = productDetailRepo.findAllById(request.getProductDetailIds());
        if(productDetails.isEmpty()){
            throw new RuntimeException("productDetails not found");
        }
        List<ProductOfferingDetail> productOfferingDetails = new ArrayList<>();
        for(int i =0; i < productDetails.size();i++){
            Optional<ProductOfferingDetail> productOfferingDetailOptional = productOfferingDetailRepo.findByProductOfferingsAndProductDetail(productOfferings,productDetails.get(i));
            if(productOfferingDetailOptional.isPresent()){
                continue;
            }

            ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();
            productOfferingDetail.setProductOfferings(productOfferingsOptional.get());
            productOfferingDetail.setProductDetail(productDetails.get(i));

            productOfferingDetailRepo.delete(productOfferingDetail);
            productOfferingDetails.add(productOfferingDetail);
        }
        productOfferingDetailRepo.saveAll(productOfferingDetails);
        productOfferings.setProductOfferingDetails(productOfferingDetails);
        return productOfferings;
    }
}
