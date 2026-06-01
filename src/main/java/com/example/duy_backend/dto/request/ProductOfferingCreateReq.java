package com.example.duy_backend.dto.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductOfferingCreateReq implements Serializable {
    private String name;
    private Long price;
    private String color;

}
