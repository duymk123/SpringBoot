package com.example.duy_backend.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class OrderItemReq {

    private Long id;

    @Min(value = 1, message = "Phai mua tu 1 mon hang tro len")
    private Long quantity;

}
