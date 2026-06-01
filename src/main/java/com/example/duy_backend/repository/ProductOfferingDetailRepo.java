package com.example.duy_backend.repository;
import java.util.List;
import java.util.Optional;


import com.example.duy_backend.entity.ProductDetail;
import com.example.duy_backend.entity.ProductOfferingDetail;
import com.example.duy_backend.entity.ProductOfferings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductOfferingDetailRepo extends JpaRepository<ProductOfferingDetail, Long> {

    @Query("delete from ProductOfferingDetail p where p.id = :id")
    void deleteById(Long id);

    Optional<ProductOfferingDetail> findByProductOfferingsAndProductDetail(ProductOfferings productOfferings, ProductDetail productDetail);

}
