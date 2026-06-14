package com.example.duy_backend.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderReq implements Serializable {
    @NotBlank(message = "Ten khong duoc bo trong")
    @Length(min = 5)
    private String name;

    @Email(message = "Email khong dung dinh dang")
    @NotBlank(message = "Email khong duoc bo trong")
    private String email;

    @NotEmpty(message = "Danh sach san pham khong duoc bo trong")
    private List<OrderItemReq> items;

    private String discountCode;
}
