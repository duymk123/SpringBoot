package com.example.duy_backend.service.impl;

import com.example.duy_backend.dto.request.UserReq;
import com.example.duy_backend.dto.response.UserRes;
import com.example.duy_backend.common.RoleEnum;
import com.example.duy_backend.entity.Users;
import com.example.duy_backend.exception.NotFoundException;
import com.example.duy_backend.repository.UserRepo;
import com.example.duy_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public Users createUser(UserReq request) {
        if(userRepo.existsByUsername(request.getUsername())) {
            throw new RuntimeException("ten dang nhap da ton tai");
        }
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(request.getRole());
        log.info("Tao user thanh cong");

        return userRepo.save(user);
    }

    @Override
    public List<UserRes> getAllUsers() {
        List<Users> users = userRepo.findAll();

        List<UserRes> userResList = modelMapper.map(users, new TypeToken<List<UserRes>>() {}
                .getType());
        log.info("Get USER Successfull for ADMIN");

        return userResList;
    }

    @Override
    public Users findById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND, "Không tìm thấy người dùng có ID: " + id));
    }
}
