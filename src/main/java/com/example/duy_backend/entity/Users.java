package com.example.duy_backend.entity;

import com.example.duy_backend.common.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
