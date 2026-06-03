package com.example.duy_backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserRegisterReq {

    @NotBlank(message = "not null")
    @Length(min = 3, max = 20)
    private String username;

    @NotBlank(message = "not null")
    @Length(min = 8)
    private String password;

    @NotBlank(message = "not null")
    @Email
    private String email;

    @NotBlank(message = "not null")
    private String fullname;


}
