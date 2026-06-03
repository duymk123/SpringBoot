package com.example.duy_backend.controller;

import com.example.duy_backend.dto.request.UserRegisterReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated

public class UserController {

    @PostMapping("/register")
    ResponseEntity<?> createUser(@RequestBody @Valid UserRegisterReq req) {
        return ResponseEntity.ok().body("success");
    }
}
