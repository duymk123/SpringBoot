package com.example.duy_backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductOfferingCreateReq implements Serializable {
    @NotBlank(message = "not null")
    @Length(min = 10, max = 20)
    private String name;

    private Long price;


    private String color;

}
