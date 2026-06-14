package com.example.duy_backend.controller;

import com.example.duy_backend.dto.request.OrderReq;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@Validated
public class OrderController {
    @PostMapping
    ResponseEntity<?> createOrder(@RequestBody @Valid OrderReq req) {

        return ResponseEntity.ok().body("success");
    }


}
