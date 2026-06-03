package com.example.duy_backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductOfferingCreateReq implements Serializable {
    @NotBlank(message = "Please import data")
    private String name;
    private Long price;
    private String color;

}
