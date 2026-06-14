package com.example.duy_backend.controller;

import com.example.duy_backend.dto.request.UserReq;
import com.example.duy_backend.dto.response.UserRes;
import com.example.duy_backend.entity.Users;
import com.example.duy_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users")

public class UserController {
    private final UserService userService;
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')") // SET ROLE CHI CO ADMIN MOI CO QUYEN ACCESS
    public ResponseEntity<List<UserRes>> getAllUsers() {
        List<UserRes> userResList = userService.getAllUsers();
        log.info("Get all users successful");
        return ResponseEntity.ok(userResList);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<UserRes> getUserById(@PathVariable(value = "id") Long id) {
        Users user = userService.findById(id);
        UserRes userRes = modelMapper.map(user, UserRes.class);
        return ResponseEntity.ok(userRes);
    }

    @PostMapping("/register")
    ResponseEntity<UserRes> createUser(@RequestBody @Valid UserReq req) {
        Users user = userService.createUser(req);
        UserRes userRes = modelMapper.map(user, UserRes.class);
        return ResponseEntity.ok(userRes);
    }
}
