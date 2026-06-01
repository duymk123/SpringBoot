package com.example.duy_backend.dto.request;

import com.example.duy_backend.repository.ProductOfferingRepo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailCreateReq implements Serializable {
    private Long weight;

    private String feature;

    private String power;

    private String brand;

    private String image;

    private String video;
}
