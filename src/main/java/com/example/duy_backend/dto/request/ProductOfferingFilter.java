package com.example.duy_backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOfferingFilter {
//    @RequestParam(name = "name", required = false) String name,
//    @RequestParam(name = "minPrice", required = false) Long minPrice,
//    @RequestParam(name = "maxPrice", required = false) Long maxPrice,
//    @RequestParam(name = "color", required = false) String color,
//    @RequestParam(name = "status", required = false) String status)

    private String name;
    private Long minPrice;
    private Long maxPrice;
    private String color;
    private String status;
}
