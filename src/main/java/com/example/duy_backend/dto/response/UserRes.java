package com.example.duy_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRes implements Serializable {
//    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
}
