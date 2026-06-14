package com.example.duy_backend.service;

import com.example.duy_backend.dto.request.UserReq;
import com.example.duy_backend.dto.response.UserRes;
import com.example.duy_backend.entity.Users;

import java.util.List;


public interface UserService {
    Users createUser(UserReq request);

    List<UserRes> getAllUsers();

    Users findById(Long id);
}
