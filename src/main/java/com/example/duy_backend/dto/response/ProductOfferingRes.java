package com.example.duy_backend.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductOfferingRes implements Serializable {
    private Long id;

    private String name;

    private Long price;

    private String color;
}
