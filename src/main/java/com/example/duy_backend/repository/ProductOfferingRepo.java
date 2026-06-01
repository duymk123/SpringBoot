package com.example.duy_backend.repository;

import ch.qos.logback.core.status.Status;
import com.example.duy_backend.entity.ProductOfferings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long>, JpaSpecificationExecutor<ProductOfferings> {

    @Query("select po " +
            "from ProductOfferings po " +
            "where po.id in (select pod.productOfferings.id from ProductOfferingDetail pod where pod.productDetail.id = 1)")




    List<ProductOfferings> findByColor(String color);

    List<ProductOfferings> findByNameAndPrice(String name, Long price);

    List<ProductOfferings> findByColorAndPrice(String color, Long price);

    List<ProductOfferings> findByName(String name);

    List<ProductOfferings> findByNameAndStatus(String name, Status status);

//    List<ProductOfferings>

    @Query(value = "select * from product_offerings order by id limit :pageSize offset :offsetValue", nativeQuery = true)
    List<ProductOfferings> getAllByPage(Integer pageSize, Integer offsetValue);

}
