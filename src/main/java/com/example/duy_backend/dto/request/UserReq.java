package com.example.duy_backend.dto.request;

import com.example.duy_backend.common.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.management.relation.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {
    @NotBlank(message = "username khong duoc bo trong")
    @Length(min = 3, max = 20)
    private String username;

    @Size(min = 8, max = 20, message = "Mật khẩu phải từ 8 đến 20 ký tự")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
            message = "Mật khẩu phải chứa chữ hoa, chữ thường, số và ký tự đặc biệt"
    )
    private String password;

    @NotBlank(message = "fullName khong duoc bo trong")
    @Length(min = 10)
    private String fullName;

    @NotBlank(message = "SDT khong duoc bo trong")
    @Length(min = 10, message = "SDT phai toi thieu 10 chu so")
    private String phoneNumber;

    private RoleEnum role;
}
