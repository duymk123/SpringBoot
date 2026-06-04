package com.example.duy_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test-exception")
public class ExceptionController {
    @GetMapping
    public Object testSystemError() {
        throw new RuntimeException("TEST SYSTEM ERROR");
    }
}
